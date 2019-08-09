package com.woniu.secondkill.scheduler;

import com.woniu.secondkill.dao.PromotionSeckillMapper;
import com.woniu.secondkill.pojo.Goods;
import com.woniu.secondkill.pojo.PromotionSeckill;
import com.woniu.secondkill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class PromotionSeckillScheduler {
    @Autowired
    private PromotionSeckillMapper promotionSeckillMapper;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 将秒杀活动存到redis缓存中去
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void findCurrentPromotion() {
        //以map的方式存放活动数据,活动id为键，商品对象为值
        HashMap<String, Object> map = new HashMap<>();
        List<PromotionSeckill> promotions = promotionSeckillMapper.selectAllUnstartPromotion();
        for (PromotionSeckill p : promotions) {
            Goods goods = goodsService.findGoodByGoodsId(p.getGoodsId());
            map.put(p.getPsId().toString(), goods);
            //更新活动状态
            p.setStatus(1);
            promotionSeckillMapper.updateByPrimaryKey(p);
            //将参加的活动商品实例，以活动Id+商品Id的形式存放于redis中的list数据类型
            for(int i = 0;i<p.getPsCount();i++){
                redisTemplate.opsForList().leftPush("promotion:"+p.getPsId(), p.getGoodsId());
                redisTemplate.expire("promotion:"+p.getPsId(), 2L, TimeUnit.HOURS);
            }
        }
        redisTemplate.opsForHash().putAll("promotionSeckill:running", map);
        redisTemplate.expire("promotionSeckill:running",2L, TimeUnit.HOURS);
    }
}
