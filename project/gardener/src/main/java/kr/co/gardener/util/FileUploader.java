package kr.co.gardener.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.web.multipart.MultipartFile;

public class FileUploader {
	

	public static Properties makeProp() {
		// config �뙆�씪 李얘린
		File config = new File("C:\\key\\config.properties");
		//File config = new File("gakkum2021/tomcat/webapps/key/config.properties");

		// config �뙆�씪�쓣 �씫湲� �쐞�븳 �뙆�씪由щ뜑
		BufferedReader fr = null;

		// properties �깮�꽦
		Properties pro = new Properties();

		try {
			fr = new BufferedReader(new InputStreamReader(new FileInputStream(config), "UTF8"));
		} catch (Exception e) {
			System.out.println("config.properties �뙆�씪�쓣 李얠쓣 �닔媛� �뾾�뒿�땲�떎.");
		}

		try {
			// �씫�뼱�삩 �뙆�씪濡� properties 濡쒕뱶
			pro.load(fr);
		} catch (IOException e1) {
			System.out.println("config.properties �뙆�씪�씠 �옒紐삳릺�뼱 �엳�뒿�땲�떎.");
		}

		return pro;
	}
	
	public static String Uploader(MultipartFile uploadFile, String path, String name) {
		Properties pro = makeProp();
		MultipartFile file = uploadFile;
		UUID uuid = UUID.randomUUID();
		

		// �뙆�씪 ���옣�쓣 �쐞�븳 寃쎈줈 �븷�떦
		String javaFilePath = pro.getProperty("java.fileUpload.path") + path.replaceAll("/", "\\\\");
		String srcFilePath = pro.getProperty("spring.fileUpload.src") + path.replaceAll("\\\\", "/");
		String fileName = name;
		
		
		System.out.println("javaFilePath : " + javaFilePath);
		System.out.println("srcFilePath : " + srcFilePath);
		System.out.println(pro.getProperty("java.fileUpload.path"));
		
		
		//�뤃�뜑媛� �뾾�쑝硫� �깮�꽦
		File folder = new File(javaFilePath);

		if (!folder.exists()) {

			if (folder.mkdirs())
				System.out.println(javaFilePath + " : �뤃�뜑瑜� �깮�꽦 �꽦怨�");
			else
				System.out.println("�뤃�뜑瑜� �깮�꽦 �떎�뙣");

		}
		
		
		
		//�뙆�씪蹂듭궗 �빐�꽌 �꽔湲�
		
		if (file != null && !file.isEmpty()) {
			if(fileName == null)
				fileName = uuid.toString() +"_"+ file.getOriginalFilename();
			
			//�뙆�씪 以묐났 泥댄겕

			try {
				file.transferTo(new File(javaFilePath +"\\"+ fileName));
				srcFilePath += "/" + fileName;
			} catch (Exception e) {
				System.out.println("�삤瑜섎컻�깮");
				return null;
			}
		}

		return srcFilePath;
	}
	
	
	
	public static String WebImageUploader(String fileName,String src) {
		Properties pro = makeProp();
		

		// �뙆�씪 ���옣�쓣 �쐞�븳 寃쎈줈 �븷�떦
		String javaFilePath = pro.getProperty("java.fileUpload.path") + "product\\" + fileName+".png";
		String srcFilePath = pro.getProperty("spring.fileUpload.src") + "product/" + fileName+".png";
		
		try {
		      URL url = new URL(src);
		     
		      BufferedImage image = ImageIO.read(url);
		      File file = new File(javaFilePath);
		      ImageIO.write(image, "png", file);
		      
		    } catch (IOException e) {
		      e.printStackTrace();
		      srcFilePath = "error";
		    }

		
		return srcFilePath;
	}

}
