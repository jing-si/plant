package kr.co.gardener.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.SearchList;
import kr.co.gardener.admin.service.SearchListService;

@Controller
@RequestMapping("/admin/users/searchList")
public class SearchListController {
	@Autowired
	SearchListService service;

	final String path = "admin/users/searchList/";

	@RequestMapping({"","/list"})
	public String list(Model model) {
		List<SearchList> list= service.list();
		model.addAttribute("list", list);
		return path + "list";
	}

	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(SearchList item) {
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{searchId}")
	public String update(@PathVariable int searchId, Model model) {
		SearchList item = service.item(searchId);
		model.addAttribute("item", item);
		return path+"update";
	}
	
	@PostMapping("/update/{searchId}")
	public String update(@PathVariable int searchId, SearchList item) {
		item.setSearchId(searchId);
		service.update(item);
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{searchId}")
	public String delete(@PathVariable int searchId) {
		service.delete(searchId);
		return "redirect:../list";				
	}
}
