package kr.co.gardener.admin.controller.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.other.list.RandomMessageList;
import kr.co.gardener.admin.model.other.list.StateList;
import kr.co.gardener.admin.service.other.RandomMessageService;
import kr.co.gardener.admin.service.other.StateService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/state")
public class StateController {
	final String path = "/admin/other/state/";

	@Autowired
	StateService stateService;

	@Autowired
	RandomMessageService randomMessageService;
	
	@RequestMapping({ "/", "" })
	public String list(Model model) {

		return path + "main";
	}

	// 상태 기록 대량 --------------------------------------------
	@RequestMapping("/api/state")
	@ResponseBody
	public StateList stateList(Pager pager) {
		StateList item = stateService.list_pager(pager);
		return item;
	}

	@ResponseBody
	@PostMapping("/add/state")
	public String stateAdd(@RequestBody StateList list) {
		stateService.insert_list(list);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/delete/state")
	public String stateDelete(@RequestBody StateList list) {
		stateService.delete_list(list);
		return "ok";
	}

	@ResponseBody
	@PostMapping("/update/state")
	public String stateUpdate(@RequestBody StateList list) {
		stateService.update_list(list);
		return "ok";
	}

	// 상태 기록 대량 --------------------------------------------
		@RequestMapping("/api/randomMessage")
		@ResponseBody
		public RandomMessageList randomMessageList(Pager pager) {
			RandomMessageList item = randomMessageService.list_pager(pager);
			return item;
		}

		@ResponseBody
		@PostMapping("/add/randomMessage")
		public String randomMessageAdd(@RequestBody RandomMessageList list) {
			randomMessageService.insert_list(list);
			return "ok";
		}

		@ResponseBody
		@RequestMapping("/delete/randomMessage")
		public String randomMessageDelete(@RequestBody RandomMessageList list) {
			randomMessageService.delete_list(list);
			return "ok";
		}

		@ResponseBody
		@PostMapping("/update/randomMessage")
		public String randomMessageUpdate(@RequestBody RandomMessageList list) {
			randomMessageService.update_list(list);
			return "ok";
		}

}
