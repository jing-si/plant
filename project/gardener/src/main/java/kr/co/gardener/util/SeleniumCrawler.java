package kr.co.gardener.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumCrawler {
	private WebDriver driver;
	private List<WebElement> element;
	private String url;
	
	public SeleniumCrawler() {
		Properties pro = FileUpload.makeProp();
		String driverPath = pro.getProperty("java.chromeDriver.path");
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("headless");
		
        
		driver = new ChromeDriver(options);
		
		
		
		
	}
	
	public List<String> imageSearch(String search) {
		url = "https://www.google.co.kr/imghp?hl=ko&tab=ri&authuser=0&ogbl";
		List<String> list = new ArrayList<>();
		try {
			
			driver.get(url);
			WebElement elem = driver.findElement(By.name("q"));
				elem.sendKeys(search);
				elem.submit();				
			
			
			// img.rg_i 태그 가져오기.
			element = driver.findElements(By.cssSelector("img.rg_i"));		
			
			
			for(WebElement item : element) {
				list.add(item.getAttribute("src"));				
			}
			return list;
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close(); // 5. 브라우저 종료
		}
		
		return null;
	}
	
	

}
