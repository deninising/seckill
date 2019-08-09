package com.woniu.secondkill.service.impl;

import com.woniu.secondkill.dao.PromotionSeckillMapper;
import com.woniu.secondkill.myexception.SecKillException;
import com.woniu.secondkill.pojo.PromotionSeckill;
import com.woniu.secondkill.service.PromotionSecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionSecKillImpl implements PromotionSecKillService {
    @Autowired
    private PromotionSeckillMapper promotionSeckillMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void processkSecKill(Long psId, Integer userId) {
        //活动未开始
        PromotionSeckill promotionSeckill  = promotionSeckillMapper.selectByPrimaryKey(psId);
        if (promotionSeckill.getStatus() != 1) {
            throw new SecKillException("活动未开始!");
        }

        //不能重复抢购
        boolean isMenber = redisTemplate.opsForSet().isMember("promotion:user"+userId, psId);
        if (isMenber) {
            throw new SecKillException("不能重复抢购同一商品");
        }

        //商品已售罄
        Object pop =redisTemplate.opsForList().leftPop("promotion:" + psId);
        if (pop == null) {
            throw new SecKillException("该商品平已售罄");
        }
        //正常抢购
        redisTemplate.opsForSet().add("promotion:user"+userId,psId);
    }
}
