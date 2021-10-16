package kr.co.gardener.admin.controller.forests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.forest.list.ForestList;
import kr.co.gardener.admin.service.forest.ForestService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/forest")
public class ForestController {
	final String path = "/admin/forests/forest/";
	
	@Autowired
	private ForestService forestService;
	
	
	@RequestMapping({"", "/"})
	public String index() {
		return path + "main"; 
	}
	
	// 숲 관리 대량 --------------------------------------------
		@RequestMapping("/api/forest")
		@ResponseBody
		public ForestList forestList(Pager pager) {
			ForestList item = forestService.list_pager(pager);
			return item;
		}

		@ResponseBody
		@PostMapping("/add/forest")
		public String forestAdd(@RequestBody ForestList list) {
			forestService.insert_list(list);
			return "ok";
		}

		@ResponseBody
		@RequestMapping("/delete/forest")
		public String forestDelete(@RequestBody ForestList list) {
			forestService.delete_list(list);
			return "ok";
		}

		@ResponseBody
		@PostMapping("/update/forest")
		public String forestUpdate(@RequestBody ForestList list) {
			forestService.update_list(list);
			return "ok";
		}

		
}
