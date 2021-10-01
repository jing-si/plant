package kr.co.gardener.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.gardener.admin.model.PlantLevel;
import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.admin.service.PlantLevelService;
import kr.co.gardener.util.FileUpload;

@Controller
@RequestMapping("/admin/forests/plants/plantLevel")
public class PlantLevelController {
	final String path = "admin/forests/plants/plantLevel/";
	
	@Autowired
	PlantLevelService service;
	
	@RequestMapping({"/","/list"})
	public String list(Model model) {
		System.out.println("list");
		List<PlantLevel> list = service.list();
		model.addAttribute("list", list);
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	
	@PostMapping("/add")
	public String add(PlantLevel item, MultipartFile uploadFile) {
		item.setPlantImage(FileUpload.Uploader(uploadFile, "shadow"));
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{plantLevelId}")
	public String update(@PathVariable int plantLevelId, Model model) {
		PlantLevel item = service.item(plantLevelId);
		model.addAttribute("item", item);
		return path + "update";
	}
	
	@PostMapping("/update")
	public String update(PlantLevel item) {
		service.update(item);
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{plantLevelId}")
	public String delete(@PathVariable int plantLevelId) {
		service.delete(plantLevelId);
		return "redirect:../list";
	}
		
}
