package cn.hassan.controller;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with idea
 * Author: hss
 * Date: 2019/4/17 14:18
 * Description: xxxWare 如果再某个类想要spring的一些东西，可以通过XXXAware接口告诉spring，spring会通过setXXX方法返给你
 */
@Controller
public class EnvironmentController implements EnvironmentAware {

	private Environment environment;

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("msg", "index");
		return "login";
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
