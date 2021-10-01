package kr.co.gardener.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.ForestDao;
import kr.co.gardener.admin.model.Forest;

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

}
