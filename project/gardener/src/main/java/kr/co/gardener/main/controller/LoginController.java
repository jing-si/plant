package kr.co.gardener.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.User;
import kr.co.gardener.admin.service.UserService;
import kr.co.gardener.main.service.LoginService;

@Controller
@RequestMapping({"/",""})
public class LoginController {
	final String path = "main/login/";
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	UserService service;
	
	//로그인
	@GetMapping({"","/"})
	public String login() {
		return path + "login";
	}
	
	@PostMapping({"","/"})
	public String login(User item, HttpSession session) {
		User user = loginService.item(item.getUserId());
		
		if(user != null) {
			String userId = user.getUserId();
			String userPass = user.getUserPass();
			
			if(userId.equals(item.getUserId()) && userPass.equals(item.getUserPass())) {
				session.setAttribute("user", user);
				return  "redirect:/login/";
			}
			
			return path + "login";
		}
	
		return path + "login";
	}
	
	//회원가입
	@GetMapping("/membership")
	public String membership() {
		return path + "membership2";
	}
	
	//회원가입 폼
	@PostMapping("/membership")
	public String membership(User user) {
		service.add(user);
		return "redirect:..";
	}
	
	//비밀번호 재설정 메일발송
	//당장 구현 불가
	@RequestMapping("/pwupdate")
	public String pwupdate(User user) {
		return path + "pwupdate";
	}
	
	//스플래시(시작대기화면)
		@RequestMapping("/splash")
		public String splash() {
			return path + "splash";
		}
}
