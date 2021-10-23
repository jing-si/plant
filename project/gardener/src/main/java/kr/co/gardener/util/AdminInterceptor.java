package kr.co.gardener.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.gardener.admin.model.authority.Authority;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();

		if (session != null) {
			Authority admin = (Authority) session.getAttribute("admin");

			if (admin != null) {
				return true;
			}

		}

		response.sendRedirect("/admin/");
		return false;

	}
}