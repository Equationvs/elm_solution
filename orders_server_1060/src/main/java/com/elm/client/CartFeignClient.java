package com.elm.client;

import com.elm.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("cart-server")            //参数就是 nacos 食品工程服务名
@Component
public interface CartFeignClient {
    @GetMapping("/CartController/listCart/{userId}/{businessId}")
    public CommonResult<List> listCart(@PathVariable("userId") String userId, @PathVariable("businessId") Long businessId);

    @DeleteMapping("/CartController/removeCart/{userId}/{businessId}/{foodId}")
    public CommonResult<Integer> removeCart(
            @PathVariable("userId") String userId,
            @PathVariable("businessId") Long businessId,
            @PathVariable("foodId") Long foodId
    );
}
