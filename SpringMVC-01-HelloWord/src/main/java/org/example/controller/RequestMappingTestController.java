package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类上进行 RequestMapping 注解标注 "baseUrl"：为当前类所有方法的请求地址指定一个基准路径
 */
@RequestMapping("/baseUrl")
@Controller
public class RequestMappingTestController {

	@RequestMapping("/handle01")
	public String handle01() {
		System.out.println("RequestMappingTestController::handle01() 收到请求，处理中......");
		return "success.jsp";
	}

	/*
	 * RequestMapping 的其他属性
	 *
	 * method：限定请求方式（GET、POST...），默认是什么方式都接受
	 *      method = RequestMethod.POST：只接受 POST 类型请求
	 * params：规定请求参数
	 * headers：规定请求头
	 * consumes：设置规定内容类型的请求，规定请求头中的 Content-Type
	 * produces：告诉浏览器返回的内容是什么，给响应头中加上 Content-Type
	 */

	/**
	 * method：限定请求方式（GET、POST...），默认是什么方式都接受
	 *      method = RequestMethod.POST：只接受 POST 类型请求
	 */
	@RequestMapping(value = "/handle02", method = RequestMethod.POST)
	public String handle02() {
		System.out.println("RequestMappingTestController::handle02() ———— method 测试，收到请求，处理中......");
		return "success.jsp";
	}

	/**
	 * params：规定请求参数
	 * params = {"username"}：发送请求时必须带上参数 username，否则 404
	 * params = {"!username"}：发送请求时不能带上参数 username，否则 404
	 * params = {"username=123"}：发送请求时必须带上参数 username，且值一定为 123，否则 404。注意别带空格
	 * params = {"username!=123"}：发送请求时必须带上参数 username，且值不能为 123，否则 404。注意别带空格
	 * params = {"username=hhh", "pwd", "!age"}：发送请求时必须带上参数 username=hhh 和 pwd，且不能带 age，否则 404。注意别带空格
	 */
	@RequestMapping(value = "/handle03", params = {"username=hhh", "pwd", "!age"})
	public String handle03() {
		System.out.println("RequestMappingTestController::handle03() ———— params 测试，收到请求，处理中......");
		return "success.jsp";
	}

	/**
	 * headers：规定请求头，
	 * User-Agent：浏览器信息，这里可以设置指定浏览器访问
	 * 谷歌浏览器 User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36
	 */
	@RequestMapping(value = "/handle04", headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36"})
	public String handle04() {
		System.out.println("RequestMappingTestController::handle04() ———— headers 测试，收到请求，处理中......");
		return "success.jsp";
	}
}
