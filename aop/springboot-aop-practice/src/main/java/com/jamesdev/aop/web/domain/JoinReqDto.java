package com.jamesdev.aop.web.domain;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class JoinReqDto {
    @NotEmpty(message = "유저네임 키값이 없습니다.")
    @NotBlank(message="유저네임을 입력하세요.")
    @Size(max = 20,message = "유저네임 길이를 초과하였습니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$\n", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;


    private String phone;
}
