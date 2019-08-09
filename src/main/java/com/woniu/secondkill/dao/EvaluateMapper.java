package com.woniu.secondkill.dao;

import com.woniu.secondkill.pojo.Evaluate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateMapper {
    int deleteByPrimaryKey(Long evaluateId);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Long evaluateId);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);

    List<Evaluate> selectByGoodsId(@Param(value = "goodsId") Integer goodsId);
}