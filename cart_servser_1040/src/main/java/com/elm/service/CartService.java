package com.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.entity.Cart;

import java.util.List;

public interface CartService extends IService<Cart> {

    //根据用户的user_id 获得购物车内容
    public List<Cart> listCart(Cart cart);
    //保存购物车
    public int saveCart(Cart cart);
    //更新购物车
    public int updateCart(Cart cart);
    //删除购物车
    public int removeCart(Cart cart);
}
