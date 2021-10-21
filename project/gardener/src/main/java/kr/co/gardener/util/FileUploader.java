package kr.co.gardener.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUploader {

	public static Properties makeProp() {
		// config 파일 찾기
		File config = new File("C:\\key\\config.properties");

		// config 파일을 읽기 위한 파일리더
		BufferedReader fr = null;

		// properties 생성
		Properties pro = new Properties();

		try {
			fr = new BufferedReader(new InputStreamReader(new FileInputStream(config), "UTF8"));
		} catch (Exception e) {
			System.out.println("config.properties 파일을 찾을 수가 없습니다.");
		}

		try {
			// 읽어온 파일로 properties 로드
			pro.load(fr);
		} catch (IOException e1) {
			System.out.println("config.properties 파일이 잘못되어 있습니다.");
		}

		return pro;
	}

	public static String Uploader(MultipartFile uploadFile, String path, String name) {

		MultipartFile file = uploadFile;
		UUID uuid = UUID.randomUUID();
		Properties pro = makeProp();

		// 파일 저장을 위한 경로 할당
		String javaFilePath = pro.getProperty("java.fileUpload.path") + path.replaceAll("/", "\\\\");
		String srcFilePath = pro.getProperty("spring.fileUpload.src") + path.replaceAll("\\\\", "/");
		String fileName = name;
		
		
		System.out.println("javaFilePath : " + javaFilePath);
		System.out.println("srcFilePath : " + srcFilePath);
		System.out.println(pro.getProperty("java.fileUpload.path"));
		
		
		//폴더가 없으면 생성
		File folder = new File(javaFilePath);

		if (!folder.exists()) {

			if (folder.mkdirs())
				System.out.println(javaFilePath + " : 폴더를 생성 성공");
			else
				System.out.println("폴더를 생성 실패");

		}
		
		
		
		//파일복사 해서 넣기
		
		if (file != null && !file.isEmpty()) {
			if(fileName == null)
				fileName = uuid.toString() +"_"+ file.getOriginalFilename();
			
			//파일 중복 체크

			try {
				file.transferTo(new File(javaFilePath +"\\"+ fileName));
				srcFilePath += "/" + fileName;
			} catch (Exception e) {
				System.out.println("오류발생");
				return null;
			}
		}

		return srcFilePath;
	}
	
	

}
