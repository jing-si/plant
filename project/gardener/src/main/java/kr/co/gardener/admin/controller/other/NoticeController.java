package kr.co.gardener.admin.controller.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.other.list.NoticeList;
import kr.co.gardener.admin.service.user.NoticeService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/notice")
public class NoticeController {
	final String path = "/admin/other/notice/";

	@Autowired
	NoticeService noticeService;

	
	
	@RequestMapping({ "/", "list" })
	public String list(Model model) {

		return path + "main";
	}

	// 상태 기록 대량 --------------------------------------------
	@RequestMapping("/api/notice")
	@ResponseBody
	public NoticeList noticeList(Pager pager) {
		NoticeList item = noticeService.list_pager(pager);
		return item;
	}

	@ResponseBody
	@PostMapping("/add/notice")
	public String noticeAdd(@RequestBody NoticeList list) {
		noticeService.insert_list(list);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/delete/notice")
	public String noticeDelete(@RequestBody NoticeList list) {
		noticeService.delete_list(list);
		return "ok";
	}

	@ResponseBody
	@PostMapping("/update/notice")
	public String noticeUpdate(@RequestBody NoticeList list) {
		noticeService.update_list(list);
		return "ok";
	}

}
