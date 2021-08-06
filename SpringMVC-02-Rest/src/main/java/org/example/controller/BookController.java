package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

	/**
	 * 查询图书请求
	 * @param id 图书号
	 * @return 返回跳转页面
	 */
	@RequestMapping(value = "/book/{bid}", method = RequestMethod.GET)
	public String getBook(@PathVariable("bid") Integer id) {
		System.out.println("BookController::getBook()：查询到了 " + id + " 号图书......");
		return "success";
	}

	/**
	 * 增
	 */
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String addBook() {
		System.out.println("BookController::addBook()：添加了新的图书......");
		return "success";
	}

	/**
	 * 删
	 */
	@RequestMapping(value = "/book/{bid}", method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable("bid") Integer id) {
		System.out.println("BookController::deleteBook()：删除了 " + id + " 号图书......");
		return "success";
	}

	/**
	 * 改
	 */
	@RequestMapping(value = "/book/{bid}", method = RequestMethod.PUT)
	public String updateBook(@PathVariable("bid") Integer id) {
		System.out.println("BookController::updateBook()：更新了 " + id + " 号图书......");
		return "success";
	}
}
