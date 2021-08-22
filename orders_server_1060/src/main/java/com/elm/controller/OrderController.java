package com.elm.controller;

import com.elm.entity.Order;
import com.elm.result.CommonResult;
import com.elm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderController")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrdersById/{orderId}")
    public CommonResult<Order> getOrdersById(@PathVariable Long orderId){
        Order order = orderService.getOrdersById(orderId);
        return new CommonResult<>(200,"success",order);
    }


    @PostMapping("/createOrders")
    public CommonResult<Long> createOrder(@RequestBody Order order){
//        Order param = new Order();
//        param.setUserId(userId);
//        param.setBusinessId(businessId);
//        param.setDaId(daId);
//        param.setOrderTotal(orderTotal);
        Long count = orderService.createOrders(order);
        return new CommonResult<>(200,"success",count);
    }

    @GetMapping("/listOrdersByUserId/{userId}")
    public CommonResult<List> listOrdersByUserId(@PathVariable("userId") String userId){
        List<Order> list = orderService.listOrdersByUserId(userId);
        return new CommonResult(200,"success",list);
    }
}
