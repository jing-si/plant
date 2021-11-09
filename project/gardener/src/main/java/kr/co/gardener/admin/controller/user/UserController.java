package kr.co.gardener.admin.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.object.list.ProductList;
import kr.co.gardener.admin.model.user.list.UserList;
import kr.co.gardener.admin.service.user.UserService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/user")
public class UserController {
	final String path = "admin/users/user/";
	
	@Autowired
	UserService service;
	
	@RequestMapping({"/", ""})
	public String main() {
		return path+"main";
	}
	
	//대량 --------------------------------------------
	@RequestMapping("/api/user")
	@ResponseBody
	public UserList userList(Pager pager) {
		UserList item = service.list_pager(pager);
		return item;
	}

	@ResponseBody
	@PostMapping("/add/user")
	public String userAdd(@RequestBody UserList list) {
		service.insert_list(list);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/delete/user")
	public String userDelete(@RequestBody UserList list) {
		service.delete_list(list);
		return "ok";
	}

	@ResponseBody
	@PostMapping("/update/user")
	public String userUpdate(@RequestBody UserList list) {
		service.update_list(list);
		return "ok";
	}
}