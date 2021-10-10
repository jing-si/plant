package kr.co.gardener.admin.controller.object;

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
import kr.co.gardener.admin.model.object.list.CertReasonList;
import kr.co.gardener.admin.model.object.list.ProductCertReasonList;
import kr.co.gardener.admin.service.object.CertReasonService;
import kr.co.gardener.admin.service.object.CertService;
import kr.co.gardener.admin.service.object.ProductCertReasonService;
import kr.co.gardener.util.FileUpload;
import kr.co.gardener.util.Pager;

@Controller
@RequestMapping("/admin/cert/")
public class CertController {
	final String path = "admin/object/cert/";

	@Autowired
	CertService service;
	
	@Autowired
	CertReasonService crService;
	
	@Autowired
	ProductCertReasonService pcrService; 

	@RequestMapping({ "/list", "", "/" })
	public String list() {
	
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

	// 인증-------------------------------------
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
	
	//인증 사유------------------------------------------
	@RequestMapping("/api/certReason")
	@ResponseBody
	public CertReasonList certReasonList(Pager pager) {
		CertReasonList item = crService.list(pager);
		return item;
	}

	@ResponseBody
	@PostMapping("/add/certReason")
	public String certReasonAdd(@RequestBody CertReasonList list) {
		crService.insert(list);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/delete/certReason")
	public String certReasonDelete(@RequestBody CertReasonList list) {
		crService.delete(list);
		return "ok";
	}

	@ResponseBody
	@PostMapping("/update/certReason")
	public String certReasonUpdate(@RequestBody CertReasonList list) {
		crService.update(list);
		return "ok";
	}
	
	//제품 인증 사유 --------------------------------------------
	@RequestMapping("/api/productCertReason")
	@ResponseBody
	public ProductCertReasonList producCertReasonList(Pager pager) {
		ProductCertReasonList item = pcrService.list_pager(pager);
		return item;
	}

	@ResponseBody
	@PostMapping("/add/productCertReason")
	public String productCertReasonAdd(@RequestBody ProductCertReasonList list) {
		pcrService.insert(list);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/delete/productCertReason")
	public String productCertReasonDelete(@RequestBody ProductCertReasonList list) {
		pcrService.delete(list);
		return "ok";
	}

	@ResponseBody
	@PostMapping("/update/ProductCertReason")
	public String productCertReasonUpdate(@RequestBody ProductCertReasonList list) {
		pcrService.update(list);
		return "ok";
	}
	
	
}
