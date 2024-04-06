package com.chocoh.ql.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.chocoh.ql.domain.entity.User;
import com.chocoh.ql.mapper.UserMapper;
import com.chocoh.ql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chocoh
 * @createTime 2024-04-06 11:41
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User me() {
        return userMapper.selectById(StpUtil.getLoginIdAsLong());
    }
}
