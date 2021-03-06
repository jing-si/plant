package kr.co.gardener.main.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.admin.service.user.UserService;
import kr.co.gardener.util.FileUploader;

@Controller
@RequestMapping({"/",""})
public class LoginController {
	final String path = "main/login/";
	
		
	@Autowired
	UserService service;
	
	//로그인
	@GetMapping({"","/"})
	public String login() {
		return path + "login";
	}
	
	@PostMapping({"","/"})
	public String login(User item, HttpSession session, Model model) {
		User user = service.login(item);
		
		if(user != null) {
				session.setAttribute("user", user);
				return  "redirect:/login/";
		}else{
			model.addAttribute("msg", "로그인 실패");
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
	
	//이용약관
	@RequestMapping("/membership/agreement")
	public String agreement() {
		return path + "agreement";
	}
	
	//비밀번호 재설정 1페이지
	//당장 구현 불가
	@GetMapping("/pwupdate")
	public String pwupdate() {
		return path + "pwupdate1";
	}
	
	//비밀번호 재설정 1페이지 폼
	@PostMapping("/pwupdate")
	public String pwupdate(User user, Model model) {
		
		int count = service.count(user);
		String msg = null;
		if(user.getUserId() == "") {
			msg = "이메일을 입력해주세요.";
			model.addAttribute("msg", msg);
			return path+"pwupdate1";
			
		}else {
			model.addAttribute("userId",user.getUserId());
		}
		
		if(user.getUserBirth() == null) {
			msg = "생년월일을 입력해주세요.";
			model.addAttribute("msg", msg);
			return path+"pwupdate1";
			
		}else {
			model.addAttribute("userBirth",new SimpleDateFormat("yyyy.MM.dd").format(user.getUserBirth()));
		}
		
		if(count>0) {
			return path + "pwupdate2";
		}
		else {
			msg = "이메일과 생년월일을 확인해 주세요.";
			model.addAttribute("msg", msg);
			return path+"pwupdate1";
		}
	}
	
	
	//비밀번호 재설정2
	@PostMapping("/pwdate2")
	public String pwupdatepwupdate(User user,HttpSession session) {
		//비밀번호 변경시 자동으로 로그인 되게 만들려면 주석을 풀어주세요.		
		//String pass = user.getUserPass();
		service.update(user);
		//user.setUserPass(pass);
		user = service.login(user);
		//session.setAttribute("user", user);
		//return "redirect:/login";
		return "redirect:/";
	}
	
	//스플래시(시작대기화면)
		@RequestMapping("/splash")
		public String splash() {
			return "main/splash";
		}
		
		@PostMapping("/tempfileUpload")
		@ResponseBody
		public List<String> tempFileUploader(String folder,List<MultipartFile> files) {
			List<String> list = new ArrayList<String>();
			
			files.forEach((file)->{
				list.add(FileUploader.Uploader(file, "temp",null));
			});
			
			return list; 
		}
		
		@PostMapping("/fileUpload")
		@ResponseBody
		public Map<String,String> FileUploader(String folder,String[] name,List<MultipartFile> files) {
			Map<String,String> map = new HashMap<String, String>();
			for(int a = 0 ; a < files.size() ; a++) {
				if(files.get(a).getSize() != 0) {
					map.put(name[a], FileUploader.Uploader(files.get(a) ,folder,files.get(a).getOriginalFilename()));
					
					
				}
			}		
			
			return map; 
		}
}
