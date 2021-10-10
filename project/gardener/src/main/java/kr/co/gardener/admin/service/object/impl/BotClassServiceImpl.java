package kr.co.gardener.admin.service.object.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.BotClassDao;
import kr.co.gardener.admin.model.object.list.BotClassList;
import kr.co.gardener.admin.service.object.BotClassService;
import kr.co.gardener.util.Pager;

@Service
public class BotClassServiceImpl implements BotClassService {

	@Autowired
	BotClassDao dao;
	
	@Override
	public BotClassList list_pager(Pager pager) {
		BotClassList item = new BotClassList();
		item.setPager(pager);
		item.setList(dao.list(pager));		
		pager.setTotal(dao.total(pager));
		item.paseComboList(dao.combo());
		return item;
	}

	@Override
	public void insert(BotClassList list) {
		dao.insert(list.getList());
	}

	@Override
	public void delete(BotClassList list) {
		dao.delete(list.getList());
	}

	@Override
	public void update(BotClassList list) {
		dao.update(list.getList());
	}

}
