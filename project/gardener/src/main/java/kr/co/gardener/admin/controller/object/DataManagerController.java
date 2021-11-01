package kr.co.gardener.admin.controller.object;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.object.ApiProduct;
import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.list.ApiProductList;
import kr.co.gardener.admin.model.object.list.ProductList;
import kr.co.gardener.admin.service.object.CompanyService;
import kr.co.gardener.admin.service.object.DataManagerService;

@Controller
@RequestMapping("/admin/datamanager")
public class DataManagerController {
	final String path = "admin/object/datamanager/";

	@Autowired
	DataManagerService service;
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping({"/",""})
	public String list() {
		
		return path + "main";
	}
	
	@RequestMapping({ "/list/{start}/{end}" })
	@ResponseBody
	public List<Company> list(@PathVariable int start, @PathVariable int end) {
		List<Company> list = service.list(start,end);		
		
		return list;
	}
	
	@RequestMapping("/productlist/{companyId}")
	@ResponseBody
	public List<ApiProduct> productList(@PathVariable long companyId){
			List<ApiProduct> list = service.productList(companyId);
			List<ApiProduct> elist = service.eProductList(companyId);
			list.addAll(elist);
		return list;
	}
	
	@RequestMapping({ "/productlist/{start}/{end}" })
	@ResponseBody
	public List<ApiProduct> productList(@PathVariable int start, @PathVariable int end) {
		List<ApiProduct> list = service.productList(start,end);		
		
		return list;
	}
	
	@RequestMapping("/companylist/db")
	@ResponseBody
	public List<Company> companylist(){
		List<Company> list = companyService.listIncludeCount();
		
		return list;
	}
	
	@RequestMapping(value = "add/apiproduct", method = RequestMethod.POST,produces ="text/plain; charset=UTF-8" )
	@ResponseBody
	public String UploadApiProduct(@RequestBody ApiProductList list) {		
		String result = service.UploadApiProduct(list);
		if(result == null) {
			return "ok";
		}
		return  result;
	}
}
