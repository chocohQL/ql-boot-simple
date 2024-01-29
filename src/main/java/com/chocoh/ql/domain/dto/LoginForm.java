package com.chocoh.ql.domain.dto;

import lombok.Data;

/**
 * @author chocoh
 */
@Data
public class LoginForm {
    private String username;
    private String password;
    private String captcha;
}
