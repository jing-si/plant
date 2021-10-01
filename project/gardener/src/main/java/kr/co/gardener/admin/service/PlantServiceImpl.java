package kr.co.gardener.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.PlantDao;
import kr.co.gardener.admin.model.Plant;
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

}
