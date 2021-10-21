package kr.co.gardener.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.gardener.admin.model.user.User;

public class UserInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();

		if (session != null) {
			User user = (User) session.getAttribute("user");

			if (user != null) {
				return true;
			}

		}

		response.sendRedirect("/");
		return false;

	}
}
