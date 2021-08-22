package com.elm.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.client.CartFeignClient;
import com.elm.entity.Cart;
import com.elm.entity.Order;
import com.elm.entity.OrderDetailet;
import com.elm.mapper.OrderMapper;
import com.elm.result.CommonResult;
import com.elm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    //Feign的调用，购物车服务(nacos)
    @Autowired
    private CartFeignClient cartFeignClient;
    //保存订单，就需要保存订单的明细
    @Autowired
    private OrderDetailetService orderDetailetService;

    @Override
    public Long createOrders(Order order) {
        Long orderId =0L;
        //查询当前用户购物车中当前商家的所有商品
        CommonResult<List> listCommonResult = cartFeignClient.listCart(order.getUserId(), order.getBusinessId());
        List<Cart> cartList = listCommonResult.getResult();
        //创建订单
        //TODO订单状态 付款
        Integer result = this.saveOrder(order);  //result  保存的订单ID
        if(result>0){
            orderId = order.getOrderId();
            System.out.println(orderId);

            //批量添加订单明细
            List<OrderDetailet> list = new ArrayList<>();
            for(int i=0;i<cartList.size();i++){
                //LinkedHashMap转换 List<Cart>
                Cart c = JSON.parseObject(JSON.toJSONString(cartList.get(i)), Cart.class);
                OrderDetailet od = new OrderDetailet();
                od.setOrderId(orderId);
                od.setFoodId(c.getFoodId());
                od.setQuantity(c.getQuantity());
                list.add(od);
            }
            orderDetailetService.saveOrderDetailetBatch(list);  //将集合中所有购买的食品保存订单明细表

            //从购物车删除相关食品信息
            for(int i=0;i<cartList.size();i++){
                Cart c = JSON.parseObject(JSON.toJSONString(cartList.get(i)), Cart.class);
                System.out.println(c.getUserId()+" "+c.getBusinessId()+" "+c.getFoodId());
                cartFeignClient.removeCart(c.getUserId(),c.getBusinessId(),c.getFoodId());
            }

            return orderId;
        }else{
            return 0L;
        }
    }

    @Override
    public Order getOrdersById(Long orderId) {

        return baseMapper.selectById(orderId);
    }

    @Override
    public List<Order> listOrdersByUserId(String userId) {
        return null;
    }

    @Override
    public Integer saveOrder(Order order) {
        return baseMapper.insert(order);
    }
}
