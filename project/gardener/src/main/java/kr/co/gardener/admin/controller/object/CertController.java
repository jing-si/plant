package kr.co.gardener.admin.controller.object;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.service.object.CertService;
import kr.co.gardener.util.FileUpload;

@Controller
@RequestMapping("/admin/object/cert/")
public class CertController {
	final String path = "admin/object/cert/";
	
	@Autowired
	CertService service;
	
	@RequestMapping({"/list","","/"})
	public String list(Model model) {
		List<Cert> list = service.list();
		model.addAttribute("list", list);
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add() {
		
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(Cert item,MultipartFile uploadFile) {
		item.setCertImage(FileUpload.Uploader(uploadFile, "cert"));
		service.add(item);		
		return "redirect:list";
	}
	
	@GetMapping("/update/{certId}")
	public String update(@PathVariable int certId,Model model) {
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
	public String delete(@PathVariable int certId){
		service.delete(certId);
		return "redirect:../list";
	}

}
