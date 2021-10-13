package kr.co.gardener.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.service.object.CertReasonService;
import kr.co.gardener.admin.service.object.CertService;

@Controller
@RestController
@RequestMapping("/certinfo")
public class CertInfoController {
	@Autowired
	CertService certService;
	
	@Autowired
	CertReasonService certReasonService;
	
	@RequestMapping("/cert")
	public Cert certInfo(String value) {
		Cert cert = certService.getCertInfo(value);
		
		return cert;
		
	}
}
