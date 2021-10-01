package kr.co.gardener.admin.controller.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.object.ProductCertReason;
import kr.co.gardener.admin.service.object.ProductCertReasonService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/object/productcertreason/")
public class ProductCertReasonController {
	final private String path = "/admin/object/productcertreason/"; 
	@Autowired
	ProductCertReasonService service;
	
	@RequestMapping("/list")
	public String list(Model model,Pager pager) {
		service.list(pager);
		return path + "list";	
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(ProductCertReason item) {
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{productCertReasonId}")
	public String update(@PathVariable int productCertReasonId,Model model) {
		service.item(productCertReasonId);
		model.addAttribute(path, model);
		return path + "update";
		
	}
	
	@PostMapping("/update/{productCertReasonId}")
	public String update(ProductCertReason item) {
		service.update(item);
		return "redirect:../list";
	}
	
	@RequestMapping("/delete/{productCertReasonId}")
	public String delete(@PathVariable int productCertReasonId) {
		service.delete(productCertReasonId);
		return "rediret:../list";
	}
}
