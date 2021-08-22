package com.elm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.entity.Cart;
import com.elm.mapper.CartMapper;
import com.elm.service.CartService;

import java.util.List;

public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    //根据用户的user_id 获得购物车内容
    @Override
    public List<Cart> listCart(Cart cart){
        QueryWrapper<Cart> query = new QueryWrapper();
        query.eq("user_id",cart.getUserId());
        if(cart.getBusinessId()!=null){
            query.eq("business_id",cart.getUserId());
        }
        List<Cart> list = baseMapper.selectList(query);
        return list;

    }

    //保存购物车
    @Override
    public int saveCart(Cart cart){
        return baseMapper.insert(cart);
    }

    //更新购物车
    @Override
    public int updateCart(Cart cart){
        return baseMapper.updateById(cart);
    }

    //删除购物车
    @Override
    public int removeCart(Cart cart){
        return baseMapper.deleteById(cart.getCartId());
    }
}
