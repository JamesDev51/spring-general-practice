package com.jameswithcode.introduction.controller;

import com.jameswithcode.introduction.service.MyServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoDIController {

	private MyServiceImpl myService= new MyServiceImpl();

	@GetMapping("/no-di/hello")
	public String getHello(){
		return myService.getHello();
	}
}
