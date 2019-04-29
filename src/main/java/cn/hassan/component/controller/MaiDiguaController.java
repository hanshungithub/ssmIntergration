package cn.hassan.component.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with idea
 * Author: hss
 * Date: 2019/4/18 8:35
 * Description:
 */
@Controller
public class MaiDiguaController {

	@RequestMapping("/todou")
	public ModelAndView maidigua(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
	}
}
