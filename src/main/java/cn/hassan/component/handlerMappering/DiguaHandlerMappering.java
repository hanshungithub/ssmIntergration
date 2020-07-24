package cn.hassan.component.handlerMappering;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with idea
 * Author: hss
 * Date: 2019/4/18 8:28
 * Description:
 */
//@Component
public class DiguaHandlerMappering implements HandlerMapping {
	public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
		String url = request.getRequestURI().toString();
		String method = request.getMethod();
		if (url.startsWith("/todou")) {
			if (method.equalsIgnoreCase("GET")) {
				//return ;
			} else if (method.equalsIgnoreCase("POST")) {
				//return;
			}else {
				//return;
			}
		}


		return null;
	}
}
