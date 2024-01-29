package com.chocoh.ql.exception.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotRoleException;
import com.chocoh.ql.constant.HttpStatus;
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
            message = "未能读取到有效 token";
        }
        else if(nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token 无效";
        }
        else if(nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token 已过期";
        }
        else if(nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token 已被顶下线";
        }
        else if(nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token 已被踢下线";
        }
        else if(nle.getType().equals(NotLoginException.TOKEN_FREEZE)) {
            message = "token 已被冻结";
        }
        else if(nle.getType().equals(NotLoginException.NO_PREFIX)) {
            message = "未按照指定前缀提交 token";
        }
        else {
            message = "当前会话未登录";
        }
        return Response.error(message);
    }
}
