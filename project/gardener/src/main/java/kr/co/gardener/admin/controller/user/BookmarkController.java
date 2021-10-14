package kr.co.gardener.admin.controller.user;

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

import kr.co.gardener.admin.model.user.Bookmark;
import kr.co.gardener.admin.model.user.list.BookmarkList;
import kr.co.gardener.admin.model.user.list.UserList;
import kr.co.gardener.admin.service.user.BookmarkService;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/users/bookmark")
public class BookmarkController {
	final String path = "admin/users/bookmark/";
	
	@Autowired
	BookmarkService service;
	
	@RequestMapping({"", "/list"})
	public String list(Model model) {
		List<Bookmark> list = service.list();
		model.addAttribute("list", list);
		return path+"list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path+"add";
	}
	
	@PostMapping("/add")
	public String add(Bookmark item) {
		service.add(item);
		return "redirect:list";
	}
	
	@GetMapping("/update/{bookmarkId}")
	public String update(@PathVariable int bookmarkId, Model model) {
		Bookmark item = service.item(bookmarkId);
		model.addAttribute("item", item);
		return "update";
	}
	
	@PostMapping("/update/{bookmarkId}")
	public String update(@PathVariable int bookmarkId, Bookmark item) {
		item.setBookmarkId(bookmarkId);
		service.update(item);
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{bookmarkId}")
 	public String delete(@PathVariable int bookmarkId) {
		service.delete(bookmarkId);
		return "redirect:../list";
	}
	

	
}
