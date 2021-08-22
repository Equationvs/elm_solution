package com.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.entity.Order;

import java.util.List;

public interface OrderService extends IService<Order> {

    //创建订单
    public Long createOrders(Order order);
    //通过订单编号获得订单对象
    public Order getOrdersById(Long orderId);
    //通过用户id获得该用户所有订单信息 列表
    public List<Order> listOrdersByUserId(String userId);
    //创建订单
    public Integer saveOrder(Order order);

}
