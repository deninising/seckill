package com.woniu.secondkill.controller;

import com.woniu.secondkill.pojo.Evaluate;
import com.woniu.secondkill.pojo.Goods;
import com.woniu.secondkill.service.EvaluateService;
import com.woniu.secondkill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@RequestMapping(value = "/goods")
@Controller
@CrossOrigin//允许跨域访问
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private EvaluateService evaluateService;

    @Value("${template.path}")
    private String path ;

    @Autowired
    private TemplateEngine engine;

    @RequestMapping(value = "/showdetails/{goodsId}")
    public ModelAndView showgoods(@PathVariable("goodsId") Integer goodsId){
        Goods goodsByGoodsId = goodsService.findGoodsByGoodsId(goodsId);
        List<Evaluate> evaluateByGoodsId = evaluateService.findEvaluateByGoodsId(goodsId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsDetail");
        modelAndView.addObject("goods", goodsByGoodsId);
        modelAndView.addObject("evaluates", evaluateByGoodsId);
        return modelAndView;
    }

    @RequestMapping(value = "/staticprocess/{goodsId}")
    @ResponseBody
    public String staticprocess(@PathVariable(value = "goodsId")Integer goodsId) {

        //查询数据库数据
        Goods goodsByGoodsId = goodsService.findGoodsByGoodsId(goodsId);
        List<Evaluate> evaluates = evaluateService.findEvaluateByGoodsId(goodsId);

        Context context = new Context();
        context.setVariable("goods", goodsByGoodsId);
        context.setVariable("evaluates", evaluates);


        File file = new File(path);//创建目录对象：e:/template/goods/showdetails/
        if (! file.exists()){
            file.mkdirs();//递归创建目录，如果不存在
        }

        //创建文件
        File f = new File(file, goodsId + ".html");
        //创建字符型输出流，准备写到磁盘上
        Writer writer = null;
        try {
            writer = new FileWriter(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //开启模板引起调用静态处理方法
        engine.process("goodsDetail", context, writer);

        return "ok";
    }
}

