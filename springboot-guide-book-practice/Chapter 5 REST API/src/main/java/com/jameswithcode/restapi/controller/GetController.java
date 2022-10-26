package com.jameswithcode.restapi.controller;

import com.jameswithcode.restapi.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

	@RequestMapping(value="/hello",method= RequestMethod.GET)
	public String getHello()
	{
		log.info("getHello 호출");
		log.debug("getHello 호출");
		return "Hello World";
	}

	@GetMapping("/name")
	public String getName(){
		log.info("getName 호출");
		log.debug("getName 호출");
		return "Flature";
	}

	@GetMapping("/variable1/{variable}")
	public String getVariable1(@PathVariable String variable){
		log.info("getVariable 호출: {}",variable);
		log.debug("getVariable 호출: {}",variable);
		return variable;
	}

	@ GetMapping(value="/variable2/{variable}")
	public String getVariable2(@PathVariable(value="variable") String var){
		return var;
	}

	@ApiOperation(value="GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method") //api 설명 작성
	@GetMapping(value = "/request1")
	public String getRequestParam1(
			@ApiParam(value = "이름",readOnly = true) @RequestParam String name, //매개변수에 대한 설명 및 설정
			@ApiParam(value = "이메일",readOnly = true) @RequestParam String email,
			@ApiParam(value = "회사",readOnly = true) @RequestParam String organization){
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
