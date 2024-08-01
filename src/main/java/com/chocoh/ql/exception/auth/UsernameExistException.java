package com.chocoh.ql.exception.auth;

import com.chocoh.ql.common.enums.ResultCodeEnum;
import com.chocoh.ql.exception.BusinessException;

/**
 * @author chocoh
 */
public class UsernameExistException extends BusinessException {
    public UsernameExistException() {
        super(ResultCodeEnum.USERNAME_EXIST);
    }
}
