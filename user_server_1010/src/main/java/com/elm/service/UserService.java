package com.elm.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.elm.entity.User;
public interface UserService extends IService<User> {
    //根据id和psssword查询用户对象
    public User getUserByIdByPwd(User user);
    //查询是等于id的用户的个数
    public int getUserById(String userId);
    //保存用户
    public int saveUser(User user);
}
