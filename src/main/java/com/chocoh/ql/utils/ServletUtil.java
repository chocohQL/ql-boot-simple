package com.chocoh.ql.utils;

import com.alibaba.fastjson.JSON;
import com.chocoh.ql.domain.model.Response;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chocoh
 * @Description servlet服务工具类
 * @createTime 2023-12-22 16:41
 */
public class ServletUtil {
    public static HttpServletRequest getHttpServletRequest() {
        return getRequestAttributes().getRequest();
    }

    public static HttpServletResponse getHttpServletResponse() {
        return getRequestAttributes().getResponse();
    }

    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) requestAttributes;
    }

    public static String getRemoteAddr() {
        return getHttpServletRequest().getRemoteAddr();
    }

    public static void outputResponse(int code, String msg) throws IOException {
        String string = JSON.toJSONString(new Response(code, msg, null));
        outputString(string, getHttpServletResponse());
    }

    public static void outputString(String string, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println(string);
    }
}
