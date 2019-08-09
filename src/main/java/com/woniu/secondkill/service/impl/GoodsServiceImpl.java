package com.woniu.secondkill.service.impl;

import com.woniu.secondkill.dao.GoodsMapper;
import com.woniu.secondkill.pojo.Goods;
import com.woniu.secondkill.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    @Cacheable(value = "goods" ,key = "#goodsId")
    public Goods findGoodsByGoodsId(Integer goodsId) {
        Goods  goods = goodsMapper.selectByGoodsId(goodsId);
        return goods;
    }

    @Override
    @Cacheable(value = "onlygoods" ,key = "#goodsId")
    public Goods findGoodByGoodsId(Integer goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }
}
