package com.woniu.secondkill.dao;

import com.woniu.secondkill.pojo.PromotionSeckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromotionSeckillMapperTest {
    @Autowired
    private PromotionSeckillMapper promotionSeckillMapper;


    @Test
    public void fingAllTest(){
        List<PromotionSeckill> promotionSeckills = promotionSeckillMapper.selectAllUnstartPromotion();
        System.out.println(promotionSeckills);
    }

}