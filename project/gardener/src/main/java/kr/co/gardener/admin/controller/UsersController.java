package kr.co.gardener.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/users")
public class UsersController {
	final String path = "/admin/users/";
	
	@RequestMapping({"","/"})
	public String index() {
		return path + "users";
	}
}
