package org.example.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.pojo.User;
import org.example.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@RestController  // 把 @Controller 替换为 @RestController，则这个类不走视图解析器
public class UserController {
	@RequestMapping("j01")
	@ResponseBody  // 设置不走视图解析器，直接返回一个字符串
	public String json01() throws JsonProcessingException {

		// jackson, ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();

		User user = new User("hhh01", 19, "男");

		String str = objectMapper.writeValueAsString(user);

		return str;
	}

	@RequestMapping("j02")
	@ResponseBody  // 设置不走视图解析器，直接返回一个字符串
	public String json02() {
		List<User> userList = new ArrayList<User>();

		User user1 = new User("hhh01", 19, "男");
		User user2 = new User("hhh02", 19, "男");
		User user3 = new User("hhh03", 19, "男");
		User user4 = new User("hhh04", 19, "男");
		User user5 = new User("hhh05", 19, "男");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);

		return JsonUtils.getJson(userList);
	}

	@RequestMapping("j03")
	@ResponseBody  // 设置不走视图解析器，直接返回一个字符串
	public String json03() {

		Date date = new Date();

		return JsonUtils.getJson(date, "yyyy-MM-dd HH:mm:ss");
	}

	@RequestMapping("j04")
	@ResponseBody  // 设置不走视图解析器，直接返回一个字符串
	public String json04() {
		List<User> userList = new ArrayList<User>();

		User user1 = new User("hh01", 19, "男");
		User user2 = new User("hh02", 19, "男");
		User user3 = new User("hh03", 19, "男");
		User user4 = new User("hh04", 19, "男");
		User user5 = new User("hh05", 19, "男");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);

		String str = JSON.toJSONString(userList);

		return str;
	}
}
