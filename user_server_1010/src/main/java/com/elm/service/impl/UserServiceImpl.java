package com.elm.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elm.entity.User;
import com.elm.mapper.UserMapper;
import com.elm.service.UserService;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Override
    public User getUserByIdByPwd(User user) {
        //创建条件查询对象 query
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("user_id",user.getUserId());
        query.eq("password",user.getPassword());

        User result = baseMapper.selectOne(query);
        return result;
    }

    @Override
    public int getUserById(String userId) {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("user_id",userId);

        Integer count = baseMapper.selectCount(query);
        return count;
    }

    @Override
    public int saveUser(User user) {
        return baseMapper.insert(user);
    }
}
