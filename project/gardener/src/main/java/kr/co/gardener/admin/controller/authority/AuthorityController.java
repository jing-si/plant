package kr.co.gardener.admin.controller.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.authority.list.AuthorityList;
import kr.co.gardener.admin.service.authority.AuthorityService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/authority")
public class AuthorityController {
final String path = "/admin/authority/authority/";
	
	@Autowired
	private AuthorityService authorityService;
	
	
	@RequestMapping({"", "/"})
	public String index() {
		return path + "main"; 
	}
	
	// 숲 관리 대량 --------------------------------------------
		@RequestMapping("/api/authority")
		@ResponseBody
		public AuthorityList authorityList(Pager pager) {
			AuthorityList item = authorityService.list_pager(pager);
			return item;
		}

		@ResponseBody
		@PostMapping("/add/authority")
		public String authorityAdd(@RequestBody AuthorityList list) {
			authorityService.insert_list(list);
			return "ok";
		}

		@ResponseBody
		@RequestMapping("/delete/authority")
		public String authorityDelete(@RequestBody AuthorityList list) {
			authorityService.delete_list(list);
			return "ok";
		}

		@ResponseBody
		@PostMapping("/update/authority")
		public String authorityUpdate(@RequestBody AuthorityList list) {
			authorityService.update_list(list);
			return "ok";
		}
}
