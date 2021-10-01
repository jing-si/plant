package kr.co.gardener.admin.controller.object;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.admin.service.object.CertReasonService;
import kr.co.gardener.util.FileUpload;




@Controller
@RequestMapping("/admin/object/reason/")
public class CertReasonController {
	final String path = "admin/object/reason/";

	@Autowired
	CertReasonService service;

	@RequestMapping({ "/", "/list" })
	public String list(Model model,HttpSession session) {		
		System.out.println(System.getProperty("user.dir"));
		List<CertReason> list = service.list();
		model.addAttribute("list", list);
		return path + "list";
	}

	@GetMapping("/add")
	public String add() {

		return path + "add";
	}

	@PostMapping("/add")
	@Transactional
	public String add(CertReason item ,MultipartFile uploadFile) {
		System.out.println("postAdd");
		
		item.setCertReasonImage(FileUpload.Uploader(uploadFile, "certReason"));
		
		service.add(item);
		return "redirect:list";
	}

	@GetMapping("/update/{certReasonId}")
	public String update(@PathVariable int certReasonId, Model model) {
		CertReason item = service.item(certReasonId);
		model.addAttribute("item", item);
		return path + "update";
	}

	@PostMapping("/update")
	public String update(CertReason item) {
		service.update(item);
		return "redirect:list";
	}

	@GetMapping("/delete/{certReasonId}")
	public String delete(@PathVariable int certReasonId) {
		service.delete(certReasonId);
		return "redirect:list";
	}
}
