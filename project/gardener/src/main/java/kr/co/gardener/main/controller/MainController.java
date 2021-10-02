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
	
	//硫붿씤�럹�씠吏�
	@RequestMapping("/") //db蹂�寃쎌씠 �뾾�쓣�븣 �슜�룄
	public String index(Model model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("img", imgSrc(user));
		/*
		 * model.addAttribute("userNick","userNick"); model.addAttribute("plantId","1");
		 * model.addAttribute("stateId","0");
		 */
		return path + "home2";
	}
	
	@RequestMapping("/home") //session媛깆떊�슜, db蹂�寃쏀뻽�쓣�뻹 �슜�룄
	public String index(HttpSession session) {
		String userId = ((User) session.getAttribute("user")).getUserId();
		User user = service.item(userId); //�쑀��留뚮벀
		session.setAttribute("user", user);
		return path + "home2"; //�삤瑜섎궇�닔�룄�엳�쓬.......�뀕...remove �븘�슂�븷吏��룄?
	}
	
	private String imgSrc(User user) {
		return service.imgSrc(user);
		
	}
	
	@RequestMapping("/camera")
	public String camera() {
		return path + "camera";
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
	
	@RequestMapping("/update") //�솃�뿉�꽌 移대뱶�꽑�깮�빐�꽌 �떖�뿀�쓣�븣
	@ResponseBody
	public String update(User item, HttpSession session) {
		User user = (User)session.getAttribute("user");
		user.update(item); //�쑀��紐⑤뜽�뿉�꽌 寃�利앺빐�꽌 �몢媛쒓컪留� update�릺寃뚰븿
		service.update(user);		
		return "�닔�젙�셿猷�";
	}
}
