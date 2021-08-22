package com.elm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elm.entity.Business;
import com.elm.entity.Cart;
import com.elm.entity.Food;
import com.elm.result.CommonResult;
import com.elm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/CartController")
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/listCart/{userId}")
    public CommonResult<List> listCart(@PathVariable String userId){
        Cart param = new Cart();
        param.setUserId(userId);
        List<Cart> carts = cartService.listCart(param);
        List<ServiceInstance> list1 = discoveryClient.getInstances("food-server");   //获取食物服务列表
        List<ServiceInstance> list2 = discoveryClient.getInstances("business-server");  //获取商家服务列表
        for(int i = 0;i<carts.size();i++) {
            String url1 = list1.get(0).getUri() + "/FoodController/getFoodById/" + carts.get(i).getFoodId();
            Food food = restTemplate.getForObject(url1, Food.class);
            carts.get(i).setFood(food);
            String url2 = list2.get(0).getUri() + "/BusinessController/getBusinessInfoById/" + carts.get(i).getBusinessId();
            Business business = restTemplate.getForObject(url2, Business.class);
            carts.get(i).setBusiness(business);
        }
        return new CommonResult<>(200,"success",carts);
       /* for(int i = 0;i<carts.size();i++){
            String url = list1.get(0).getUri()+"/FoodController/getFoodById/"+carts.get(i).getFoodId();
            CommonResult foodCommon = restTemplate.getForObject(url,CommonResult.class);
            //if(foodCommon.getCode() == 200) {
            carts.get(i).setFood((Food) foodCommon.getResult());
            //}
        }*/
    }

    @GetMapping("/listCart/{userId}/{businessId}")
    public CommonResult<List> listCart(@PathVariable("userId") String userId, @PathVariable("businessId") Long businessId) {
        Cart param = new Cart();
        param.setUserId(userId);
        param.setBusinessId(businessId);
        List<Cart> carts = cartService.listCart(param);
        List<ServiceInstance> list1 = discoveryClient.getInstances("food-server");   //获取食物服务列表
        List<ServiceInstance> list2 = discoveryClient.getInstances("business-server");  //获取商家服务列表
        for(int i = 0;i<carts.size();i++) {
            String url1 = list1.get(0).getUri() + "/FoodController/getFoodById/" + carts.get(i).getFoodId();
            String url2 = list2.get(0).getUri() + "/BusinessController/getBusinessInfoById/" + carts.get(i).getBusinessId();
            Food food = restTemplate.getForObject(url1, Food.class);
            Business business = restTemplate.getForObject(url2, Business.class);
            carts.get(i).setFood(food);
            carts.get(i).setBusiness(business);
        }
        return new CommonResult<>(200,"success",carts);
    }
    @PostMapping("/saveCart")
    public CommonResult<Integer> saveCart(@RequestBody Cart cart){
        int i = cartService.saveCart(cart);
        return new CommonResult<>(200,"success",i);
    }

    @PutMapping("/updateCart")
    public CommonResult<Integer> updateCart(@RequestBody Cart cart){
        int i = cartService.updateCart(cart);
        return new CommonResult<>(200,"success",i);
    }

    @DeleteMapping("/deleteCartById/{cartId}")
    public CommonResult<Integer> deleteCartById(@PathVariable Long cartId){
        Cart param = new Cart();
        param.setCartId(cartId);
        int i = cartService.removeCart(param);
        return new CommonResult<>(200,"success",i);
    }



}
