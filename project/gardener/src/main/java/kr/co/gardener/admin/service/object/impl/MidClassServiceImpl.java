package kr.co.gardener.admin.service.object.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.MidClassDao;
import kr.co.gardener.admin.model.object.list.MidClassList;
import kr.co.gardener.admin.service.object.MidClassService;
import kr.co.gardener.util.Pager;
@Service
public class MidClassServiceImpl implements MidClassService {

	@Autowired
	MidClassDao dao;
	
	@Override
	public MidClassList list_pager(Pager pager) {
		MidClassList item = new MidClassList();
		item.setPager(pager);
		item.setList(dao.list(pager));		
		pager.setTotal(dao.total(pager));
		item.paseComboList(dao.combo());
		return item;
	}

	@Override
	public void insert(MidClassList list) {
		dao.insert(list.getList());
	}

	@Override
	public void delete(MidClassList list) {
		dao.delete(list.getList());
	}

	@Override
	public void update(MidClassList list) {
		dao.update(list.getList());
	}

}
