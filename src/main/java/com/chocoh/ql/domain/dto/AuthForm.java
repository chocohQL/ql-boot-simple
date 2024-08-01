package com.chocoh.ql.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.chocoh.ql.common.constant.Constants.PATTERN_PASSWORD;
import static com.chocoh.ql.common.constant.ResponseMsg.VALIDATE_PASSWORD;
import static com.chocoh.ql.common.constant.ResponseMsg.VALIDATE_USERNAME;

/**
 * @author chocoh
 */
@Data
public class AuthForm {
    @NotNull
    @Size(min = 1, max = 16, message = VALIDATE_USERNAME)
    private String username;
    @NotNull
    @Pattern(regexp = PATTERN_PASSWORD, message = VALIDATE_PASSWORD)
    private String password;
}
