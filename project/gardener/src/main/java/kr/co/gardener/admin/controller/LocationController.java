package kr.co.gardener.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.Location;
import kr.co.gardener.admin.service.LocationService;

@Controller
@RequestMapping("/admin/users/location")
public class LocationController {
	final String path = "admin/users/location/";
	
	@Autowired
	LocationService service;
	
	@RequestMapping({"/", "/list"})
	public String list(Model model) {
		List<Location> list = service.list();
		model.addAttribute("list", list);
		return path + "list";
	}
	
	@GetMapping ("/add")
	public String add() {
		return path + "/add";
	}
	
	@PostMapping("/add")
	public String add(Location item) {
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{locationId}")
	public String update(@PathVariable int locationId, Model model) {
		Location item = service.item(locationId);
		model.addAttribute("item", item);
		return path + "update";
	}
	
	@PostMapping("/update")
	public String update(Location item) {
		service.update(item);
		return "redirect:../list";
	}
	
	@RequestMapping("/delete/{locationId}")
	public String delete(@PathVariable int locationId) {
		service.delete(locationId);
		return "redirect:../list";
	}

}
