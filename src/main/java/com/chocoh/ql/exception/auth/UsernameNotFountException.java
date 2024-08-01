package com.chocoh.ql.exception.auth;

import com.chocoh.ql.common.enums.ResultCodeEnum;
import com.chocoh.ql.exception.BusinessException;

/**
 * @author chocoh
 */
public class UsernameNotFountException extends BusinessException {
    public UsernameNotFountException() {
        super(ResultCodeEnum.USERNAME_NOT_FOUNT);
    }
}
