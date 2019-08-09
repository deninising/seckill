package com.woniu.secondkill.dao;

import com.woniu.secondkill.pojo.GoodsParam;

public interface GoodsParamMapper {
    int deleteByPrimaryKey(Integer gpId);

    int insert(GoodsParam record);

    int insertSelective(GoodsParam record);

    GoodsParam selectByPrimaryKey(Integer gpId);

    int updateByPrimaryKeySelective(GoodsParam record);

    int updateByPrimaryKey(GoodsParam record);
}