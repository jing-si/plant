package kr.co.gardener.admin.controller.object;

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
import org.springframework.web.multipart.MultipartFile;

import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.list.CertList;
import kr.co.gardener.admin.service.object.CertService;
import kr.co.gardener.util.FileUpload;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/object/cert/")
public class CertController {
	final String path = "admin/object/cert/";

	@Autowired
	CertService service;

	@RequestMapping({ "/list", "", "/" })
	public String list(Model model) {
		List<Cert> list = service.list();
		model.addAttribute("list", list);
		return path + "main";
	}

	@GetMapping("/add")
	public String add() {

		return path + "add";
	}

	@PostMapping("/add")
	public String add(Cert item, MultipartFile uploadFile) {
		item.setCertImage(FileUpload.Uploader(uploadFile, "cert"));
		service.add(item);
		return "redirect:list";
	}

	@GetMapping("/update/{certId}")
	public String update(@PathVariable int certId, Model model) {
		Cert item = service.item(certId);
		model.addAttribute("item", item);
		return path + "update";
	}

	@PostMapping("/update/{certId}")
	public String update(Cert item) {
		service.update(item);
		return "redirect:../list";
	}

	@RequestMapping("delete/{certId}")
	public String delete(@PathVariable int certId) {
		service.delete(certId);
		return "redirect:../list";
	}

	// 인증
	@RequestMapping("/api/cert")
	@ResponseBody
	public CertList certList(Pager pager) {

		CertList item = service.list(pager);

		return item;
	}

	@ResponseBody
	@PostMapping("/add/cert")
	public String certAdd(@RequestBody CertList list) {
		System.out.println(list.getList().get(0).toString());
		service.insert(list);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/delete/cert")
	public String certDelete(@RequestBody CertList list) {
		service.delete(list);
		return "ok";
	}

	@ResponseBody
	@PostMapping("/update/cert")
	public String certUpdate(@RequestBody CertList list) {
		service.update(list);
		return "ok";
	}

	
}
