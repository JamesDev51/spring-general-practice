package com.jameswithcode.restapi.controller;

import com.jameswithcode.restapi.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

	@RequestMapping(value="/hello",method= RequestMethod.GET)
	public String getHello(){
		return "Hello World";
	}

	@GetMapping("/name")
	public String getName(){
		return "Flature";
	}

	@GetMapping("/variable1/{variable}")
	public String getVariable1(@PathVariable String variable){
		return variable;
	}

	@ GetMapping(value="/variable2/{variable}")
	public String getVariable2(@PathVariable(value="variable") String var){
		return var;
	}

	@GetMapping(value = "/request1")
	public String getRequestParam1(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String organization){
		return name+" "+email+" "+organization;
	}

	@GetMapping(value = "/request2")
	public String getRequestParam2(@RequestParam Map<String,String> param){
		StringBuilder sb= new StringBuilder();

		param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
		return sb.toString();
	}

	@GetMapping(value="/request3")
	public String RequestParam3(MemberDto memberDto){
		return memberDto.toString();
	}

}
