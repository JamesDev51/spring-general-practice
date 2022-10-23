package com.jameswithcode.restapi.controller;

import com.jameswithcode.restapi.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutMapping {

	@RequestMapping(value="/member")
	public String postMember(@RequestBody Map<String,Object>putData){
		StringBuilder sb = new StringBuilder();

		putData.forEach((key,value)->sb.append(key).append(" : ").append(value));
		return sb.toString();
	}

	@org.springframework.web.bind.annotation.PutMapping(value="member1")
	public String postMemberDto1(@RequestBody MemberDto memberDto){
		return memberDto.toString();
	}

	@org.springframework.web.bind.annotation.PutMapping(value="member2")
	public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
		return memberDto;
	}

	@org.springframework.web.bind.annotation.PutMapping(value="/member3")
	public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(memberDto);
	}

}
