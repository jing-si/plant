package kr.co.gardener.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.gardener.admin.model.Forest;
import kr.co.gardener.admin.service.ForestService;
import kr.co.gardener.util.FileUpload;

@Controller
@RequestMapping("/admin/forests/forest")
public class ForestController {
	final String path = "admin/forests/forest/";

	@Autowired
	ForestService service;

	@RequestMapping({ "/", "list" })
	public String list(Model model) {
		List<Forest> list = service.list();
		model.addAttribute("list", list);
		return path + "list";
	}

	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	
	public String add(Forest item, MultipartFile uploadFile) {
		item.setForestImage(FileUpload.Uploader(uploadFile, "forest"));
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{forestId}")
	public String update(@PathVariable int forestId, Model model) {
		Forest item = service.item(forestId);
		model.addAttribute("item", item);
		return path + "update";
	}
	
	@PostMapping("/update")
	public String update(Forest item) {
		service.update(item);
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{forestId}")
	public String delete(@PathVariable int forestId) {
		service.delete(forestId);
		return "redirect:../list";
	}
	
	
}
