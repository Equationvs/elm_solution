package com.elm.controller;

import com.elm.entity.Food;
import com.elm.result.CommonResult;
import com.elm.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FoodController")
public class FoodController {
    @Autowired
    FoodService foodService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    public String getPort(){
        return this.port;
    }

    @GetMapping("/listFoodByBuinessId/{businessId}")
    public CommonResult<List<Food>> listFoodByBuinessId(@PathVariable Long businessId){
        List<Food> foods = foodService.listFoodByBusinessId(businessId);
        return new CommonResult<List<Food>>(200,"success",foods);
    }


}










