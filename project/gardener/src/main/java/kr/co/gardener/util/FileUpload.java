package kr.co.gardener.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
	public static Properties makeProp() {
		//config 파일 찾기
				File config = new File("C:\\key\\config.properties");
				
				//config 파일을 읽기 위한 파일리더		
				BufferedReader fr = null;
				
				//properties 생성
				Properties pro = new Properties();
				
				try {
					fr = new BufferedReader(new InputStreamReader(new FileInputStream(config),"UTF8"));
				} catch (Exception e) {
					System.out.println("config.properties 파일을 찾을 수가 없습니다.");
				}
				
				
				
				try {
					//읽어온 파일로 properties 로드
					pro.load(fr);
				} catch (IOException e1) {
					System.out.println("config.properties 파일이 잘못되어 있습니다.");
				}	
		
		return pro;
	}
	
	public static String Uploader(MultipartFile uploadFile,String path) {
		MultipartFile file = uploadFile;
		Properties pro = makeProp();
		
		//파일 저장을 위한 경로 할당
		String javaFilePath = pro.getProperty("java.fileUpload.path")+path.replaceAll("/", "\\\\");
		String srcFilePath = pro.getProperty("spring.fileUpload.src")+path.replaceAll("\\\\", "/");
		String fileName = null;
		System.out.println("javaFilePath : " + javaFilePath);
		System.out.println("srcFilePath : " + srcFilePath);
		
		if (file != null && !file.isEmpty()) {
			fileName = file.getOriginalFilename();		
			
			try {
				file.transferTo(new File(javaFilePath +"\\"+ fileName));	
				srcFilePath +="/"+ fileName;
			} catch (Exception e) {
				System.out.println("오류발생");
				return null; 
			}
		}
		
		return srcFilePath;
	}

}
