package kr.co.gardener.admin.controller.object;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.admin.service.object.CompanyService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/object/company/")
public class CompanyController {
	final private String path = "/admin/object/company/";
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping({"/","","list"})
	public String list(Pager pager,Model model) {
		List<Company> list = companyService.list(pager);
		model.addAttribute("list", list);
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add() {		
		
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(Company company) {
		
		companyService.add(company);
		return "redirect:list";
	}
	
	@GetMapping("/update/{companyId}")
	public String update(@PathVariable int companyId,Model model) {
		Company item = companyService.item(companyId);
		model.addAttribute("company", item);
		return path  + "update";
	}
	
	@PostMapping("/update/{companyId}")
	public String update(Company item) {
		companyService.update(item);
		return "redirect:list";
	}
	
	@DeleteMapping("/delete/{companyId}")
	public String delete(@PathVariable int companyId) {
		companyService.delete(companyId);
		return "redirect:list";
	}
	
	@GetMapping("/search/{companyId}")
	@ResponseBody
	public Company search(@PathVariable String companyId) {		
		Company item = companyService.search(companyId);		
		return item;
	}
	
	@PostMapping("/autoupdate")
	public String autoUpdate(@RequestParam("companyIds") List<String> companyIds) {
		companyService.autoUpdate(companyIds);
		return "redirect:list";
	}
}
