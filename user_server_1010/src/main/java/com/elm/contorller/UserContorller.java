package com.elm.contorller;

import com.elm.entity.User;
import com.elm.result.CommonResult;
import com.elm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/UserController")
public class UserContorller {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserByIdByPwd/{userId}/{password}")
    public CommonResult<User> getUserByIdByPwd(
            @PathVariable String userId,@PathVariable String password){
        //将传递进来的userId和password参数封装成User对象
        User param = new User();
        param.setUserId(userId);
        param.setPassword(password);
        //调用UserService中的方法getUserByIdByPwd，传递User对象
        User user = userService.getUserByIdByPwd(param);
        return new CommonResult<User>(200,"success",user);
    }

    @GetMapping("/getUserById/{userId}")
    public CommonResult<Integer> getUserById(@PathVariable String userId){
        int count = userService.getUserById(userId);
        return new CommonResult<Integer>(200,"success",count);
    }

    @PostMapping("/saveUser")
    public CommonResult<Integer> saveUser(@RequestBody User user){
        int i = userService.saveUser(user);
        return new CommonResult<>(200,"success",i);
    }
}
