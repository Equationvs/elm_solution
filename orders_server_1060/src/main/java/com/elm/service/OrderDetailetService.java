package com.elm.service;

import com.elm.entity.OrderDetailet;

import java.util.List;

public interface OrderDetailetService {
    public boolean saveOrderDetailetBatch(List<OrderDetailet> list);

    public List<OrderDetailet> listOrderDetailetByOrderId(Long orderId);
}
