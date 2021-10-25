package kr.co.gardener.admin.service.other.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.other.RandomMessageDao;
import kr.co.gardener.admin.model.other.list.RandomMessageList;
import kr.co.gardener.admin.model.other.list.StateList;
import kr.co.gardener.admin.service.other.RandomMessageService;
import kr.co.gardener.util.Pager;

@Service
public class RandomMessageServiceImpl implements RandomMessageService{

	@Autowired
	RandomMessageDao dao;
	
	@Override
	public RandomMessageList list_pager(Pager pager) {
		RandomMessageList list = new RandomMessageList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		pager.setTotal(dao.total(pager));
		return list;
	}

	@Override
	public void insert_list(RandomMessageList list) {
		dao.insert_list(list.getList());
	}

	@Override
	public void delete_list(RandomMessageList list) {
		dao.delete_list(list.getList());			
	}

	@Override
	public void update_list(RandomMessageList list) {
		dao.update_list(list.getList());			
	}

	@Override
	public String item(Integer stateId) {
		return dao.item(stateId);
	}
	
}
