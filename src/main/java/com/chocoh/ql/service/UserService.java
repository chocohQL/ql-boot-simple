package com.chocoh.ql.service;

import com.chocoh.ql.domain.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author chocoh
 * @createTime 2024-04-06 11:41
 */
@Service
public interface UserService {

    /**
     * 获取用户信息
     * @return user
     */
    User me();
}
