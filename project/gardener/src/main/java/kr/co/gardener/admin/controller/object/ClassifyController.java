package kr.co.gardener.admin.controller.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.object.Classify;
import kr.co.gardener.admin.model.object.ClassifyList;
import kr.co.gardener.admin.service.object.ClassifyService;
@Controller
@RequestMapping("/admin/object/classify/")
public class ClassifyController {
	final String path = "admin/object/classify/";
	
	@Autowired
	private ClassifyService classifyService;
	
	@RequestMapping({"/","/list"})
	public String classify(Model model) {
		ClassifyList list = classifyService.getList();
		
		model.addAttribute("topClass", list.getTopClass());
		model.addAttribute("midClass", list.getMidClass());
		model.addAttribute("botClass", list.getBotClass());
		
		return path + "list";		
	}
	
	@PostMapping("/top/add")
	public String topAdd(Classify item) {
		classifyService.topAdd(item);
		return "redirect:../list";
	}
	@PostMapping("/mid/add")
	public String midAdd(Classify item) {
		classifyService.midAdd(item);
		return "redirect:../list";
	}
	@PostMapping("/bot/add")
	public String botAdd(Classify item) {
		classifyService.botAdd(item);
		return "redirect:../list";
	}
	
	@PostMapping("/top/update")
	public String topUpdate(Classify item) {
		classifyService.topUpdate(item);
		return "redirect:../list";
	}
	@PostMapping("/mid/update")
	public String midUpdate(Classify item) {
		classifyService.midUpdate(item);
		return "redirect:../list";
	}
	@PostMapping("/bot/update")
	public String botUpdate(Classify item) {
		classifyService.botUpdate(item);
		return "redirect:../list";
	}
	
	@GetMapping("/top/delete/{primaryId}")
	public String topUpdate(@PathVariable int primaryId) {
		classifyService.topDelete(primaryId);
		return "redirect:../../list";
	}
	@GetMapping("/mid/delete/{primaryId}")
	public String midpdate(@PathVariable int primaryId) {
		System.out.println(primaryId);
		classifyService.midDelete(primaryId);
		return "redirect:../../list";
	}
	@GetMapping("/bot/delete/{primaryId}")
	public String botUpdate(@PathVariable int primaryId) {
		classifyService.botDelete(primaryId);
		return "redirect:../../list";
	}
	
}
