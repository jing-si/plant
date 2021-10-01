package kr.co.gardener.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.PlantLevelDao;
import kr.co.gardener.admin.model.PlantLevel;
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

}
