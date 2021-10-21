package kr.co.gardener.admin.service.object.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.CertReasonDao;
import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.list.CertReasonList;
import kr.co.gardener.admin.service.object.CertReasonService;
import kr.co.gardener.util.Pager;

@Service
public class CertReasonServiceImpl implements CertReasonService{

	@Autowired
	CertReasonDao dao;
	
	HashMap<String, CertReason> certReasonMap;
	
	@Override
	public List<CertReason> list() {
		return dao.list();
	}

	@Override
	public void add(CertReason item) {
		dao.add(item);
		loadCertInfo();	
	}

	@Override
	public CertReason item(int certReasonId) {
		return dao.item(certReasonId);
	}

	@Override
	public void update(CertReason item) {
		dao.update(item);
		loadCertInfo();	
	}

	@Override
	public void delete(int certReasonId) {
		dao.delete(certReasonId);
		loadCertInfo();	
	}

	@Override
	public Map<String, Integer> listMap() {
		List<CertReason> list = dao.list();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(CertReason item : list) {
			map.put(item.getCertReasonName(), item.getCertReasonId());
		}
		
		return map;	
	}

	@Override
	public CertReasonList list(Pager pager) {
		CertReasonList list = new CertReasonList();
		pager.setTotal(dao.total(pager));
		list.setPager(pager);
		list.setList(dao.list(pager));
		return list;
	}

	@Override
	public void insert(CertReasonList list) {
		dao.insert(list.getList());
		loadCertInfo();	
		
	}

	@Override
	public void delete(CertReasonList list) {
		dao.delete(list.getList());
		loadCertInfo();	
	}

	@Override
	public void update(CertReasonList list) {
		dao.update(list.getList());
		loadCertInfo();	
	}
	
	@Override
	public CertReason getCertReasonItem(String value) {
		if(certReasonMap == null) {			
			loadCertInfo();			
		}
		
		return certReasonMap.get(value);
	}
	
	private void loadCertInfo() {
		System.out.println("certInfo 생성");
		certReasonMap = new HashMap<String, CertReason>();
		
		List<CertReason> csList = dao.list();
		
		for(CertReason item : csList) {
			certReasonMap.put(item.getCertReasonName(), item);
			certReasonMap.put(String.valueOf(item.getCertReasonId()), item);
		}
	}

	@Override
	public void fillProduct(Product item) {
		if(certReasonMap == null) {			
			loadCertInfo();			
		}
		String[] strCertReason = item.getProductCertReason().split(",");
		
		List<CertReason> list = new ArrayList<CertReason>();
		for(String str : strCertReason) {
			CertReason certReason = certReasonMap.get(str);
			if(certReason != null) {
				list.add(certReason);
			}
		}
		
		
		item.setCertReasons(list);
	}
	
}
