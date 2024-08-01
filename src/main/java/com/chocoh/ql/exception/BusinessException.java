package com.chocoh.ql.exception;

import com.chocoh.ql.common.enums.ResultCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author chocoh
 */
@Getter
@Setter
public class BusinessException extends RuntimeException {
    private ResultCodeEnum resultCodeEnum;

    public BusinessException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
    }
}
