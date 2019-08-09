package com.woniu.secondkill.dao;

import com.woniu.secondkill.pojo.GoodsCover;

public interface GoodsCoverMapper {
    int deleteByPrimaryKey(Integer gcId);

    int insert(GoodsCover record);

    int insertSelective(GoodsCover record);

    GoodsCover selectByPrimaryKey(Integer gcId);

    int updateByPrimaryKeySelective(GoodsCover record);

    int updateByPrimaryKey(GoodsCover record);
}