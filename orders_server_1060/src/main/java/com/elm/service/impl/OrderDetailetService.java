package com.elm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.entity.OrderDetailet;
import com.elm.mapper.OrderDetailetMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailetService extends ServiceImpl<OrderDetailetMapper, OrderDetailet> implements com.elm.service.OrderDetailetService {
    @Override
    public boolean saveOrderDetailetBatch(List<OrderDetailet> list) {
        return this.saveBatch(list);
    }

    @Override
    public List<OrderDetailet> listOrderDetailetByOrderId(Long orderId) {
        QueryWrapper query = new QueryWrapper();
        query.eq("order_id",orderId);
        return baseMapper.selectList(query);
    }
}
