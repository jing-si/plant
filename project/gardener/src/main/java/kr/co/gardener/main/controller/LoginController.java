package kr.co.gardener.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.admin.service.user.UserService;
import kr.co.gardener.main.service.LoginService;
import kr.co.gardener.util.FileUploader;

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
				//로그인한 사람의 정보가 session에 user란 이름으로 저장됨
				session.setAttribute("user", user);
				System.out.println(user);
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
	
	//회원가입 아이디 중복확인 처리
	@PostMapping("/membership/duplication")
	@ResponseBody
	public boolean duplication(String id) {
		return service.duplication(id);
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
			return "main/splash";
		}
		
		@PostMapping("/tempfileUpload")
		@ResponseBody
		public List<String> FileUploader(String folder,List<MultipartFile> files) {
			List<String> list = new ArrayList<String>();
			
			files.forEach((file)->{
				list.add(FileUploader.Uploader(file, "temp",null));
			});
			
			return list; 
		}
		
		@PostMapping("/fileUpload")
		@ResponseBody
		public List<String> FileUploader(String folder,String[] name,List<MultipartFile> files) {
			List<String> list = new ArrayList<String>();
			
			for(int a = 0 ; a < files.size() ; a++) {
				if(files.get(a).getSize() != 0)
					list.add(FileUploader.Uploader(files.get(a), folder, name[a]));
			}		
			
			return list; 
		}
}
