package kr.co.gardener.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.user.Bookmark;
import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.admin.service.object.CertReasonService;
import kr.co.gardener.admin.service.object.CertService;
import kr.co.gardener.admin.service.object.CompanyService;
import kr.co.gardener.admin.service.object.MidClassService;
import kr.co.gardener.admin.service.object.ProductService;
import kr.co.gardener.admin.service.object.TopClassService;
import kr.co.gardener.admin.service.user.BookmarkService;
import kr.co.gardener.main.vo.TopClassVO;
import kr.co.gardener.main.vo.BrandVO;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/login/category")
public class CategoryController {
	final String path = "main/category/";
	
	@Autowired
	TopClassService topClassService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	BookmarkService bookmarkService;
	
	@Autowired
	MidClassService midClassService;
	
	@Autowired
	CertReasonService certReasonService;
	
	@Autowired
	CertService certService;
	
	//카테고리
	@RequestMapping({"/",""})
	public String category(Model model) {
		//productCategoryName(품목별 카테고리 대분류명),
		//subProductCategoryList(productId(품목아이디)와 subProductCategoryName(중분류 카테고리명)이 들어있는 리스트)
		//이 들어있는 품목 대분류 리스트 구현해주세요.(리스트 안에 리스트가 들어있는거 맞습니다^^)
		List<TopClassVO> list = topClassService.includMidClassList();
		
		model.addAttribute("productCategoryList",list);
		
		//brandName(브랜드명),brandId(브랜드 아이디)가 들어있는 리스트 구현해주세요.		 
//		List<Company> companyList = companyService.list(new Pager()); 
//		model.addAttribute("brandList",companyList);
		List<BrandVO> brandList = companyService.brandList();
		
		model.addAttribute("brandList", brandList);
		
		//markId(인증마크 아이디), markImg(인증마크 이미지), markName(인증마크명)이 들어있는 리스트 구형해주세요.
		model.addAttribute("markList",new ArrayList<String>());
		
		return path + "category-list";
	}
	
	//품목별 카테고리
	@RequestMapping("/{midClassId}")
	public String productlist(Model model,@PathVariable int midClassId) {
		
		List<Product> list = productService.MidList(midClassId);		
		String midClassName = midClassService.item(midClassId).getMidClassName();
		//productId(품목별 제품아이디), productImg(품목별 제품이미지), 
		//productName(품목별 제품명)이 들어있는 리스트 구현해주세요.
		model.addAttribute("midClassName", midClassName);
		model.addAttribute("productList",list);
		return path + "product-list";
	}
	
	//해당 제품의 상세페이지
	@RequestMapping("/product/{productId}/{companyId}")
	public String productdetail(@PathVariable String productId,@PathVariable String companyId, Model model,HttpSession session) {
		String userId = ((User) session.getAttribute("user")).getUserId();		
			
		Company company = companyService.itemIncludeProduct(companyId,userId);
		Product item = company.getProduct(productId);		
		Cert cert = certService.getCertInfo(String.valueOf(item.getCertId()));
		certReasonService.fillProduct(item);
		
		model.addAttribute("company",company);
		model.addAttribute("item",item);
		model.addAttribute("cert",cert);
		
		
		return path + "product-detail";
	}
	
	//브랜드별 카테고리
	@RequestMapping("/brand/{companyId}")
	public String brandList(Model model,@PathVariable String companyId,HttpSession session) {
		String userId = ((User) session.getAttribute("user")).getUserId();		
		
		Company company = companyService.itemIncludeProduct(companyId,userId);
		
		//브랜드 이름
		model.addAttribute("brandName",company.getCompanyName());
		//productId(브랜드별 제품 아이디), productImg(브랜드별 제품이미지)
		//productName(브랜드별 제품명)이 들어있는 리스트 구현해주세요.
		  model.addAttribute("brandProductList",company.getList());
		 
		
		//가상데이터
		/*
		 * model.addAttribute("brandName","브랜드1"); List<Product> list = new
		 * ArrayList<Product>(); Product l1 = new Product(); l1.set
		 */
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
	
	
	//제품상세 페이지에서 즐겨찾기 추가
	@RequestMapping("/product/insert")
	@ResponseBody
	public void insert(String productId,HttpSession session, String companyId) {
		String userId = ((User) session.getAttribute("user")).getUserId();
		
		Bookmark item = new Bookmark();
		item.setProductId(productId);
		item.setCompanyId(companyId);
		item.setUserId(userId);
		
		bookmarkService.add(item);
	}
	
	//제품상세 페이지에서 즐겨찾기 삭제
	@RequestMapping("/product/delete")
	@ResponseBody
	public void delete(String productId, HttpSession session) {
		String userId = ((User) session.getAttribute("user")).getUserId();
		
		Bookmark item = new Bookmark();
		item.setProductId(productId);
		item.setUserId(userId);
	
		bookmarkService.delete(item);
	}
}
