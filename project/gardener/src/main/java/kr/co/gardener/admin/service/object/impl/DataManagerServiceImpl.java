package kr.co.gardener.admin.service.object.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.gardener.admin.dao.object.DataManagerDao;
import kr.co.gardener.admin.model.object.ApiProduct;
import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.ProductCertReason;
import kr.co.gardener.admin.model.object.list.ApiProductList;
import kr.co.gardener.admin.service.object.BotClassService;
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
	
	@Autowired
	BotClassService botClassService;

	@Override	
	public List<Company> list(int start, int end) {
		String str = dao.list(start, end);
		List<Company> list = paser(str, Company.class, "data");
		return list;
	}

	@Override
	public List<ApiProduct> productList(long companyId) {
		String str = dao.productList(companyId);
		List<ApiProduct> list = paser(str, ApiProduct.class, "data");
		return list;
	}

	private <T> List<T> paser(String str, Class<T> classType, String value) {
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
						T item = gson.fromJson(data, classType);
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
	public List<ApiProduct> eProductList(long companyId) {
		String str = dao.eProductList(companyId);
		List<ApiProduct> list = paser(str, ApiProduct.class, "dataEpdp");
		return list;
	}

	@Override
	public List<ApiProduct> productList(int start, int end) {
		String str = dao.productList(start, end);
		List<ApiProduct> list = paser(str, ApiProduct.class, "data");
		return list;

	}

	@Override
	@Transactional
	public String UploadApiProduct(ApiProductList apiProductList) {
		
		List<ApiProduct> list = apiProductList.getList();
		
		for (ApiProduct item : list) {
			item.setCert(certService.getCertInfo(item.getCertName()));
			int elId = botClassService.searchBotClass(item.getProductInfo());
			item.setElId(elId);
			if(elId == 0) item.setProdElcd("0");
		}
		
		dao.UploadApiProduct(list);
		String msg = productCertReasonService.autoInsertProductCertReason(list);	
		return msg;
	}

}
