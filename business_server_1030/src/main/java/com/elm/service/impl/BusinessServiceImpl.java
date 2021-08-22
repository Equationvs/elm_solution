package com.elm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.entity.Business;
import com.elm.mapper.BusinessMapper;
import com.elm.service.BusinessService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {
    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        //TODO 完成传入类别ID，查询商家的信息。
        //Select("select * from business where orderTypeId=#{orderTypeId} order by businessId")
        QueryWrapper<Business> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_type_id",orderTypeId);
        queryWrapper.orderByAsc("business_id");      //排序
        List<Business> list = baseMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public Business getBusinessById(Long businessId) {
        return baseMapper.selectById(businessId);
    }
}
