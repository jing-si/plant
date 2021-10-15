package kr.co.gardener.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.HistoryDao;
import kr.co.gardener.admin.model.user.History;
import kr.co.gardener.admin.model.user.list.HistoryList;
import kr.co.gardener.admin.service.user.HistoryService;
import kr.co.gardener.util.Pager;
@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	HistoryDao dao;
	
	@Override
	public List<History> list() {
		return dao.list();
	}

	@Override
	public void add(History item) {
		dao.add(item);

	}

	@Override
	public History item(int historyId) {
		return dao.item(historyId);
	}

	@Override
	public void update(History item) {
		dao.update(item);

	}

	@Override
	public void delete(int historyId) {
		dao.delete(historyId);	

	}

	@Override
	public HistoryList list_pager(Pager pager) {
		HistoryList list = new HistoryList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		pager.setTotal(dao.total(pager));
		list.paseComboList(dao.combo());
		return list;
	}

	@Override
	public void insert_list(HistoryList list) {
		dao.insert_list(list.getList());
	}

	@Override
	public void delete_list(HistoryList list) {
		dao.delete_list(list.getList());		
	}

	@Override
	public void update_list(HistoryList list) {
		dao.update_list(list.getList());		
	}

}
