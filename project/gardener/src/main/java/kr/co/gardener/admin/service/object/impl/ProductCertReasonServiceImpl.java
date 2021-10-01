package kr.co.gardener.admin.service.object.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.ProductCertReasonDao;
import kr.co.gardener.admin.model.object.ProductCertReason;
import kr.co.gardener.admin.service.object.ProductCertReasonService;
import kr.co.gardener.util.Pager;

@Service
public class ProductCertReasonServiceImpl implements ProductCertReasonService{
	
	@Autowired
	ProductCertReasonDao dao;
	
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
	public void checkAdd(ProductCertReason r) {
		dao.checkAdd(r);
		
	}

}
