package com.chocoh.ql.config;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.chocoh.ql.domain.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static com.chocoh.ql.constant.Constants.*;

/**
 * @author chocoh
 * @createTime 2024-01-28 23:54
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer, StpInterface {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handle -> {
            // 登录校验
            SaRouter.match("/**")
                    .notMatch(
                            "/login",
                            "/register",
                            "/captcha"
                    )
                    .check(r -> StpUtil.checkLogin());
            // 权限校验
            SaRouter.match("/admin", r -> StpUtil.checkRole(ROLE_ADMIN));
        })).addPathPatterns("/**");
    }

    @Bean
    @Primary
    public SaTokenConfig getSaTokenConfigPrimary() {
        SaTokenConfig config = new SaTokenConfig();
        config.setTokenName(TOKEN_NAME);
        config.setTimeout(TOKEN_TTL);
        // token 最低活跃频率（单位：秒），默认-1 代表不限制，永不冻结
        config.setActiveTimeout(-1);
        // 是否允许同一账号多地同时登录
        config.setIsConcurrent(true);
        // 在多人登录同一账号时，是否共用一个 token
        config.setIsShare(true);
        config.setTokenStyle("uuid");
        config.setIsLog(true);
        return config;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        // 登录用户角色校验
        User loginUser = JSON.parseObject(o.toString(), User.class);
        return CollUtil.newArrayList(loginUser.getRole());
    }

    @Override
    public List<String> getPermissionList(Object o, String s) {
        return null;
    }
}
