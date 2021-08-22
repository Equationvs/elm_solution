package com.elm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.entity.DeliveryAddress;
import com.elm.mapper.DeliveryAddressMapper;
import com.elm.service.DeliveryAddressService;

import java.util.List;

public class DelivertAddressServiceImpl extends ServiceImpl<DeliveryAddressMapper,DeliveryAddress> implements DeliveryAddressService {
    //select * from deliveryAddress where userId=? orderby daId
    @Override
    public List<DeliveryAddress>
    listDeliveryAddressByUserId(String userId) {
        QueryWrapper<DeliveryAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.orderByAsc("da_id");
        List<DeliveryAddress> list = baseMapper.selectList(queryWrapper);
        return list;
    }
    //根据da_id获得该条配送地址
    //select * from deliveryAddress where daId=?
    @Override
    public DeliveryAddress getDeliveryAddressById(Long daId) {
        return baseMapper.selectById(daId);
    }
    //保存配送地址
    @Override
    public int saveDeliveryAddress(DeliveryAddress
                                           deliveryAddress) {
        return baseMapper.insert(deliveryAddress);
    }
    //更新配送地址
    //update deliveryAddress setcontactName=?,contactSex=?,contactTel=?,address=? wheredaId=?
    @Override
    public int updateDeliveryAddress(DeliveryAddress
                                             deliveryAddress) {
        return baseMapper.updateById(deliveryAddress);
    }
    //移除配送地址
    //delete from deliveryAddress where daId=?
    @Override
    public int removeDeliveryAddress(Long daId) {
        return baseMapper.deleteById(daId);
    }

}
