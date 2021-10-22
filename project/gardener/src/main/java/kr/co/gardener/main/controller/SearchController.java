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
	ProductService productService;

	// 검색
	@GetMapping({ "/", "" })
	public String search(Model model) {
		// 여기서부터 가상 데이터
		List<SearchList> list = new ArrayList<SearchList>();

		model.addAttribute("latestProductList", list);

		/*
		 * //searchWord(최근검색 제품명),searchId(최근검색 제품아이디) 리스트 구현해주세요
		 * model.addAttribute("latestProductList",new ArrayList<String>());
		 * 
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

	// qr 코드 인식화면으로 넘기기
	@GetMapping("/qr")
	public String qr(String barcode,Model model) {
		Product item = productService.certify(barcode);
		String q = null;
		if(item == null) {
			q = barcode;
			List<Product> list = new ArrayList<>();
			model.addAttribute("list", list);
			model.addAttribute("word", q);
			return path + "search";
		}else {
			q = "/login/category/product/"+item.getProductId()+"/"+item.getCompanyId(); 
			return "redirect:"+ q;
		}
	}

	// qr 정보 받기
	/*
	 * @PostMapping("/qrajax")
	 * 
	 * @ResponseBody public Object qra(String barcode) { System.out.println("바코드" +
	 * barcode); String certifyResult = productService.certify(barcode);
	 * System.out.println("db에 있나 "+certifyResult);
	 * 
	 * //인증성공시 제품아이디와 회사아이디가 필요 if(certifyResult.equals("인증성공")) { //Product item =
	 * productService.item(barcode); return "1"; //인증실패시 }else { return "0"; }
	 * return certifyResult; }
	 */

}
