package com.chocoh.ql.exception.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotRoleException;
import com.chocoh.ql.common.HttpStatus;
import com.chocoh.ql.domain.model.Response;
import com.chocoh.ql.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chocoh
 */
@Slf4j
@RestControllerAdvice
public class CustomHandlerController {
    @ExceptionHandler(GlobalException.class)
    public Response handlerGlobalException(GlobalException e) {
        return Response.error(e.getMessage());
    }

    @ExceptionHandler(NotRoleException.class)
    public Response handlerNotRoleException() {
        return new Response(HttpStatus.FORBIDDEN, "权限不足", null);
    }

    @ExceptionHandler(NotLoginException.class)
    public Response handlerNotLoginException(NotLoginException nle) {
        String message;
        if(nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            // Authorization
            message = "未能读取到有效 token";
        } else if(nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            // token
            message = "token 无效";
        } else if(nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            // timeout
            message = "token 已过期";
        } else if(nle.getType().equals(NotLoginException.NO_PREFIX)) {
            // Bearer
            message = "未按照指定前缀提交 token";
        } else {
            // login
            message = "当前会话未登录";
        }
        return Response.error(message);
    }
}
