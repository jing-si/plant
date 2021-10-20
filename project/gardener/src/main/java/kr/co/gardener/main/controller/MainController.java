package kr.co.gardener.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.forest.PlantLevel;
import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.admin.service.forest.PlantLevelService;
import kr.co.gardener.admin.service.object.ProductService;
import kr.co.gardener.admin.service.user.UserService;

@Controller
@RequestMapping("/login")
public class MainController {	
	final String path = "main/";
	
	@Autowired
	UserService service;
	
	@Autowired
	PlantLevelService plantLevelService;
	
	@Autowired
	ProductService productService;
	
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
	
	/*
	 * @RequestMapping("/home") //session갱신용, db변경했을떄 용도 public String
	 * index(HttpSession session) { String userId = ((User)
	 * session.getAttribute("user")).getUserId(); User user = service.item(user);
	 * //유저만듦 session.setAttribute("user", user); return path + "home2";
	 * //오류날수도있음.......ㅎ...remove 필요할지도? }
	 */
	
	private String imgSrc(User user) {
		return service.imgSrc(user);
		
	}
	
	// qr스캐너 테스트 중
	@RequestMapping("/camera")
	public String camera() {
		return path + "qrscanner";
	}
	
	
	//인증
	@RequestMapping("/certify")
	public String certify() {
		return path + "certify";
	}
	
	//인증 폼 전송 -> 홈화면으로
	@PostMapping("/certify")
	public String membership(int barcode, Model model, HttpSession session) {
		//이상하게 프로덕트 아이디 확인만 갔다오면 세션이 종료되어서 다시 세션
		User user = (User) session.getAttribute("user");
		
		System.out.println(barcode);
		//certifyResult = 인증성공 or 인증 실패
		//인증실패시의 널값 처리해야함(매퍼에서 카운트를 가져오면 어떨까)
		String certifyResult = productService.certify(barcode);
		System.out.println(certifyResult);
		
		//인증성공시
		if(certifyResult.equals("인증성공")) {
			user.setStateId(user.getStateId()+1); 
			service.levelUp(user);
		}
		
		/* User user2 = (User) session.getAttribute("user"); */
		
		/* model.addAttribute(certifyResult); */
		session.setAttribute("user", user);
		model.addAttribute("img", user.getPlant());
		return "redirect:./";
	}
	
	
	//나무 다키워서 인벤으로 보내기
	@PostMapping("/plant")
	@ResponseBody
	public void plant(String userId, int plantId, HttpSession session) {
		User user = (User)session.getAttribute("user");
		user.setStateId(0);
		
		//인벤토리에 추가하는 작업해야함
	}
	
	
	
	/*
	 * @RequestMapping({"/",""}) public String index(Model model) {
	 * model.addAttribute("userNick","userNick"); model.addAttribute("plantId","1");
	 * model.addAttribute("stateId","0"); return path + "home2"; }
	 */
	
	//랜덤 카드 뽑기
	@RequestMapping("/init")
	@ResponseBody
	public List<PlantLevel> init(){
		List<PlantLevel> list = plantLevelService.random();	
		return list;
	}
	
	@RequestMapping("/update")  //홈에서 카드선택해서 심었을때
	@ResponseBody
	public String update(User item, HttpSession session) {
		User user = (User)session.getAttribute("user");
		item.setUserId(user.getUserId());
	
		service.update(item);
	
		user.update(item);
		session.setAttribute("user", user);
		return "수정완료";
	}
}
