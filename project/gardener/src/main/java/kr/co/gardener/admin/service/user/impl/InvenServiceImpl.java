package kr.co.gardener.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.InvenDao;
import kr.co.gardener.admin.model.user.Inven;
import kr.co.gardener.admin.service.user.InvenService;
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
