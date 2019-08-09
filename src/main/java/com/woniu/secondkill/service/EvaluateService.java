package com.woniu.secondkill.service;

import com.woniu.secondkill.pojo.Evaluate;

import java.util.List;

public interface EvaluateService {
    public List<Evaluate> findEvaluateByGoodsId(Integer goodsId);


}
