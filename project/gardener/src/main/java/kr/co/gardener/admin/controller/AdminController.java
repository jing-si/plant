package kr.co.gardener.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.gardener.util.FileUpload;

@Controller
@RequestMapping("/admin")
public class AdminController {
	final String path = "admin/";
	
	@RequestMapping({"/",""})
	public String index() {
		return path + "admin2";
	}
	
	@PostMapping("/fileUpload")
	@ResponseBody
	public List<String> fileUploader(String folder,List<MultipartFile> files) {
		List<String> list = new ArrayList<String>();
		
		files.forEach((file)->{
			list.add(FileUpload.Uploader(file, folder));
		});
		
		return list; 
	}
}
