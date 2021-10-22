package kr.co.gardener.admin.service.object.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class ProductCertReasonServiceImpl implements ProductCertReasonService {

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
	@Transactional
	public void insert(ProductCertReasonList list) {
		dao.insert(list.getList());
	}

	@Override
	@Transactional
	public void delete(ProductCertReasonList list) {
		dao.delete(list.getList());
	}

	@Override
	@Transactional
	public void update(ProductCertReasonList list) {
		dao.update(list.getList());
	}

	@Override
	public <T extends Product> String autoInsertProductCertReason(List<T> list) {
		String result = null;
		List<ProductCertReason> listProductCertReason = new ArrayList<ProductCertReason>();
		for (T item : list) {
			String[] certReasonString = item.getProductCertReason().split(",");
			for (String str : certReasonString) {

				CertReason certReason = certReasonService.getCertReasonItem(str.trim());
				if (certReason == null) {
					CertReason newCertReason = new CertReason();
					newCertReason.setCertReasonName(str.trim());
					certReasonService.add(newCertReason);
					certReason = certReasonService.getCertReasonItem(str.trim());
					if (result == null)
						result = "";
					result += String.format("신규 제품 인증 사유가 추가 : %s \n", str.trim());
				}
				ProductCertReason productCertReason = new ProductCertReason();
				productCertReason.setCertReasonId(certReason.getCertReasonId());
				productCertReason.setProductId(item.getProductId());
				listProductCertReason.add(productCertReason);
			}
		}

		
			/*
			 * if (listProductCertReason.size() > 0)
			 * dao.update(listProductCertReason); 
			 * 
			 * 
			 * 제품 인증 사유는 데이터 양에 비해서 실효성이 없다고 판단 되어 입력을 중지 하였습니다.
			 * 제품 인증 사유는 Product의 ProductCertReason의 텍스트를 이용하여 분석되며 여전히 view에서는 정보가
			 * 제공됩니다. 단지 해당 테이블을 접어 놓았을 뿐입니다. 
			 * 필요하면 dao.update(listProductCertReason)의 주석을 풀면 됩니다.
			 * 
			 * 
			 */
			return result;
	}

}
