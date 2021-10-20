package kr.co.gardener.forest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.user.Inven;
import kr.co.gardener.admin.model.user.Location;
import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.admin.model.user.list.LocationList;
import kr.co.gardener.admin.service.user.InvenService;
import kr.co.gardener.admin.service.user.LocationService;

@Controller
@RequestMapping("/login/userforest")
public class UserForestController {
	final String path = "userforest/";

	@Autowired
	LocationService lService;

	@Autowired
	InvenService invenService;
	

	@GetMapping({ "", "/" })
	public String forest(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Inven> ilist = invenService.list(user.getUserId());		  
		model.addAttribute("list", ilist);
		return path + "forest";
	}

	@RequestMapping("/setforest")
	public String setforest() {
		return path + "/setforest";
	}

	
	@RequestMapping("/setforest/init")
	@ResponseBody
	public List<Location> init2(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Location> list = lService.list(user.getUserId());		
		list.forEach((data)->{
			System.out.println(data.toString());
		});
		return list;
	}
	

	@ResponseBody
	@RequestMapping("/setforest/update")
	public String update(@RequestBody LocationList list) {
		lService.update_list(list);
		return "ok";
	}

	
	  
	 

}
