package kr.co.gardener.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gardener.admin.model.user.Bookmark;
import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.admin.service.user.BookmarkService;
import kr.co.gardener.admin.service.user.UserService;

@Controller
@RequestMapping("/login/favorite")
public class FavoriteController {
	final String path = "main/";
	
	@Autowired
	BookmarkService bookmarkService;
	
	@Autowired
	UserService userService;
	
	//즐겨찾기
	@RequestMapping({"","/"})
	public String favorite(Model model, HttpSession session) {
		//여기서부터 가상데이터
//		List<Bookmark> list = new ArrayList<Bookmark>();
//		Bookmark l1 = new Bookmark();
//		l1.setBookmarkId(1);
//		l1.setProductId(1);
//		l1.setUserId("1");
//		list.add(l1);
//		
//		Bookmark l2 = new Bookmark();
//		l2.setBookmarkId(1);
//		l2.setProductId(1);
//		l2.setUserId("1");
//		list.add(l2);
//		model.addAttribute("favoriteList",list);
		//여가까지 가상데이터
		
		
		
		//productId(즐겨찾기 선택된 제품의 아이디), favoriteImg(즐겨찾기 선택된 제품의 이미지), favoriteName(즐겨찾기 선택된 제품의 이름)
		//가 들어있있는 리스트 구현해주세요
		//String userId = (String) session.getAttribute("userId");
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId();
		System.out.println("userId"+userId);
		
		List<Bookmark> list_date = bookmarkService.list_date(userId);
		List<Bookmark> list_name = bookmarkService.list_name(userId);
		
		model.addAttribute("list_date",list_date);
		model.addAttribute("list_name",list_name);
		
		
		//제품 순 
		return path + "favorite";
	}

}
