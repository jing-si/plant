package kr.co.gardener.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.InvenDao;
import kr.co.gardener.admin.model.user.Inven;
import kr.co.gardener.admin.model.user.list.InvenList;
import kr.co.gardener.admin.model.user.list.LocationList;
import kr.co.gardener.admin.service.user.InvenService;
import kr.co.gardener.util.Pager;
@Service
public class InvenServiceImpl implements InvenService {

	@Autowired
	InvenDao dao;
	
	@Override
	public List<Inven> list() {
		return dao.list();
	}

	@Override
	public void add(Inven item) {
		dao.add(item);
	}

	@Override
	public Inven item(int userId, int plantId) {
		return dao.item(userId, plantId);
	}

	@Override
	public void update(Inven item) {
		dao.update(item);
	}

	@Override
	public void delete(int userId, int plantId) {
		dao.delete(userId,plantId);
		
	}

	@Override
	public List<Inven> list(String userId) {
		return dao.list(userId);
	}

	@Override
	public InvenList list_pager(Pager pager) {
		InvenList list = new InvenList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		pager.setTotal(dao.total(pager));
		list.paseComboList(dao.combo());
		return list;
	}

	@Override
	public void insert_list(InvenList list) {
		dao.insert_list(list.getList());
	}

	@Override
	public void delete_list(InvenList list) {
		dao.delete_list(list.getList());		
	}

	@Override
	public void update_list(InvenList list) {
		dao.update_list(list.getList());		
	}

	
	@Override
	public int countUp(Inven inven) {		
		return dao.countUp(inven);
	}

	@Override
	public int countDown(Inven inven) {		
		return dao.countDown(inven);
	}



}
