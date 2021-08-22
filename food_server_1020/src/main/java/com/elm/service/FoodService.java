package com.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.entity.Food;

import java.util.List;

public interface FoodService extends IService<Food> {
    //通过商家id，获得该商家的食品信息
    public List<Food> listFoodByBusinessId(Long businessId);
}
