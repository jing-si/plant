package kr.co.gardener.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/forests/plants")
public class PlantsController {
	final String path = "/admin/forests/plants/";
	
	@RequestMapping({"", "/"})
	public String index() {
		return path + "plants"; 
	}
}
