package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RequestMapping：模糊匹配功能
 *
 * URL 地址可以写模糊的通配符：? * **
 *  ?：能替代一个字符
 *  *：能替代任意多个字符和一层路径
 *  **：能替代多层路径
 */
@Controller
public class RequestMappingTestAntStyleURL {

	/**
	 * 精确请求
	 */
	@RequestMapping(value = "antTest01")
	public String antTest01() {
		System.out.println("RequestMappingTestFuzzyMatching::antTest01()：精确请求......");
		return "success.jsp";
	}

	/**
	 * 模糊查询：? 匹配一个字符
	 *      多个方法成功匹配情况下，优先级：精确 > 模糊
	 */
	@RequestMapping(value = "antTest0?")
	public String antTest02() {
		System.out.println("RequestMappingTestFuzzyMatching::antTest02()：? 模糊查询......");
		return "success.jsp";
	}

	/**
	 * 模糊查询：* 匹配任意多字符
	 *      多个方法成功匹配情况下，优先级：精确 > 模糊 ? > 模糊 *
	 */
	@RequestMapping(value = "antTest0*")
	public String antTest03() {
		System.out.println("RequestMappingTestFuzzyMatching::antTest03()：* 模糊查询......");
		return "success.jsp";
	}

	/**
	 * 模糊查询：* 匹配任意多字符 ———— 一层路径
	 */
	@RequestMapping(value = "/a/*/antTest0*")
	public String antTest04() {
		System.out.println("RequestMappingTestFuzzyMatching::antTest04()：* 模糊查询 ———— 一层路径......");
		return "success.jsp";
	}

	/**
	 * 模糊查询：** 匹配任意多字符 ———— 多层路径
	 */
	@RequestMapping(value = "/a/**/antTest0*")
	public String antTest05() {
		System.out.println("RequestMappingTestFuzzyMatching::antTest05()：** 模糊查询 ———— 多层路径......");
		return "success.jsp";
	}

	/**
	 * 路径占位符测试：
	 *      /user/admin 或 /user/hhh
	 *
	 * 占位符语法：可以在任意路径的地方写一个 {变量名}
	 */
	@RequestMapping(value = "/user/{id}")
	public String pathVariableTest(@PathVariable("id") String id) {
		System.out.println("RequestMappingTestFuzzyMatching::pathVariableTest()：路径占位符......");
		System.out.println("   ...路径上的占位符的值：" + id);
		return "success.jsp";
	}
}
