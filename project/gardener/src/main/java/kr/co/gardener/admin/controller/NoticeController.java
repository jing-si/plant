package kr.co.gardener.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.Notice;
import kr.co.gardener.admin.service.NoticeService;


@Controller
@RequestMapping("/admin/notice")
public class NoticeController {
	final String path = "admin/notice/";
	
	@Autowired
	NoticeService service;
	
	@RequestMapping({"/", "list"})
	public String list(Model model) {
		List<Notice> list = service.list();
		model.addAttribute("list", list);
		return path+"list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path+"add";
	}
	
	@PostMapping("/add")
	public String add(Notice item) {
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{noticeId}")
	public String update(@PathVariable int noticeId, Model model) {
		Notice item = service.item(noticeId);
		model.addAttribute("item", item);
		return path+"update";
	}
	
	@PostMapping("/update/{noticeId}")
	public String update(@PathVariable int noticeId, Notice item) {
		item.setNoticeId(noticeId);
		service.update(item);
		return "redirect:../list";
	}
	
	@RequestMapping("/delete/{noticeId}")
	public String delete(@PathVariable int noticeId) {
		service.delete(noticeId);
		return "redirect:../list";
	}
	
}