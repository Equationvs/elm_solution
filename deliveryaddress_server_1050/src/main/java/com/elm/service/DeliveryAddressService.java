package com.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.entity.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService extends IService<DeliveryAddress> {

    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);

    public DeliveryAddress getDeliveryAddressById(Long daId);

    public int saveDeliveryAddress(DeliveryAddress deliveryAddress);

    public int updateDeliveryAddress(DeliveryAddress deliveryAddress);

    public int removeDeliveryAddress(Long daId);

}
