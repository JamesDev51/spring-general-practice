package com.jamesdev.springbootaoppractice.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateReqDto {

    @NotBlank(message= "password가 입력되지 않았습니다.")
    private String password;
    private String phone;
}
