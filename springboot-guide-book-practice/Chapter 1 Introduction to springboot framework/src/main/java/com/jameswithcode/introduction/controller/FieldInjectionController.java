package com.jameswithcode.introduction.controller;

import com.jameswithcode.introduction.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldInjectionController {

	@Autowired
	MyService myService;


	@GetMapping("/di/hello")
	public String getHello(){
		return myService.getHello();
	}


}
