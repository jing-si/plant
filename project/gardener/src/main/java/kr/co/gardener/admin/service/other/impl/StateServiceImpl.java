package kr.co.gardener.admin.service.other.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.other.StateDao;
import kr.co.gardener.admin.model.other.list.StateList;
import kr.co.gardener.admin.service.other.StateService;
import kr.co.gardener.util.Pager;

@Service
public class StateServiceImpl implements StateService{
	
	@Autowired
	StateDao dao;
	
	
	@Override
	public StateList list_pager(Pager pager) {
		StateList list = new StateList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		pager.setTotal(dao.total(pager));
		return list;
	}

	@Override
	public void insert_list(StateList list) {
		dao.insert_list(list.getList());
	}

	@Override
	public void delete_list(StateList list) {
		dao.delete_list(list.getList());		
	}

	@Override
	public void update_list(StateList list) {
		dao.update_list(list.getList());		
	}

	
}
