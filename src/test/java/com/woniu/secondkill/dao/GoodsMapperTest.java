package com.woniu.secondkill.dao;

import com.woniu.secondkill.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsMapperTest {
    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void selectByGoodsId() {
        Goods goods = goodsMapper.selectByGoodsId(867);
        System.out.println(goods);
    }
}