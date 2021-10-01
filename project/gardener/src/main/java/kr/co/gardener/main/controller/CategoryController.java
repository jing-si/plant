package kr.co.gardener.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.productCategoryList;
import kr.co.gardener.admin.service.object.ClassifyService;
import kr.co.gardener.admin.service.object.CompanyService;
import kr.co.gardener.admin.service.object.ProductService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/login/category")
public class CategoryController {
	final String path = "main/category/";
	
	@Autowired
	ClassifyService cs;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	ProductService productService;
	
	//카테고리
	@RequestMapping({"/",""})
	public String category(Model model) {
		//productCategoryName(품목별 카테고리 대분류명),
		//subProductCategoryList(productId(품목아이디)와 subProductCategoryName(중분류 카테고리명)이 들어있는 리스트)
		//이 들어있는 품목 대분류 리스트 구현해주세요.(리스트 안에 리스트가 들어있는거 맞습니다^^)
		List<productCategoryList> list = cs.productCategoryList();
		
		model.addAttribute("productCategoryList",list);
		
		//brandName(브랜드명),brandId(브랜드 아이디)가 들어있는 리스트 구현해주세요.		 
		List<Company> companyList = companyService.list(new Pager()); 
		model.addAttribute("brandList",companyList);
		
		//markId(인증마크 아이디), markImg(인증마크 이미지), markName(인증마크명)이 들어있는 리스트 구형해주세요.
		model.addAttribute("markList",new ArrayList<String>());
		
		return path + "category-list";
	}
	
	//품목별 카테고리
	@RequestMapping("/{midClassId}")
	public String productlist(Model model,@PathVariable int midClassId) {
		
		List<Product> list = productService.MidList(midClassId);		
		
		//productId(품목별 제품아이디), productImg(품목별 제품이미지), 
		//productName(품목별 제품명)이 들어있는 리스트 구현해주세요.
		model.addAttribute("productList",list);
		return path + "product-list";
	}
	
	//해당 제품의 상세페이지
	@RequestMapping("/product/{productId}")
	public String productdetail(@PathVariable String productId, Model model) {

		Company company = companyService.productId(productId);	
		//uri로 받은 productId에 해당하는 productId(동일브랜드 제품의 아이디) sameBrandImg(동일브랜드 제품의 이미지), sameBrandName(동일브랜드 제품명)
		//이 들어있는 리스트 구현해주세요.
		Product item = company.getProduct(productId);
		model.addAttribute("company",company);
		model.addAttribute("item",item);
		return path + "product-detail";
	}
	
	//브랜드별 카테고리
	@RequestMapping("/brand/{companyId}")
	public String brandList(Model model,@PathVariable int companyId) {
		
		//브랜드 이름
		model.addAttribute("brandName","brandName");
		//productId(브랜드별 제품 아이디), productImg(브랜드별 제품이미지)
		//productName(브랜드별 제품명)이 들어있는 리스트 구현해주세요.
		  model.addAttribute("brandProductList",new ArrayList<String>());
		 
		
		//가상데이터
		/*
		 * model.addAttribute("brandName","브랜드1"); List<Product> list = new
		 * ArrayList<Product>(); Product l1 = new Product(); l1.set
		 */
		model.addAttribute("brandProductList",new ArrayList<String>());
		return path + "brand-list";
	}
	
	
	
	
	//인증마크별 카테고리
	@RequestMapping("/mark")
	public String markList(Model model) {
		//여기서부터 가상데이터

		
		
		
		//productId(해당 인증마크에 해당하는 제품 아이디), markProductImg(해당 인증마크에 해당하는 제품의 이미지), 
		//markProductName(인증마크에 해당하는 제품의 이름)이 들어있는 리스트 구현해주세요
		model.addAttribute("markProductList",new ArrayList<String>());
		
		return path + "mark-list";
	}
}
