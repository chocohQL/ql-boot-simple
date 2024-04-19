package com.chocoh.ql.controller;

import com.chocoh.ql.domain.dto.AuthForm;
import com.chocoh.ql.domain.model.Response;
import com.chocoh.ql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author chocoh
 * @createTime 2024-04-06 11:41
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Response login(@RequestBody @Validated AuthForm authForm) {
        return Response.success(userService.login(authForm.getUsername(), authForm.getPassword()));
    }

    @PostMapping("/logout")
    public Response logout() {
        userService.logout();
        return Response.success();
    }

    @GetMapping("/me")
    public Response me() {
        return Response.success(userService.me());
    }

}
