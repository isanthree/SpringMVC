package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * SpringMVC 除了在方法上传入原生的 request 和 session 外，还能怎么样把数据带给页面
 * 1.可以在方法处传入 Map、Model 或 ModelMap；给这些参数里面保存的所有数据都会放在域中，可以被页面获取
 *  三者关系：
 *      这三者的类型都为：org.springframework.validation.support.BindingAwareModelMap，
 *      即三者最终都是 BindingAwareModelMap 在工作，BindingAwareModelMap 中保存的东西都会被放到请求域中
 *      Map：是 jdk 中的一个接口；Model：是 spring 中的一个接口；ModelMap：是一个类
 *
 * 2.方法的返回值可以变为 ModelAndView 类型
 *  既包含视图信息（页面地址），又包含模型数据（给页面带的数据）；
 *  而且数据是放在请求域中的
 *
 * 3.SpringMVC 提供了一种可以临时给 Session 域中保存数据的方式
 *  使用一个注解：@SessionAttributes(value = "msg") ———— 这个注解只能标在类上，
 *      给 BindingAwareModelMap 或 ModelAndView 保存的数据，同时在 session 中放一份
 *  value = "msg"：指定只要保存的是 key 为 msg 的数据，同时在 session 中也放一份
 *  types = {String.class}：指定只要保存的是 String 类型数据，同时在 session 中放一份
 *
 * PS：由于使用 @SessionAttributes 可能会引发异常，后来就不推荐使用了，给 session 放数据推荐使用原生 API
 */
@SessionAttributes(value = "msg", types = {String.class})
@Controller
public class OutputController {
	/**
	 * Map：是一个接口
	 */
	@RequestMapping("/handle01")
	public String handle01(Map<String, Object> map) {
		map.put("msg", "你好");
		map.put("hhh", "哈哈哈");
		System.out.println("OutputController::handle01() 请求处理中......");
		System.out.println("    Map 的类型：" + map.getClass());
		return "success";
	}

	/**
	 * Model：是一个接口
	 */
	@RequestMapping("/handle02")
	public String handle02(Model model) {
		model.addAttribute("msg", "Model：是一个接口");
		model.addAttribute("hhh", 19);
		System.out.println("OutputController::handle02() 请求处理中......");
		System.out.println("    Model 的类型：" + model.getClass());
		return "success";
	}

	/**
	 * ModelMap：是一个类
	 */
	@RequestMapping("/handle03")
	public String handle03(ModelMap modelMap) {
		modelMap.addAttribute("msg", "形参 ModelMap");
		System.out.println("OutputController::handle03() 请求处理中......");
		System.out.println("    ModelMap 的类型：" + modelMap.getClass());
		return "success";
	}

	/**
	 * ModelAndView：为页面携带数据
	 */
	@RequestMapping("/handle04")
	public ModelAndView handle04() {
		// 之前的 "success" 返回值就叫视图名。视图名视图解析器是会帮我们最终拼串得到页面的真实地址
//		ModelAndView mv = new ModelAndView("success");  // success：去往的页面；可以改成以下两行语句
		ModelAndView mv = new ModelAndView();
		mv.setViewName("success");
		mv.addObject("msg", "ModelAndView 传数据");
		System.out.println("OutputController::handle04() ModelAndView 传数据......");
		return mv;
	}
}
