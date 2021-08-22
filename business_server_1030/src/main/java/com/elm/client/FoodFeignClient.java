package com.elm.client;

import com.elm.entity.Food;
import com.elm.feign.BusinessFeignClientCallBack;
import com.elm.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//调用food-server服务的接口
@FeignClient(name="food-server",fallback = BusinessFeignClientCallBack.class)            //参数就是 nacos 食品工程服务名
@Component
public interface FoodFeignClient {
    //写 商家要调用的  食品的方法定义----获得端口的方法
    //@GetMapping 参数需要写全路径
    @GetMapping("/FoodController/port")
    public String getPort();

    @GetMapping("/FoodController/listFoodByBuinessId/{businessId}")
    public CommonResult<List<Food>> listFoodByBuinessId(@PathVariable("businessId") Long businessId);
}
