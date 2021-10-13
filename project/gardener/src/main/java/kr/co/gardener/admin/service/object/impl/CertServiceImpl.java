package kr.co.gardener.admin.service.object.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.CertDao;
import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.list.CertList;
import kr.co.gardener.admin.service.object.CertService;
import kr.co.gardener.util.Pager;

@Service
public class CertServiceImpl implements CertService{

	@Autowired
	CertDao dao;
	
	HashMap<String, Cert> certInfo;
	
	@Override
	public List<Cert> list() {
		return dao.list();
	}

	@Override
	public Cert item(int certId) {
		return dao.item(certId);
	}

	@Override
	public void update(Cert item) {
		dao.update(item);
	}

	@Override
	public void delete(int certId) {
		dao.delete(certId);
	}

	@Override
	public void add(Cert item) {
		dao.add(item);
	}

	
	@Override
	public CertList list(Pager pager) {
		CertList list = new CertList();
		pager.setTotal(dao.total(pager));
		list.setPager(pager);
		list.setList(dao.list(pager));
		return list;
	}

	@Override
	public void insert(CertList list) {
		dao.insert(list.getList());
	}

	@Override
	public void delete(CertList list) {
		dao.delete(list.getList());
	}

	@Override
	public void update(CertList list) {
		dao.update(list.getList());
	}

	@Override
	public Cert getCertInfo(String value) {
		if(certInfo == null) {
			
			loadCertInfo();			
		}
		
		Cert item = certInfo.get(value);
		
		return item;
	}
	
	private void loadCertInfo() {
		System.out.println("certInfo 생성");
		certInfo = new HashMap<String, Cert>();
		
		List<Cert> csList = dao.list();
		
		for(Cert item : csList) {
			certInfo.put(item.getCertName(), item);
			certInfo.put(String.valueOf(item.getCertId()), item);
		}
	}
}
