package kr.co.gardener.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.SearchList;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.service.object.ProductService;

@Controller
@RequestMapping("/login/search")
public class SearchController {
	final String path = "main/search/";
	
	@Autowired
	ProductService  productService;
	
	//검색
	@RequestMapping({"/",""})
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
	public String search(String q, Model model) {
		List<Product> list = productService.list(q);
		model.addAttribute("list", list);
		model.addAttribute("word", q);
		
		return path + "search";		
	}
	
}
