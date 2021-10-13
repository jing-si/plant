package kr.co.gardener.admin.service.object.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.CertReasonDao;
import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.admin.model.object.list.CertReasonList;
import kr.co.gardener.admin.service.object.CertReasonService;
import kr.co.gardener.util.Pager;

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
		
	}

	@Override
	public void delete(CertReasonList list) {
		dao.delete(list.getList());
	}

	@Override
	public void update(CertReasonList list) {
		dao.update(list.getList());
	}
	
	 
	
}
