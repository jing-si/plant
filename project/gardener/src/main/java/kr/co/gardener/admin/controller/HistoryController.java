package kr.co.gardener.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.History;
import kr.co.gardener.admin.service.HistoryService;

@Controller
@RequestMapping("/admin/users/history")
public class HistoryController {
	final String path = "/admin/users/history/";
	
	@Autowired
	HistoryService service;
	
	@RequestMapping({"/","list"})
	public String list(Model model) {
		List<History> list = service.list();
		model.addAttribute("list", list);
		return path + "list";
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
	
	
}
