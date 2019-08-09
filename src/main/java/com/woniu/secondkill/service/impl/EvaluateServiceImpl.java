package com.woniu.secondkill.service.impl;

import com.woniu.secondkill.dao.EvaluateMapper;
import com.woniu.secondkill.pojo.Evaluate;
import com.woniu.secondkill.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    @Cacheable(value = "evaluate" ,key = "#goodsId")
    public List<Evaluate> findEvaluateByGoodsId(Integer goodsId) {
        List<Evaluate> evaluates = evaluateMapper.selectByGoodsId(goodsId);
        return evaluates;
    }
}
