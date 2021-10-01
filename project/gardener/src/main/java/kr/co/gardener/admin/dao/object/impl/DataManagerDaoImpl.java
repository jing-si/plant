package kr.co.gardener.admin.dao.object.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.DataManagerDao;

@Repository
public class DataManagerDaoImpl implements DataManagerDao {
	private URI companyUrl;
	private URI productUrl;
	private String certKeyc;
	
	public DataManagerDaoImpl() {
		try {
			companyUrl = new URI("http://data.greenproduct.go.kr/open-api/rest/CertifyVenderInformationInquiryService.do");
			productUrl = new URI("http://data.greenproduct.go.kr/open-api/rest/GreenProductInformationInquiryService.do");
			certKeyc = 	"kW2He3CdhxZqoqV4Xca2ZHfw0BrO7YV/Eps1RzY5pd0XPwc7D5443vHWGHwJ1kCViv2Q5kebY14nqh/7X3Q==";	
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String list(int start, int end) {
		URI connUrl=null;
		try {
			 connUrl = new URIBuilder(companyUrl)
					.addParameter("certKeyc",certKeyc)
					.addParameter("vendStdt", String.valueOf(start)).addParameter("vendEndt", String.valueOf(end)).build();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}


		return context(connUrl);
		
	}
	
	private String context(URI connUrl) {		

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpResponse response = null;

		try {
			response = httpClient.execute(new HttpGet(connUrl));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// post 요청은 HttpPost()를 사용하면 된다.

		HttpEntity entity = response.getEntity();
		String content = "";

		try {
			content = EntityUtils.toString(entity);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
		
	}
	
	@Override
	public String productList(long companyId) {
		
		URI connUrl=null;
		try {
			 connUrl = new URIBuilder(productUrl)
					.addParameter("certKeyc",certKeyc)
					.addParameter("prodVcod", String.valueOf(companyId))
					.build();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		return context(connUrl);
	}

	@Override
	public String eProductList(long companyId) {
		URI connUrl=null;
		try {
			 connUrl = new URIBuilder(productUrl)
					.addParameter("certKeyc",certKeyc)
					.addParameter("epdpVcod", String.valueOf(companyId))
					.build();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		return context(connUrl);
	}

	@Override
	public String productList(int start, int end) {
		URI connUrl=null;
		try {
			 connUrl = new URIBuilder(productUrl)
					.addParameter("certKeyc",certKeyc)
					.addParameter("prodStdt", String.valueOf(start)).addParameter("prodEndt", String.valueOf(end)).build();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}


		return context(connUrl);
	}
	
	@Override
	public String eproductList(int start, int end) {
		URI connUrl=null;
		try {
			 connUrl = new URIBuilder(companyUrl)
					.addParameter("certKeyc",certKeyc)
					.addParameter("vendStdt", String.valueOf(start)).addParameter("vendEndt", String.valueOf(end)).build();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}


		return context(connUrl);
	}
	
	

}
