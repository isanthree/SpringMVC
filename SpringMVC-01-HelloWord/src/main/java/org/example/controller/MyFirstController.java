package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller 注解：标识该组件为处理器，即告诉 SpringMVC 这是一个处理器，可以处理请求
 *
 */
@Controller
public class MyFirstController {
	/**
	 * '/' 代表从当前项目下开始，处理当前项目下的 hello 请求
	 */
	@RequestMapping("hello")
	public String myFirstRequest() {
		System.out.println("MyFirstController::myFirstRequest() 请求收到了，正在处理中......");

		return "success.jsp";
	}
}
