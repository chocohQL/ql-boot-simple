package com.chocoh.ql.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chocoh.ql.domain.entity.User;
import com.chocoh.ql.mapper.UserMapper;
import com.chocoh.ql.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author chocoh
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
