package com.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.entity.Food;

import java.util.List;

public interface FoodService extends IService<Food> {
    public List<Food> listFoodByBusinessId(Long businessId);
}
