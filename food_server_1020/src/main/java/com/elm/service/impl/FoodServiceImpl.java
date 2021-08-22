package com.elm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.entity.Food;
import com.elm.mapper.FoodMapper;
import org.springframework.stereotype.Service;
import com.elm.service.FoodService;

import java.util.List;

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Override
    public List<Food> listFoodByBusinessId(Long businessId) {
        QueryWrapper<Food> query = new QueryWrapper();
        query.eq("business_id", businessId);

        List list = baseMapper.selectList(query);
        return list;

    }
}
