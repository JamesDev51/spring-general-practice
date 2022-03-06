package com.jamesdev.aop.web.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class UpdateReqDto {

    @NotEmpty(message= "password가 입력되지 않았습니다.")
    private String password;
    private String phone;
}
