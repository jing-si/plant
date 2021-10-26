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
			
				String[] str = request.getRequestURI().split("/");
				
				if(str.length > 2) {
					switch (str[2]) {
					case "cert":
					case "class":
					case "datamanager":
					case "product":
					case "company":
						if(admin.getProductCode() == 28) {
							return true;
						}
						break;
					case "user":
					case "history":
					case "item":					
						if(admin.getUserCode() == 28) {
							return true;
						}
						break;
					case "state":
					case "notice":
						if(admin.getOtherCode() == 28) {
							return true;
						}
						break;
					case "forest":
					case "plants":
						if(admin.getForestCode() == 28) {
							return true;
						}
						break;
					case "authority":
						if(admin.getAuthorityCode() == 28) {
							return true;
						}
						break;	
					}
					
				}else {
					return true;
				}
				
				
			}

		}

		response.sendRedirect("/admin/");
		return false;

	}
}