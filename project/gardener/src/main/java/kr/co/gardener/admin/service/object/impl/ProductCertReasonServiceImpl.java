package kr.co.gardener.admin.service.object.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.ProductCertReasonDao;
import kr.co.gardener.admin.model.object.ProductCertReason;
import kr.co.gardener.admin.model.object.list.ProductCertReasonList;
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
		dao.insert(list);
	}

	@Override
	public void delete(ProductCertReasonList list) {
		dao.delete(list);
	}

	@Override
	public void update(ProductCertReasonList list) {
		dao.update(list);
	}

}
