package kr.co.gardener.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/forests")
public class ForestsController {
	final String path = "/admin/forests/";
	
	@RequestMapping({"","/"})
	public String index() {
		return path + "forests";
	}
	
}
