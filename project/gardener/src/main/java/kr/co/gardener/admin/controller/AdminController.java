package kr.co.gardener.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.authority.AdminDTO;
import kr.co.gardener.admin.model.authority.Authority;
import kr.co.gardener.admin.service.authority.AuthorityService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	final String path = "admin/";
	@Autowired
	AuthorityService service;
	
	@GetMapping({"/",""})
	public String index() {
		return path + "main";
	}
	
	@PostMapping({"/",""})
	public String login(AdminDTO item, HttpSession session,Model model) {
		Authority admin = service.login(item);
		if(admin != null) {
			session.setAttribute("admin", admin);
			return "redirect:/admin";
		}
		model.addAttribute("msg", "아이디와 비밀번호를 확인해 주세요.");
		return path + "main";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
			session.removeAttribute("admin");
		return "redirect:/admin";
	}
}
