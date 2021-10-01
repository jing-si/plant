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

import kr.co.gardener.admin.model.Plant;
import kr.co.gardener.admin.service.PlantService;
import kr.co.gardener.util.FileUpload;

@Controller
@RequestMapping("/admin/forests/plants/plant")
public class PlantController {
	final String path = "admin/forests/plants/plant/";
	
	@Autowired
	PlantService service;
	
	@RequestMapping({"/","list"})
	public String list(Model model) {
		List<Plant> list = service.list();
		model.addAttribute("list", list);
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(Plant item, MultipartFile uploadFile) {
		item.setPlantShadow(FileUpload.Uploader(uploadFile, "plantShadow"));
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{plantId}")
	public String update(@PathVariable int plantId, Model model) {
		Plant item = service.item(plantId);
		model.addAttribute("item", item);
		return path + "update";	
	}
	
	@PostMapping("/update/{plantId}")
	public String update(@PathVariable int plantId, Plant item) {
		item.setPlantId(plantId);
		service.update(item);
		return "redirect:../list";
	}
	
	@RequestMapping("/delete/{plantId}")
	public String delete(@PathVariable int plantId) {
		service.delete(plantId);
		return "redirect:../list";
	}
}
