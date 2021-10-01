package kr.co.gardener.admin.service.object.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.CertReasonDao;
import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.admin.service.object.CertReasonService;

@Service
public class CertReasonServiceImpl implements CertReasonService{

	@Autowired
	CertReasonDao dao;

	@Override
	public List<CertReason> list() {
		return dao.list();
	}

	@Override
	public void add(CertReason item) {
		dao.add(item);
	}

	@Override
	public CertReason item(int certReasonId) {
		return dao.item(certReasonId);
	}

	@Override
	public void update(CertReason item) {
		dao.update(item);
	}

	@Override
	public void delete(int certReasonId) {
		dao.delete(certReasonId);
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
	
	 
	
}
