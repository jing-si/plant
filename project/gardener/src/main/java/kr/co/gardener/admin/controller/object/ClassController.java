package kr.co.gardener.admin.controller.object;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.list.BotClassList;
import kr.co.gardener.admin.model.object.list.MidClassList;
import kr.co.gardener.admin.model.object.list.TopClassList;
import kr.co.gardener.admin.service.object.BotClassService;
import kr.co.gardener.admin.service.object.MidClassService;
import kr.co.gardener.admin.service.object.TopClassService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/class/")
public class ClassController {
	final String path = "admin/object/class/";
	@Autowired
	TopClassService topService;
	
	@Autowired
	MidClassService midService;
	
	@Autowired
	BotClassService botService;
	

	@RequestMapping({ "/list", "", "/" })
	public String list() {
		
		return path + "main";
	}
	
	
	//탑클레스 --------------------------------------------
		@RequestMapping("/api/topClass")
		@ResponseBody
		public TopClassList topClassList(Pager pager) {
			TopClassList item = topService.list_pager(pager);
			return item;
		}

		@ResponseBody
		@PostMapping("/add/topClass")
		public String topClassAdd(@RequestBody TopClassList list) {
			topService.insert(list);
			return "ok";
		}

		@ResponseBody
		@RequestMapping("/delete/topClass")
		public String topClassDelete(@RequestBody TopClassList list) {
			topService.delete(list);
			return "ok";
		}

		@ResponseBody
		@PostMapping("/update/topClass")
		public String topClassUpdate(@RequestBody TopClassList list) {
			topService.update(list);
			return "ok";
		}
		

		//미드클레스 --------------------------------------------
			@RequestMapping("/api/midClass")
			@ResponseBody
			public MidClassList midClassList(Pager pager) {
				MidClassList item = midService.list_pager(pager);
				return item;
			}

			@ResponseBody
			@PostMapping("/add/midClass")
			public String midClassAdd(@RequestBody MidClassList list) {
				midService.insert(list);
				return "ok";
			}

			@ResponseBody
			@RequestMapping("/delete/midClass")
			public String midClassDelete(@RequestBody MidClassList list) {
				midService.delete(list);
				return "ok";
			}

			@ResponseBody
			@PostMapping("/update/midClass")
			public String midClassUpdate(@RequestBody MidClassList list) {
				midService.update(list);
				return "ok";
			}
			
			//봇클레스 --------------------------------------------
			@RequestMapping("/api/botClass")
			@ResponseBody
			public BotClassList botClassList(Pager pager) {
				BotClassList item = botService.list_pager(pager);
				return item;
			}

			@ResponseBody
			@PostMapping("/add/botClass")
			public String botClassAdd(@RequestBody BotClassList list) {
				botService.insert(list);
				return "ok";
			}

			@ResponseBody
			@RequestMapping("/delete/botClass")
			public String botClassDelete(@RequestBody BotClassList list) {
				botService.delete(list);
				return "ok";
			}

			@ResponseBody
			@PostMapping("/update/botClass")
			public String botClassUpdate(@RequestBody BotClassList list) {
				botService.update(list);
				return "ok";
			}
}
