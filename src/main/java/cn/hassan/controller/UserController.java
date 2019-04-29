package cn.hassan.controller;

import cn.hassan.pojo.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

	/**
	 * 跳转到登录页面
	 *
	 * @return
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}

	/**
	 * 用户登录
	 *
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("login")
	public String login(String username, String password, HttpSession session) {
		// 校验用户登录
		System.out.println(username);
		System.out.println(password);

		// 把用户名放到session中
		session.setAttribute("username", username);

		return "redirect:/item/itemList.action";
	}

	@RequestMapping("loginUser")
	public String loginUser(@RequestBody UserForm user) {
		// 校验用户登录
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());

		// 把用户名放到session中

		return "redirect:/item/itemList.action";
	}
}
