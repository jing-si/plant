package kr.co.gardener.admin.service.object.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.ProductCertReasonDao;
import kr.co.gardener.admin.model.object.ApiProduct;
import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.ProductCertReason;
import kr.co.gardener.admin.model.object.list.ProductCertReasonList;
import kr.co.gardener.admin.service.object.CertReasonService;
import kr.co.gardener.admin.service.object.ProductCertReasonService;
import kr.co.gardener.util.Pager;

@Service
public class ProductCertReasonServiceImpl implements ProductCertReasonService{
	
	@Autowired
	ProductCertReasonDao dao;
	
	@Autowired
	CertReasonService certReasonService;
	
	@Override
	public void list(Pager pager) {
		dao.list(pager);
	}

	@Override
	public void add(ProductCertReason item) {
		dao.add(item);
	}

	@Override
	public void item(int productCertReasonId) {
		dao.item(productCertReasonId);
	}

	@Override
	public void update(ProductCertReason item) {
		dao.update(item);
	}

	@Override
	public void delete(int productCertReasonId) {
		dao.delete(productCertReasonId);
	}


	@Override
	public ProductCertReasonList list_pager(Pager pager) {
		ProductCertReasonList list = new ProductCertReasonList();
		pager.setTotal(dao.total(pager));
		list.setPager(pager);
		list.setList(dao.list_pager(pager));
		list.paseComboList(dao.combo());
		return list;
	}

	@Override
	public void insert(ProductCertReasonList list) {
		dao.insert(list.getList());
	}

	@Override
	public void delete(ProductCertReasonList list) {
		dao.delete(list.getList());
	}

	@Override
	public void update(ProductCertReasonList list) {
		dao.update(list.getList());
	}
	
	@Override
	public <T extends Product> String autoInsertProductCertReason(List<T> list) {
		String result = null;
		List<ProductCertReason>  listProductCertReason = new ArrayList<ProductCertReason>();
		for(T item : list) {			
			String[] certReasonString = item.getProductCertReason().split(",");
			for(String str : certReasonString) {
								
				CertReason certReason = certReasonService.getCertReasonItem(str.trim());
				if(certReason == null) {
					CertReason newCertReason = new CertReason();
					newCertReason.setCertReasonName(str.trim());
					certReasonService.add(newCertReason);
					certReason = certReasonService.getCertReasonItem(str.trim());
					if(result == null)
						result = "";
					result += String.format("신규 제품 인증 사유가 추가 : %s \n", str.trim());
				}
				ProductCertReason productCertReason = new ProductCertReason();
				productCertReason.setCertReasonId(certReason.getCertReasonId());
				productCertReason.setProductId(item.getProductId());
				listProductCertReason.add(productCertReason);
			}
		}
		
		if(listProductCertReason.size() > 0)
			dao.update(listProductCertReason);
		
		return result;
	}

	
	
	
	
	
	
	
}
