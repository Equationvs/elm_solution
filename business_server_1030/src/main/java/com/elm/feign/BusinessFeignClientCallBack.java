package com.elm.feign;

import com.elm.client.FoodFeignClient;
import com.elm.entity.Food;
import com.elm.result.CommonResult;
import org.springframework.stereotype.Component;

import java.util.List;
//使用@Feign 定义的 client.FoodFeignClient
//getPort() 服务调用获得食品 工程端口
//listFoodByBuinessId 服务调用 传递商家id获得 食品数据

//com.elm.client.FoodFeignClient    正常 调用Feign获得数据
//com.elm.feign.BusinessFeignClientCallBack     断熔以后  执行方法
@Component
public class BusinessFeignClientCallBack implements FoodFeignClient {
    @Override
    public String getPort() {
        return "触发了熔断降级方法";
    }

    @Override
    public CommonResult<List<Food>> listFoodByBuinessId(Long businessId) {
        //商家获得 食品 数据 , 缓存的数据（托底数据）
        return new CommonResult<>(403,"fegin触发了熔断降级方法",null);
    }
}
