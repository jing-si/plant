package kr.co.gardener.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/object")
public class ObjectController {
	final String path = "admin/object/";
	
	
	
	@RequestMapping({"/"})
	public String index() {
		
		return path + "object";		
	}
	
	
	
	
	
}
