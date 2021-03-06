package kr.co.gardener.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.forest.PlantLevel;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.user.Inven;
import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.admin.service.forest.PlantLevelService;
import kr.co.gardener.admin.service.object.ProductService;
import kr.co.gardener.admin.service.other.RandomMessageService;
import kr.co.gardener.admin.service.user.InvenService;
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
	
	@Autowired
	InvenService invenService;
	
	@Autowired
	RandomMessageService randomService;
	
	//메인페이지
	@RequestMapping({"/",""}) //db변경이 없을때 용도
	public String index(Model model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("img", imgSrc(user));
		model.addAttribute("result", "0");
		
		String msg = randomService.item(user.getStateId());
		model.addAttribute("msg", msg);
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
	
	
/*
	//인증 폼 전송 -> 홈화면으로
	@PostMapping("/certify")
	public String certify(int barcode, Model model, HttpSession session) {
		//이상하게 프로덕트 아이디 확인만 갔다오면 세션이 종료되어서 다시 세션
		User user = (User) session.getAttribute("user");
		
		System.out.println(barcode);
		//certifyResult = 인증성공 or 인증 실패
		String certifyResult = productService.certify(barcode);
		System.out.println(certifyResult);
		
		//인증성공시
		if(certifyResult.equals("인증성공")) {
			user.setStateId(user.getStateId()+1); 
			service.levelUp(user);
		}
		
		//User user2 = (User) session.getAttribute("user");
		
		//model.addAttribute(certifyResult);
		model.addAttribute("result",certifyResult); 
		session.setAttribute("user", user);
		model.addAttribute("img", user.getPlant());
		return path + "home2";
	}
*/
	
	//인증 폼 전송 -> 홈화면으로
	@GetMapping("/certify")
	public String certify(String barcode, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		System.out.println(barcode);
		
		Product item = productService.certify(barcode,user.getUserId());
		String result;
		System.out.println(item);
		
		//인증성공시
		if(item != null) {
			user.setStateId(user.getStateId()+1); 
			service.levelUp(user);
			result = "1";
		}else {
			result = "2";
		}
	
		model.addAttribute("result",result); 
		session.setAttribute("user", user);
		model.addAttribute("img", user.getPlant());
		 
		return path + "home2";
	}
	
	
	//나무 다키워서 인벤으로 보내기
	@PostMapping("/plant")
	@ResponseBody
	public void plant(int plantId, HttpSession session) {
		User user = (User)session.getAttribute("user");
		Inven inven = new Inven();
		inven.setUserId(user.getUserId());
		inven.setPlantId(plantId);
		invenService.countUp(inven);
		user.setStateId(0);
		session.setAttribute("user", user);
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
