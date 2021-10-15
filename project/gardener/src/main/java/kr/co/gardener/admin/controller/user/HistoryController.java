package kr.co.gardener.admin.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.user.History;
import kr.co.gardener.admin.model.user.list.BookmarkList;
import kr.co.gardener.admin.model.user.list.HistoryList;
import kr.co.gardener.admin.service.user.BookmarkService;
import kr.co.gardener.admin.service.user.HistoryService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/history")
public class HistoryController {
	final String path = "/admin/users/history/";

	@Autowired
	HistoryService service;

	@Autowired
	BookmarkService bookmarkService;

	@RequestMapping({ "/", "list" })
	public String list(Model model) {

		return path + "main";
	}

	@GetMapping("/add")
	public String add() {
		return path + "add";
	}

	@PostMapping("/add")
	public String add(History item) {
		service.add(item);
		return "redirect:list";
	}

	@GetMapping("/update/{historyId}")
	public String update(@PathVariable int historyId, Model model) {
		History item = service.item(historyId);
		model.addAttribute("item", item);
		return path + "update";
	}

	@PostMapping("/update/{historyId}")
	public String update(@PathVariable int historyId, History item) {
		item.setHistoryId(historyId);
		service.update(item);
		return "redirect:../list";
	}

	@RequestMapping("/delete/{historyId}")
	public String delete(@PathVariable int historyId) {
		service.delete(historyId);
		return "redirect:../list";
	}

	// 즐겨찾기 대량 --------------------------------------------
	@RequestMapping("/api/bookmark")
	@ResponseBody
	public BookmarkList bookmarkList(Pager pager) {
		BookmarkList item = bookmarkService.list_pager(pager);
		return item;
	}

	@ResponseBody
	@PostMapping("/add/bookmark")
	public String bookmarkAdd(@RequestBody BookmarkList list) {
		bookmarkService.insert_list(list);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/delete/bookmark")
	public String bookmarkDelete(@RequestBody BookmarkList list) {
		bookmarkService.delete_list(list);
		return "ok";
	}

	@ResponseBody
	@PostMapping("/update/bookmark")
	public String bookmarkUpdate(@RequestBody BookmarkList list) {
		bookmarkService.update_list(list);
		return "ok";
	}

	// 인증 기록 대량 --------------------------------------------
	@RequestMapping("/api/history")
	@ResponseBody
	public HistoryList historyList(Pager pager) {
		HistoryList item = service.list_pager(pager);
		return item;
	}

	@ResponseBody
	@PostMapping("/add/history")
	public String historyAdd(@RequestBody HistoryList list) {
		service.insert_list(list);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/delete/history")
	public String historyDelete(@RequestBody HistoryList list) {
		service.delete_list(list);
		return "ok";
	}

	@ResponseBody
	@PostMapping("/update/history")
	public String historyUpdate(@RequestBody HistoryList list) {
		service.update_list(list);
		return "ok";
	}
}
