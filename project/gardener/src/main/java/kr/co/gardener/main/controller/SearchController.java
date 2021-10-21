package kr.co.gardener.main.controller;

import java.util.ArrayList;
import java.util.List;

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
import kr.co.gardener.admin.model.user.SearchList;
import kr.co.gardener.admin.service.object.ProductService;

@Controller
@RequestMapping("/login/search")
public class SearchController {
	final String path = "main/search/";
	
	@Autowired
	ProductService  productService;
	
	//검색
	@GetMapping({"/",""})
	public String search(Model model) {
		//여기서부터 가상 데이터
		List<SearchList> list = new ArrayList<SearchList>();
		SearchList l1 = new SearchList();
		l1.setSearchId(1);
		l1.setSearchWord("예시 검색어1");
		l1.setUserId("001");
		list.add(l1);
		
		SearchList l2 = new SearchList();
		l2.setSearchId(2);
		l2.setSearchWord("예시 검색어2");
		l2.setUserId("001");
		list.add(l2);
		//여기까지 가상데이터
		System.out.println("--------------------------");
		System.out.println("겟겟겟겟");
		System.out.println("겟겟겟겟");
		System.out.println("겟겟겟겟");
		System.out.println("겟겟겟겟");
		System.out.println("겟겟겟겟");
		System.out.println("--------------------------");
		
		model.addAttribute("latestProductList",list);
		
		/*
		//searchWord(최근검색 제품명),searchId(최근검색 제품아이디) 리스트 구현해주세요
		model.addAttribute("latestProductList",new ArrayList<String>());
		
		*/
		return path + "search";
	}
	
	@RequestMapping("/delete/{searchId}")
	public String delete(@PathVariable SearchList searchId) {
		return "redirect:..";
	}
	
	@PostMapping("/")
	public String search(@RequestBody String q, Model model) {
		List<Product> list = productService.list(q);
		model.addAttribute("list", list);
		model.addAttribute("word", q);
		System.out.println("--------------------------");
		System.out.println(q);
		System.out.println(q);
		System.out.println(q);
		System.out.println(q);
		System.out.println(q);
		System.out.println("--------------------------");
		return path + "search";		
	}
	
	//qr 코드 인식화면으로 넘기기
	@RequestMapping("/qr")
	public String qr() {
		return path + "qr";
	}
	
	//qr 정보 받기
	@PostMapping("/qrajax")
	@ResponseBody
	public Object qr(int barcode) {
		System.out.println("바코드" + barcode);
		String certifyResult = productService.certify(barcode);
		System.out.println("db에 있나 "+certifyResult);
		
		//인증성공시 제품아이디와 회사아이디가 필요
		if(certifyResult.equals("인증성공")) {
			Product item = productService.item(barcode);
			return item;
		//인증실패시
		}else {
			return "0";
		}
		/* return certifyResult; */
	}
	
}
