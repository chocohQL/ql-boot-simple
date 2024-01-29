package com.chocoh.ql.service;

import org.springframework.stereotype.Service;

/**
 * @author chocoh
 */
@Service
public interface LoginService {
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
}
