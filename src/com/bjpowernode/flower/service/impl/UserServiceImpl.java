package com.bjpowernode.flower.service.impl;

import com.bjpowernode.flower.bean.User;
import com.bjpowernode.flower.mapper.UserMapper;
import com.bjpowernode.flower.service.UserService;
import com.bjpowernode.flower.util.MyBatisUtil;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author 付 尧
 * @Date 2020/10/29 23:39
 * @Version
 */
public class UserServiceImpl implements UserService {

    private UserMapper userMapper = MyBatisUtil.getSqlSession().getMapper(UserMapper.class);

    @Override
    public User login(User user) {


        return userMapper.login(user);
    }
}
