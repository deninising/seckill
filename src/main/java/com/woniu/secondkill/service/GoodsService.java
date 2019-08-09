package com.woniu.secondkill.service;

import com.woniu.secondkill.pojo.Goods;

public interface GoodsService {
    public Goods findGoodsByGoodsId(Integer goodsId);

    public Goods findGoodByGoodsId(Integer goodsId);
}
