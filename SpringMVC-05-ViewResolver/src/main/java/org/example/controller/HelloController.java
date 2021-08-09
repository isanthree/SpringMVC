package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("HelloController::hello() ......");
		return "../../hello";  // "../../"防止 URL 地址自动拼串
	}

	/**
	 * forward：转发到另一个页面
	 * /hello.jsp：当前项目下的 hello.jsp
	 * forward:/hello.jsp：有前缀的返回值独立解析，不会进行 URL 拼串。一定要加 '/'，如果不加，就是相对路径，容易出问题
	 */
	@RequestMapping("/handle01")
	public String handle01() {
		System.out.println("HelloController::handle01() 转发到 hello.jsp......");
		return "forward:/hello.jsp";
	}

	@RequestMapping("/handle02")
	public String handle02() {
		System.out.println("HelloController::handle02() 转发到 handle01......");
		return "forward:/handle01";
	}

	/**
	 * 重定向到 hello.jsp
	 *
	 * 有前缀的转发和重定向操作，配置的视图解析器就不会进行 URL 拼串
	 *
	 * 转发：forward:转发的路径
	 * 重定向：redirect:重定向的路径
	 */
	@RequestMapping("/handle03")
	public String handle03() {
		System.out.println("HelloController::handle03() 重定向到 hello.jsp......");
		return "redirect:/hello.jsp";
	}

	@RequestMapping("/handle04")
	public String handle04() {
		System.out.println("HelloController::handle04() 重定向到 handle03......");
		return "redirect:/handle03";
	}

	// 也可以注释掉，到 springmvc-servlet.xml 文件配置相关请求映射标签
	// <mvc:view-controller path="/toLoginPage" view-name="login"/>
//	@RequestMapping("toLoginPage")
//	public String toLoginPage() {
//		System.out.println("HelloController::toLoginPage() 去往登录页面......");
//		return "login";
//	}
}
