package com.woniu.secondkill.controller;

import com.woniu.secondkill.dao.PromotionSeckillMapper;
import com.woniu.secondkill.pojo.Evaluate;
import com.woniu.secondkill.pojo.Goods;
import com.woniu.secondkill.service.EvaluateService;
import com.woniu.secondkill.service.GoodsService;
import com.woniu.secondkill.service.PromotionSecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "/promotion")
public class PromotionSecKillController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private PromotionSecKillService promotionSecKillService;




    @RequestMapping(value = "/showPromotions")
    public ModelAndView showPromotions() {
        ModelAndView modelAndView = new ModelAndView();

        Map promotionEntries = redisTemplate.opsForHash().entries("promotionSeckill:running");
        modelAndView.addObject("promotions", promotionEntries);
        modelAndView.setViewName("seckillgoods");
        return modelAndView;
    }

    @RequestMapping(value = "/seckillgoodsDetail/{goodsId}/{psId}")
    public ModelAndView seckillgoodsDetail(@PathVariable(value = "goodsId") Integer goodsId,
                                           @PathVariable(value = "psId") long psId) {
        Goods goods = goodsService.findGoodsByGoodsId(goodsId);
        List<Evaluate> evaluates = evaluateService.findEvaluateByGoodsId(goodsId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("goods", goods);
        mv.addObject("evaluates", evaluates);
        mv.addObject("psId", psId);
        mv.setViewName("seckillDetail");
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/processSecKill/{psId}/{userId}")
    public Map processSecKill(@PathVariable(value = "psId") long psId,
                              @PathVariable(value = "userId") Integer userId) {
        Map<String, Object> map = new HashMap<>();
        try {
            promotionSecKillService.processkSecKill(psId, userId);
            //生成订单
            Map data = new HashMap();
            data.put("orderNo", UUID.randomUUID());
            map.put("code",0);
            map.put("message", "请购成功，正在创建订单...");
            map.put("data",data);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 500);
            map.put("message", e.getMessage());
        }
        return map;
    }


    @RequestMapping("/checkOrder")
    public ModelAndView checkOrder(){
        ModelAndView modelAndView= new ModelAndView("goodorder");
        //加载联系方式
        return modelAndView;
    }
}
