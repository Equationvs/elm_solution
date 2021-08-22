package com.elm.controller;
import ch.qos.logback.core.util.COWArrayList;
import com.elm.client.FoodFeignClient;
import com.elm.entity.Business;
import com.elm.entity.Food;
import com.elm.result.CommonResult;
import com.elm.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/BusinessController")
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private FoodFeignClient foodFeignClient;

    //商家的控制器，调用食品的服务---端口，返回端口到页面
    @GetMapping("/getFoodPort")
    public String getFoodPort(){
       return foodFeignClient.getPort();
        //直接调用接口getPort()方法，就相当于调用了食品工程中的/FoodController/port路径的方法
//        String url = "http://food-server/FoodController/port";
//        return restTemplate.getForObject(url,String.class);
    }

    @GetMapping("/listBusinessByOrderTypeId/{orderTypeId}")  //美食 orderTypeId = 1
    public CommonResult<List<Business>> listBusinessByOrderTypeId(@PathVariable Integer orderTypeId){
        List<Business> list = businessService.listBusinessByOrderTypeId(orderTypeId);
        return new CommonResult<List<Business>>(200,"success",list);
    }

    @GetMapping("/instances")
    public List<ServiceInstance> getInstances(){
        //得到nacos注册中心上所有的服务列表 ,参数服务名
        List<ServiceInstance> list = discoveryClient.getInstances("food-server");
        return list;
    }

    @GetMapping("/getBusinessById/{businessId}")
    public CommonResult<Business> getBusinessById(@PathVariable Long businessId){
        //首先查询商家的信息
        Business business = businessService.getBusinessById(businessId);
        CommonResult<List<Food>> foodCommon = foodFeignClient.listFoodByBuinessId(businessId);

        if(foodCommon.getCode() == 200){
            business.setFoodList((List<Food>)foodCommon.getResult());
        }else{
            //返回商家缓存中兜底数据
            business.setFoodList(new ArrayList<>());
        }
        return new CommonResult<>(200,"success",business);
        /*
        //首先查询商家的信息
        Business business = businessService.getBusinessById(businessId);
        //food-server 为nacos中食物工程启动后在nacos中的注册名  spring.application.name:
        String url = "http://food-server/FoodController/listFoodByBuinessId/" + businessId;
        //使用RestTemplate调用 url里面的路径 服务，获取数据。
        CommonResult foodCommon = restTemplate.getForObject(url,CommonResult.class);
        if(foodCommon.getCode() == 200){
            business.setFoodList((List<Food>)foodCommon.getResult());
        }
        return new CommonResult<>(200,"success",business);



        //business中只是商家的信息，没有食品信息
        //跨服务查询 食品工程
        //CommonResult foodCommon = restTemplate.getForObject("http://localhost:1020/FoodController/listFoodByBuinessId/" + businessId, CommonResult.class);
        //if(foodCommon.getCode() == 200){
        //   business.setFoodList((List<Food>)foodCommon.getResult());
        //}

        //从nacos取数据。 RestTemplate
        //获取服务列表  **Ribbon自动获取服务列表
        //List<ServiceInstance> list = discoveryClient.getInstances("food-server");

        //从服务列表查找 下标为1的服务，获取这个服务uri
        //uri就是服务的请求地址    组成:IP:端口
        //在uri的基础上添加 后面的访问路径 "/FoodController/listFoodByBuinessId/" + businessId
        //组册了新的请求路径存入 url变量
        //String url = list.get(1).getUri() + "/FoodController/listFoodByBuinessId/" + businessId;
        */

    }
}












