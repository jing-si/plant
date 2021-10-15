package kr.co.gardener.admin.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.user.list.InvenList;
import kr.co.gardener.admin.model.user.list.LocationList;
import kr.co.gardener.admin.service.user.InvenService;
import kr.co.gardener.admin.service.user.LocationService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/item")
public class ItemController {
	final String path = "/admin/users/item/";

	@Autowired
	LocationService locationService;

	@Autowired
	InvenService invenService;

	@RequestMapping({ "/", "list" })
	public String list(Model model) {

		return path + "main";
	}

	// 인증 기록 대량 --------------------------------------------
	@RequestMapping("/api/location")
	@ResponseBody
	public LocationList locationList(Pager pager) {
		LocationList item = locationService.list_pager(pager);
		return item;
	}

	@ResponseBody
	@PostMapping("/add/location")
	public String locationAdd(@RequestBody LocationList list) {
		locationService.insert_list(list);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/delete/location")
	public String locationDelete(@RequestBody LocationList list) {
		locationService.delete_list(list);
		return "ok";
	}

	@ResponseBody
	@PostMapping("/update/location")
	public String locationUpdate(@RequestBody LocationList list) {
		locationService.update_list(list);
		return "ok";
	}

	// 인증 기록 대량 --------------------------------------------
	@RequestMapping("/api/inven")
	@ResponseBody
	public InvenList invenList(Pager pager) {
		InvenList item = invenService.list_pager(pager);
		return item;
	}

	@ResponseBody
	@PostMapping("/add/inven")
	public String invenAdd(@RequestBody InvenList list) {
		invenService.insert_list(list);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/delete/inven")
	public String invenDelete(@RequestBody InvenList list) {
		invenService.delete_list(list);
		return "ok";
	}

	@ResponseBody
	@PostMapping("/update/inven")
	public String invenUpdate(@RequestBody InvenList list) {
		invenService.update_list(list);
		return "ok";
	}

}
