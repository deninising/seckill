package com.woniu.secondkill.dao;

import com.woniu.secondkill.pojo.GoodsDetail;

public interface GoodsDetailMapper {
    int deleteByPrimaryKey(Integer gdId);

    int insert(GoodsDetail record);

    int insertSelective(GoodsDetail record);

    GoodsDetail selectByPrimaryKey(Integer gdId);

    int updateByPrimaryKeySelective(GoodsDetail record);

    int updateByPrimaryKey(GoodsDetail record);
}