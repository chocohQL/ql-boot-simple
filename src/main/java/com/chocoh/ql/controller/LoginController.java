package com.chocoh.ql.controller;

import com.chocoh.ql.domain.model.Response;
import com.chocoh.ql.domain.dto.LoginForm;
import com.chocoh.ql.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chocoh
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Response login(@RequestBody LoginForm loginForm) {
        return Response.success(loginService.login(loginForm.getUsername(), loginForm.getPassword()));
    }

    @PostMapping("/logout")
    public Response logout() {
        loginService.logout();
        return Response.success();
    }
}