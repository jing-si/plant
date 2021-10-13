package kr.co.gardener.admin.controller.object;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.admin.model.object.list.CompanyList;
import kr.co.gardener.admin.service.object.CompanyService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/company/")
public class CompanyController {
	final private String path = "/admin/object/company/";
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping({"/","","main"})
	public String main() {
		
		return path + "main";
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
	
	@PostMapping("/existCompany")
	@ResponseBody
	public boolean existCompany(@RequestBody Company company) {
		return companyService.existCompany(company); 
	}
	
	//대량 --------------------------------------------
	@RequestMapping("/api/company")
	@ResponseBody
	public CompanyList CompanyList(Pager pager) {
		CompanyList item = companyService.list_pager(pager);
		return item;
	}

	@ResponseBody
	@PostMapping("/add/company")
	public String CompanyAdd(@RequestBody CompanyList list) {
		companyService.insert_list(list);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/delete/company")
	public String CompanyDelete(@RequestBody CompanyList list) {
		companyService.delete_list(list);
		return "ok";
	}

	@ResponseBody
	@PostMapping("/update/company")
	public String CompanyUpdate(@RequestBody CompanyList list) {
		companyService.update_list(list);
		return "ok";
	}
	
	
}
