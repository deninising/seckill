package com.woniu.secondkill.scheduler;

import com.woniu.secondkill.dao.GoodsMapper;
import com.woniu.secondkill.pojo.Evaluate;
import com.woniu.secondkill.pojo.Goods;
import com.woniu.secondkill.service.EvaluateService;
import com.woniu.secondkill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class GoodsScheduler {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private GoodsMapper goodsMapper;

    @Value("${template.path}")
    private String path;

    @Autowired
    private TemplateEngine templateEngine;

    @Scheduled(cron="0 30 * * * ?")
    public void goodsSchedule(){
        List<Goods> goodsList = goodsMapper.selectForUpdateInLast10Min();
        for (Goods goods:goodsList ){
            Goods goodsByGoodsId = goodsService.findGoodsByGoodsId(goods.getGoodsId());
            List<Evaluate> evaluate = evaluateService.findEvaluateByGoodsId(goods.getGoodsId());

            Context context = new Context();
            context.setVariable("goods", goodsByGoodsId);
            context.setVariable("evaluates", evaluate);


            File file = new File(path);
            if (!file.exists()){
                file.mkdirs();
            }

            File f = new File(path, goods.getGoodsId() + ".html");
                FileWriter fileWriter = null;
            try {
                 fileWriter = new FileWriter(f);
            } catch (IOException e) {
                e.printStackTrace();
            }

            templateEngine.process("goodsDetail", context, fileWriter);
        }
    }
}
