package kr.co.gardener.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.InvenDao;
import kr.co.gardener.admin.model.Inven;
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



}
