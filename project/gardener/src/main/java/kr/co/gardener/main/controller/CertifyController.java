package kr.co.gardener.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login/certify")
public class CertifyController {
	final String path = "certify/";
	
	//인증카메라
	@RequestMapping("certify")
	public String certify() {
		return "certify";
	}
}
