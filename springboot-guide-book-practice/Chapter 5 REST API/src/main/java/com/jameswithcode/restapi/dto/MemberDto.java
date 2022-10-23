package com.jameswithcode.restapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString
public class MemberDto {

	private String name;
	private String email;
	private String organization;
}
