package kr.co.gardener.admin.controller.object;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.service.object.ProductService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/object/product/")
public class ProductController {
	final private String path = "admin/object/product/";
	@Autowired
	ProductService service;
	
	@RequestMapping({"/","list",""})
	public String list(Pager pager) {
		List<Product> list = service.list(pager);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path +"add";
	}
	
	@PostMapping("/add")
	public String add(Product product) {
		service.add(product);
		return "redirect:list";
	}
	
	@GetMapping("/update/{productId}")
	public String update(@PathVariable int productId,Model model) {
		Product item = service.item(productId);
		model.addAttribute("item",item );		
		return "update";
	}
	
	@PostMapping("/update/{productId}")
	public String update(Product item) {		
		service.update(item);
		return "redirect:../list";
	}
	
	@RequestMapping("/delete/{productId}")
	public String delete(@PathVariable int productId) {
		service.delete(productId);
		return "redirect:../list";
	}
}
