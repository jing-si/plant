package kr.co.gardener.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import kr.co.gardener.admin.model.PlantLevel;
import kr.co.gardener.admin.model.User;
import kr.co.gardener.admin.service.UserService;

@Controller
@RequestMapping("/login")
public class MainController {	
	final String path = "main/";
	
	@Autowired
	UserService service;
	
	//메인페이지
	@RequestMapping("/") //db변경이 없을때 용도
	public String index(Model model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("img", imgSrc(user));
		/*
		 * model.addAttribute("userNick","userNick"); model.addAttribute("plantId","1");
		 * model.addAttribute("stateId","0");
		 */
		return path + "home2";
	}
	
	@RequestMapping("/home") //session갱신용, db변경했을떄 용도
	public String index(HttpSession session) {
		String userId = ((User) session.getAttribute("user")).getUserId();
		User user = service.item(userId); //유저만듦
		session.setAttribute("user", user);
		return path + "home2"; //오류날수도있음.......ㅎ...remove 필요할지도?
	}
	
	private String imgSrc(User user) {
		return service.imgSrc(user);
		
	}
	
	
	/*
	 * @RequestMapping({"/",""}) public String index(Model model) {
	 * model.addAttribute("userNick","userNick"); model.addAttribute("plantId","1");
	 * model.addAttribute("stateId","0"); return path + "home2"; }
	 */
	
	@RequestMapping("/init")
	@ResponseBody
	public List<PlantLevel> init(Model model){
		
		model.addAttribute("stateId",0);
		
		List<PlantLevel> list = new ArrayList<PlantLevel>();
		PlantLevel l1 = new PlantLevel();
		l1.setPlantId(1);
		l1.setPlantImage("/resources/images/tree_01.png");
		list.add(l1);
		
		PlantLevel l2 = new PlantLevel();
		l2.setPlantId(2);
		l2.setPlantImage("/resources/images/tree_02.png");
		list.add(l2);
		
		PlantLevel l3 = new PlantLevel();
		l3.setPlantId(3);
		l3.setPlantImage("/resources/images/tree_03.png");
		list.add(l3);
		
		return list;
	}
	
	@RequestMapping("/update") //홈에서 카드선택해서 심었을때
	@ResponseBody
	public String update(User item, HttpSession session) {
		User user = (User)session.getAttribute("user");
		user.update(item); //유저모델에서 검증해서 두개값만 update되게함
		service.update(user);		
		return "수정완료";
	}
}
