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

import kr.co.gardener.admin.model.Inven;
import kr.co.gardener.admin.model.Location;
import kr.co.gardener.admin.model.User;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.service.InvenService;
import kr.co.gardener.admin.service.LocationService;

@Controller
@RequestMapping("/login/userforest")
public class UserForestController {
	final String path = "userforest/";
	
	@Autowired
	LocationService lService;
	
	@Autowired
	InvenService invenService;
	
	@GetMapping({"","/"})
	public String forest(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Inven> list = invenService.list(user.getUserId());
		model.addAttribute("list",list);
		
		return path + "forest";
	}
	
	@RequestMapping("/setforest")
	public String setforest() {
		return path + "/setforest";
	}
	
	@RequestMapping("userforest/setforest/init2")
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
	   public void update(@RequestBody List<Location> data){
	      for(Location item : data)
	         System.out.println(item.getUserId());
	      
	      // return data;
	   }
	
	
	/*
	 * // 유저가 저장한 숲 데이터 가져오기
	 * 
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

	/*
	 * @RequestMapping("/userforest/init1")
	 * 
	 * @ResponseBody public List<Location> init() { List<Location> list = new
	 * ArrayList<Location>(); Location l1 = new Location(); l1.setLocationId(1);
	 * l1.setLocationOrder(100); l1.setLocationSize(150); l1.setLocationX(300);
	 * l1.setLocationY(500); l1.setPlantId(1);
	 * l1.setPlantImage("/resources/images/tree1.png");
	 * 
	 * list.add(l1);
	 * 
	 * Location l2 = new Location(); l2.setLocationId(1); l2.setLocationOrder(101);
	 * l2.setLocationSize(50); l2.setLocationX(100); l2.setLocationY(500);
	 * l2.setPlantId(1); l2.setPlantImage("/resources/images/tree2.png");
	 * 
	 * list.add(l2);
	 * 
	 * Location l3 = new Location(); l3.setLocationId(1); l3.setLocationOrder(102);
	 * l3.setLocationSize(150); l3.setLocationX(20); l3.setLocationY(300);
	 * l3.setPlantId(1); l3.setPlantImage("/resources/images/tree3.png");
	 * 
	 * list.add(l3);
	 * 
	 * return list; }
	 */
	
		
		
	
}
