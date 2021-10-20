package kr.co.gardener.admin.service.forest.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.PlantLevelDao;
import kr.co.gardener.admin.model.forest.PlantLevel;
import kr.co.gardener.admin.model.forest.list.PlantLevelList;
import kr.co.gardener.admin.model.user.list.BookmarkList;
import kr.co.gardener.admin.service.forest.PlantLevelService;
import kr.co.gardener.util.Pager;
@Service
public class PlantLevelServiceImpl implements PlantLevelService {

	@Autowired
	PlantLevelDao dao;
	
	@Override
	public List<PlantLevel> list() {
		return dao.list();
	}

	@Override
	public void add(PlantLevel item) {
		dao.add(item);
	}

	@Override
	public PlantLevel item(int plantLevelId) {
		return dao.item(plantLevelId);
	}

	@Override
	public void update(PlantLevel item) {
		dao.update(item);
	}

	@Override
	public void delete(int plantLevelId) {
		dao.delete(plantLevelId);
	}

	@Override
	public PlantLevelList list_pager(Pager pager) {
		PlantLevelList list = new PlantLevelList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		pager.setTotal(dao.total(pager));
		list.paseComboList(dao.combo());
		return list;
	}

	@Override
	public void insert_list(PlantLevelList list) {
		dao.insert_list(list.getList());
		
	}

	@Override
	public void delete_list(PlantLevelList list) {
		dao.delete_list(list.getList());
		
	}

	@Override
	public void update_list(PlantLevelList list) {
		dao.update_list(list.getList());
		
	}

	@Override
	public List<PlantLevel> random() {
		List<PlantLevel> list = dao.maturePlant();
		List<PlantLevel> item = new ArrayList<PlantLevel>();		
		Random r = new Random();
		for(int a = 0 ; a< 3 ;a++)
			item.add(list.get(r.nextInt(list.size()-1)));
		
		return item;
	}

}
