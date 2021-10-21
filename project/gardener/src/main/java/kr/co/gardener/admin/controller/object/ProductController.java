package kr.co.gardener.admin.controller.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.list.CompanyList;
import kr.co.gardener.admin.model.object.list.ProductList;
import kr.co.gardener.admin.service.object.ProductService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/product/")
public class ProductController {
	final private String path = "admin/object/product/";
	@Autowired
	ProductService service;
	
	@RequestMapping({"/","list",""})
	public String list(Pager pager) {
		return path + "main";
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
	
	//대량 --------------------------------------------
			@RequestMapping("/api/product")
			@ResponseBody
			public ProductList productList(Pager pager) {
				ProductList item = service.list_pager(pager);
				return item;
			}

			@ResponseBody
			@PostMapping("/add/product")
			public String productAdd(@RequestBody ProductList list) {
				service.insert_list(list);
				return "ok";
			}

			@ResponseBody
			@RequestMapping("/delete/product")
			public String productDelete(@RequestBody ProductList list) {
				service.delete_list(list);
				return "ok";
			}

			@ResponseBody
			@PostMapping("/update/product")
			public String productUpdate(@RequestBody ProductList list) {
				service.update_list(list);
				return "ok";
			}
			
			@PostMapping("/autoupdate/product")
			@ResponseBody
			public String autoUpdate(@RequestBody ProductList list) {
				service.autoUpdate(list);
				return "ok";
			}
}
