package com.chocoh.ql.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chocoh.ql.domain.entity.User;
import com.chocoh.ql.domain.vo.UserInfo;
import com.chocoh.ql.exception.GlobalException;
import com.chocoh.ql.mapper.UserMapper;
import com.chocoh.ql.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chocoh
 * @createTime 2024-04-06 11:41
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String password) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username));
        if (user == null) {
            throw new GlobalException("账号不存在");
        }
        if (DigestUtil.bcryptCheck(password, user.getPassword())) {
            StpUtil.login(user.getId());
            return StpUtil.getTokenInfo().getTokenValue();
        } else {
            throw new GlobalException("密码错误");
        }
    }

    @Override
    public void logout() {
        StpUtil.logout();
    }

    @Override
    public UserInfo me() {
        User user = userMapper.selectById(StpUtil.getLoginIdAsLong());
        return getUserInfo(user);
    }

    private UserInfo getUserInfo(User user) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user, userInfo);
        return userInfo;
    }
}
