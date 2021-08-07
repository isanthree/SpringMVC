package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResponseController {
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("HelloController::hello() ......");
		return "success";
	}
}
