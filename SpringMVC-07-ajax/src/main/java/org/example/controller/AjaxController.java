package org.example.controller;

import org.example.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController  // 自动返回字符串
public class AjaxController {

	@RequestMapping("/t1")
	public String test() {
		return "hello";
	}

	@RequestMapping("/a1")
	public void a1(String name, HttpServletResponse response) throws IOException {
		System.out.println("AjaxController::a1() param: " + name);
		if ("hhh".equals(name)) {
			response.getWriter().print("true");
		} else {
			response.getWriter().print("false");
		}
	}

	@RequestMapping("/a2")
	public List<User> a2() {
		List<User> userList = new ArrayList<User>();
		// 添加数据
		userList.add(new User("前端", 1, "女"));
		userList.add(new User("后端", 2, "男"));
		userList.add(new User("cpp", 3, "男"));

		return userList;
	}

	@RequestMapping("/a3")
	public String a3(String name, String pwd) {
		String msg = "";
		System.out.println("AjaxController::a3()");
		if (name != null) {
			// "admin" 这里为了简化代码写死了，实际上应该在数据库查询
			if ("admin".equals(name)) {
				msg = "ok";
			} else {
				msg = "user not found";
			}
		}

		if (pwd != null) {
			if ("admin".equals(name)) {
				msg = "ok";
			} else {
				msg = "password error";
			}
		}

		return msg;
	}
}
