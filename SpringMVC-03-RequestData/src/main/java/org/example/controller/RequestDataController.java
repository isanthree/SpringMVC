package org.example.controller;

import org.example.book.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class RequestDataController {

	@RequestMapping("/handle01")
	public String handle01() {
		System.out.println("RequestController::handle01() 请求处理中......");
		return "success";
	}

	/**
	 * SpringMVC 如何获取请求带来的各种信息
	 *
	 * RequestParam 注解：获取请求参数
	 *  默认方式：只需保证请求参数变量名和形参变量名相同即可
	 *  注解方式：@RequestParam("user")，此时 URL 默认必须带有请求参数 user
	 *      value：指定要获取的参数的 key
	 *      required：设置 URL 是否必须带上这个参数
	 *      defaultValue：URL 没带参数时，给出默认的参数值
	 *  注意：
	 *    - @RequestParam("user")：获取 URL .../book/{user}?user=admin 中 ? 后面的 user 的值（即请求参数的值）
	 *    - @PathVariable("user")：获取 URL .../book/{user}?user=admin 中的 {user} 的值（即路径上的值）
	 *
	 * RequestHeader 注解：获取请求头中某个 key 的值
	 *      value：指定要获取的请求头的 key
	 *      required：设置浏览器是否必须有这个 key，防止浏览器没有这个请求头
	 *      defaultValue：没有这个请求头时，给出默认的请求头
	 *
	 * CookieValue 注解：获取某个 cookie 的值
	 */
	@RequestMapping("/handle02")
	public String handle02(@RequestParam(value = "user", required = false, defaultValue = "NoTheParam") String username,
	                       @RequestHeader(value = "User-Agent", required = false, defaultValue = "NoTheHeader") String userAgent,
	                       @CookieValue(value = "JSESSIONID", required = false, defaultValue = "NoTheCookie") String cookie) {
		System.out.println("RequestController::handle02() 请求处理中......");
		System.out.println("    请求参数为：user=" + username);
		System.out.println("    请求头中浏览器的信息：" + userAgent);
		System.out.println("    获取的其中一个 cookie 的值：JSESSIONID=" + cookie);
		return "success";
	}

	/**
	 * 如果我们的请求参数是一个 POJO（实体类），SpringMVC 会自动封装，即会为这个实体类自动赋值
	 * 1.将 POJO 中的每一个属性，尝试从 request 参数中获取出来，并封装
	 * 2.还可以级联封装：属性的属性
	 *
	 * 提交的数据可能有乱码，解决方案：
	 *   请求乱码：
	 *      GET 请求：改 servlet.xml（路径：D:\Program Files\Java\apache-tomcat-9.0.50\conf\server.xml）
	 *          在 8080 端口处，加上 URIEncoding="UTF-8"：
	 *          <Connector port="8080" protocol="HTTP/1.1"
	 *                connectionTimeout="20000"
	 *                redirectPort="8443"
	 *                URIEncoding="UTF-8" />
	 *      POST 请求：
	 *          在第一次获取参数之前设置 request.setCharacterEncoding("UTF-8");
	 *          可以在 web.xml 中配置一个字符编码的 Filter
	 *   响应乱码：response.setContentType("text/html;charset=utf-8")
	 */
	@RequestMapping("/book")
	public String addBook(Book book) {
		System.out.println("RequestController::addBook() 保存的图书：" + book);
		return "success";
	}

	/**
	 * SpringMVC 可以直接在参数上写原生 API
	 *
	 * HttpServletRequest
	 * HttpServletResponse
	 * HttpSession
	 *
	 * java.security.Principal
	 * Locale：国际化有关的区域信息对象
	 * InputStream：
	 *   ServletInputStream inputStream = request.getInputStream();
	 * OutputStream：
	 *   ServletOutputStream outputStream = response.getOutputStream();
	 * Reader：
	 *   BufferedReader reader = request.getReader();
	 * Writer：
	 *   PrintWriter writer = response.getWriter();
	 */
	@RequestMapping("/servletAPITest")
	public String servletAPITest(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("RequestController::servletAPITest() 请求处理中......");
		System.out.println("    testServletAPI：" + request + ", " + response);
		request.setAttribute("requestParam", "我是请求域中的参数值");
		session.setAttribute("sessionParam", "我是会话域中的参数值");

		return "success";
	}
}
