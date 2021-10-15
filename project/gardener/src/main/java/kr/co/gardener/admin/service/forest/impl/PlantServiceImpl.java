package kr.co.gardener.admin.service.forest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.PlantDao;
import kr.co.gardener.admin.model.forest.Plant;
import kr.co.gardener.admin.model.forest.list.PlantList;
import kr.co.gardener.admin.model.user.list.InvenList;
import kr.co.gardener.admin.service.forest.PlantService;
import kr.co.gardener.util.Pager;
@Service
public class PlantServiceImpl implements PlantService {

	@Autowired
	PlantDao dao;
	
	@Override
	public List<Plant> list() {
		return dao.list();
	}

	@Override
	public void add(Plant item) {
		dao.add(item);
	}

	@Override
	public Plant item(int plantId) {
		return dao.item(plantId);
	}

	@Override
	public void update(Plant item) {
		dao.update(item);
	}

	@Override
	public void delete(int plantId) {
		dao.delete(plantId);
	}

	@Override
	public PlantList list_pager(Pager pager) {
		PlantList list = new PlantList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		pager.setTotal(dao.total(pager));
		list.paseComboList(dao.combo());
		return list;
	}

	@Override
	public void insert_list(PlantList list) {
		dao.insert_list(list.getList());
		
	}

	@Override
	public void delete_list(PlantList list) {
		dao.delete_list(list.getList());
	}

	@Override
	public void update_list(PlantList list) {
		dao.update_list(list.getList());
		
	}

}
