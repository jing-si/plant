package kr.co.gardener.util;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;

public class JsoupCrawler {	
	
	String url = "https://bizno.net/article/";
	@RequestMapping("/")
	public Map<String, String> companySearch(String search) {
		Map<String,String> map = new HashMap<>();
		
		try {
			Document doc = Jsoup.connect(url+search)
					.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36")					
					.get();
			
			Elements th = doc.getElementsByTag("th");
			Elements td = doc.getElementsByTag("td");
			
			Elements h4 = doc.getElementsByTag("h4");
			
			map.put("사업자이름", h4.get(0).text());
			for(int A = 0 ; A < th.size() ; A++) {				
//				System.out.printf("%s : %s",th.get(A).text(),td.get(A).text());
					map.put(th.get(A).text(), td.get(A).text());				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return map;
	}
}
