package kr.co.gardener.admin.service.object.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.gardener.admin.dao.object.CertDao;
import kr.co.gardener.admin.dao.object.CertReasonDao;
import kr.co.gardener.admin.dao.object.DataManagerDao;
import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.ProductCertReason;
import kr.co.gardener.admin.service.object.CertReasonService;
import kr.co.gardener.admin.service.object.CertService;
import kr.co.gardener.admin.service.object.DataManagerService;
import kr.co.gardener.admin.service.object.ProductCertReasonService;
import kr.co.gardener.admin.service.object.ProductService;

@Service
public class DataManagerServiceImpl implements DataManagerService {

	@Autowired
	DataManagerDao dao;
	
	@Autowired
	CertReasonService reasonService;
	
	@Autowired
	CertService certService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductCertReasonService productCertReasonService;

	@Override
	public List<Company> list(int start, int end) {
		String str = dao.list(start, end);
		List<Company> list = paser(str,Company.class,"data");
		return list;
	}



	@Override
	public List<Product> productList(long companyId) {
		String str = dao.productList(companyId);
		List<Product> list = paser(str,Product.class,"data");	
		return list;		
	}

	private <T> List<T> paser(String str,Class<T> classType,String value){
		List<T> list = new ArrayList<>();
		Thread th = new Thread(new Runnable() {		
			@Override
			public void run() {
				try {

					JsonParser jsonParser = new JsonParser();
					JsonObject jo = (JsonObject) jsonParser.parse(str);
					JsonArray jsonArr = jo.getAsJsonArray(value);
					Gson gson = new Gson();
					jsonArr.forEach(data -> {						
						T item = gson.fromJson(data,classType);
						list.add(item);
					});
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		th.run();
		
		return list;		
	}

	@Override
	public List<Product> eProductList(long companyId) {
		String str = dao.eProductList(companyId);
		List<Product> list = paser(str,Product.class,"dataEpdp");	
		return list;
	}



	@Override
	public List<Product> productList(int start, int end) {
		String str = dao.productList(start, end);
		List<Product> list = paser(str,Product.class,"data");
		return list;
		
	}



	@Override
	public void bulkUpdate(List<Product> list) {
		//이건 일차원적인 해결 방법 뿐이 없는것일까?		
		Map<String,Integer> reasonMap = reasonService.listMap();
		Map<String,Integer> certMap = certService.listMap();
		System.out.println("사이즈를 사이즈를 사이즈는 왜 왜왜 왜왜"+list.size() );
		for(Product item : list) {
			System.out.println(item.getProductName());
			item.setCertId(certMap.get(item.getCertName()));
			productService.add(item);
			String[] str = item.getProdInrs().split(",");
			
			
			for(String s : str) {
				ProductCertReason r = new ProductCertReason();
				r.setCertReasonId(reasonMap.get(s));
				r.setProductId(item.getProductId());
				productCertReasonService.checkAdd(r);
			}
			
		}
	}

}
