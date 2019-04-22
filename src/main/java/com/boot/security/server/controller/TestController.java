package com.boot.security.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/hello")
	public String test(){
		System.out.println("雷浩啊");
		return "Hello";
	}
}
