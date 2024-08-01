package com.chocoh.ql.exception.auth;

import com.chocoh.ql.common.enums.ResultCodeEnum;
import com.chocoh.ql.exception.BusinessException;

/**
 * @author chocoh
 */
public class PasswordErrorException extends BusinessException {
    public PasswordErrorException() {
        super(ResultCodeEnum.PASSWORD_ERROR);
    }
}
