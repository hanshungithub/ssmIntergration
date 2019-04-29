package cn.hassan.component.handlerAdapter;

import cn.hassan.component.controller.MaiDiguaController;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with idea
 * Author: hss
 * Date: 2019/4/18 10:01
 * Description:
 */
public class MaiDiguaHandlerAdapter implements HandlerAdapter {
	public boolean supports(Object handler) {
		return handler instanceof MaiDiguaController;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return ((MaiDiguaController) handler).maidigua(request, response);
	}

	public long getLastModified(HttpServletRequest request, Object handler) {
		return -1L;
	}
}
