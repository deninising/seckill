package com.woniu.secondkill.dao;

import com.woniu.secondkill.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    Goods selectByGoodsId(@Param("goodsId") Integer goodsId);

    @Select("select * from t_goods where last_update_time>now()-interval 10 minute")
    List<Goods> selectForUpdateInLast10Min();
}