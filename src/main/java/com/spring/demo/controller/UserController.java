package com.spring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@GetMapping("test")
public String test() {
	return "test";
}
@GetMapping("/api/test")
public String apitest() {
	return "test";
}
}
