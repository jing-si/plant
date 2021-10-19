package kr.co.gardener.forest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.user.Inven;
import kr.co.gardener.admin.model.user.Location;
import kr.co.gardener.admin.model.user.User;
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
		List<Inven> list = invenService.list(user.getUserId());
		model.addAttribute("list", list);

		return path + "forest";
	}

	@RequestMapping("/setforest")
	public String setforest() {
		return path + "/setforest";
	}

	
//	@RequestMapping("userforest/setforest/init2")
//	@ResponseBody
//	public List<Location> init2(HttpSession session) {
//		User user = (User) session.getAttribute("user");
//		List<Location> list = lService.list(user.getUserId());		
//		list.forEach((data)->{
//			System.out.println(data.toString());
//		});
//		return list;
//	}
	

	@ResponseBody
	@RequestMapping("/setforest/update")
	public void update(@RequestBody List<Location> data) {
		for (Location item : data)
			System.out.println(item.getUserId());

		// return data;
	}

	
	  // 유저가 저장한 숲 데이터 가져오기
		/*
		 * @RequestMapping({"/userforest/init", "/userforest/setforest/init"})
		 * 
		 * @ResponseBody public List<Location> locationList() { User user =
		 * (User)session.getAttribute("user"); List<Location> list =
		 * service.locationList();
		 * 
		 * return list; }
		 * 
		 * // 유저가 숲 꾸미기를 완료하고 저장한 데이터를 DB에 업로드 // service에도 임의로 넣었는데 맞게 한건지 확인 필요 //
		 * plantImage(이미지 경로)는 데이터 저장할때, 필요 없는데 컨트롤러에 데이터 보낼때도 그 부분은 제외?
		 * 
		 * @RequestMapping("/save")
		 * 
		 * @ResponseBody public String save(Location item, HttpSession session) {
		 * Location location = (Location)session.getAttribute("location");
		 * location.save(item); service.update(location); return "저장완료"; }
		 * 
		 * // 유저 인벤 데이터 가져오기
		 * 
		 * @RequestMapping({"/userforest/inven"})
		 * 
		 * @ResponseBody public List<Inven> invenList() { List<Inven> list =
		 * service.invenList();
		 * 
		 * return list; }
		 */
	  
	  
//	  @RequestMapping("/userforest/init1")
//	  
//	  @ResponseBody public List<Location> init() { List<Location> list = new
//	  ArrayList<Location>(); Location l1 = new Location(); l1.setLocationId(1);
//	  l1.setLocationOrder(100); l1.setLocationSize(1); l1.setLocationX(300);
//	  l1.setLocationY(50); l1.setPlantId(1);
//	  l1.setPlantImage("/resources/images/tree1.png");
//	  
//	  list.add(l1);
//	  
//	  Location l2 = new Location(); l2.setLocationId(1); l2.setLocationOrder(101);
//	  l2.setLocationSize(2); l2.setLocationX(200); l2.setLocationY(100);
//	  l2.setPlantId(1); l2.setPlantImage("/resources/images/tree2.png");
//	  
//	  list.add(l2);
//	  
//	  Location l3 = new Location(); l3.setLocationId(1); l3.setLocationOrder(102);
//	  l3.setLocationSize(3); l3.setLocationX(300); l3.setLocationY(300);
//	  l3.setPlantId(1); l3.setPlantImage("/resources/images/tree3.png");
//	  
//	  list.add(l3);
//	  
//	  return list; }
//	  
	  //숲꾸미기
		@RequestMapping("/userforest/setforest/init2")
		@ResponseBody
		public List<Location> init2() {
			List<Location> list = new ArrayList<Location>();
			Location l1 = new Location();
			l1.setLocationId(1);
			l1.setLocationOrder(999);
			l1.setLocationSize(1);
			l1.setLocationX(10);
			l1.setLocationY(10);
			l1.setPlantId(1);
			l1.setPlantImage("/resources/images/tree8.png");

			list.add(l1);

			Location l2 = new Location();
			l2.setLocationId(2);
			l2.setLocationOrder(101);
			l2.setLocationSize(1.2f);
			l2.setLocationX(50);
			l2.setLocationY(50);
			l2.setPlantId(2);
			l2.setPlantImage("/resources/images/tree2.png");

			list.add(l2);

			Location l3 = new Location();
			l3.setLocationId(3);
			l3.setLocationOrder(102);
			l3.setLocationSize(1.2f);
			l3.setLocationX(50);
			l3.setLocationY(50);
			l3.setPlantId(3);
			l3.setPlantImage("/resources/images/tree2.png");

			list.add(l3);

			Location l4 = new Location();
			l4.setLocationId(4);
			l4.setLocationOrder(103);
			l4.setLocationSize(1.2f);
			l4.setLocationX(50);
			l4.setLocationY(50);
			l4.setPlantId(4);
			l4.setPlantImage("/resources/images/tree2.png");

			list.add(l4);
			
			Location l5 = new Location();
			l5.setLocationId(1);
			l5.setLocationOrder(104);
			l5.setLocationSize(1.2f);
			l5.setLocationX(50);
			l5.setLocationY(50);
			l5.setPlantId(5);
			l5.setPlantImage("/resources/images/tree2.png");

			list.add(l5);
			
			Location l6 = new Location();
			l6.setLocationId(1);
			l6.setLocationOrder(105);
			l6.setLocationSize(1.2f);
			l6.setLocationX(50);
			l6.setLocationY(50);
			l6.setPlantId(6);
			l6.setPlantImage("/resources/images/tree2.png");

			list.add(l6);
			
			Location l7 = new Location();
			l7.setLocationId(1);
			l7.setLocationOrder(106);
			l7.setLocationSize(1.2f);
			l7.setLocationX(50);
			l7.setLocationY(50);
			l7.setPlantId(7);
			l7.setPlantImage("/resources/images/tree2.png");

			list.add(l7);
			
			Location l8 = new Location();
			l8.setLocationId(8);
			l8.setLocationOrder(101);
			l8.setLocationSize(1.2f);
			l8.setLocationX(50);
			l8.setLocationY(50);
			l8.setPlantId(8);
			l8.setPlantImage("/resources/images/tree3.png");

			list.add(l8);

			Location l9 = new Location();
			l9.setLocationId(9);
			l9.setLocationOrder(102);
			l9.setLocationSize(1.2f);
			l9.setLocationX(50);
			l9.setLocationY(50);
			l9.setPlantId(9);
			l9.setPlantImage("/resources/images/tree3.png");

			list.add(l9);

			Location l10 = new Location();
			l10.setLocationId(10);
			l10.setLocationOrder(103);
			l10.setLocationSize(1.2f);
			l10.setLocationX(50);
			l10.setLocationY(50);
			l10.setPlantId(10);
			l10.setPlantImage("/resources/images/tree3.png");

			list.add(l10);
			
			Location l11 = new Location();
			l11.setLocationId(11);
			l11.setLocationOrder(104);
			l11.setLocationSize(1.2f);
			l11.setLocationX(50);
			l11.setLocationY(50);
			l11.setPlantId(11);
			l11.setPlantImage("/resources/images/tree3.png");

			list.add(l11);
			
			Location l12 = new Location();
			l12.setLocationId(12);
			l12.setLocationOrder(105);
			l12.setLocationSize(1.2f);
			l12.setLocationX(50);
			l12.setLocationY(50);
			l12.setPlantId(12);
			l12.setPlantImage("/resources/images/tree3.png");

			list.add(l12);
			
			Location l13 = new Location();
			l13.setLocationId(13);
			l13.setLocationOrder(106);
			l13.setLocationSize(1.2f);
			l13.setLocationX(50);
			l13.setLocationY(50);
			l13.setPlantId(13);
			l13.setPlantImage("/resources/images/tree3.png");

			list.add(l13);

			return list;
		}
	 

}
