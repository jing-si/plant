package kr.co.gardener.admin.service.forest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.ForestDao;
import kr.co.gardener.admin.model.forest.Forest;
import kr.co.gardener.admin.model.forest.list.ForestList;
import kr.co.gardener.admin.model.forest.list.PlantLevelList;
import kr.co.gardener.admin.service.forest.ForestService;
import kr.co.gardener.util.Pager;

@Service
public class ForestServiceImpl implements ForestService {

	@Autowired
	ForestDao dao;
	
	@Override
	public List<Forest> list() {
		return dao.list();
	}

	@Override
	public void add(Forest item) {
		dao.add(item);
	}

	@Override
	public Forest item(int forestId) {
		return dao.item(forestId);
	}

	@Override
	public void update(Forest item) {
		dao.update(item);
	}

	@Override
	public void delete(int forestId) {
		dao.delete(forestId);
	}

	@Override
	public ForestList list_pager(Pager pager) {
		ForestList list = new ForestList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		pager.setTotal(dao.total(pager));
		return list;
	}

	@Override
	public void insert_list(ForestList list) {
		dao.insert_list(list.getList());		
	}

	@Override
	public void delete_list(ForestList list) {
		dao.delete_list(list.getList());		
	}

	@Override
	public void update_list(ForestList list) {
		dao.update_list(list.getList());		
	}

}
