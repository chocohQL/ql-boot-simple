package com.chocoh.ql.controller;

import com.chocoh.ql.domain.model.Response;
import com.chocoh.ql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chocoh
 * @createTime 2024-04-06 11:41
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public Response me() {
        return Response.success(userService.me());
    }

}
