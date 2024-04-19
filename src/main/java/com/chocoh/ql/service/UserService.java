package com.chocoh.ql.service;

import com.chocoh.ql.domain.entity.User;
import com.chocoh.ql.domain.vo.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author chocoh
 * @createTime 2024-04-06 11:41
 */
@Service
public interface UserService {
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    String login(String username, String password);

    /**
     * 退出登录
     */
    void logout();

    /**
     * 获取用户信息
     * @return 用户信息
     */
    UserInfo me();
}
