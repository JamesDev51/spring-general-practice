package com.jameswithcode.restapi.controller;

import com.jameswithcode.restapi.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

	@RequestMapping(value="/domain",method= RequestMethod.POST)
	public String	postExample(){
		return "Hello Post API";
	}

	@PostMapping("/member")
	public String postMember(@RequestBody Map<String,Object> postData){
		StringBuilder sb = new StringBuilder();

		postData.forEach((key,value)->sb.append(key).append(":").append(value).append("\n"));
		return sb.toString();
	}

	@PostMapping(value="/member2")
	public String postMemberDto(@RequestBody MemberDto memberDto){
		return memberDto.toString();
	}
}
