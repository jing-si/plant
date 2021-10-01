package kr.co.gardener.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.HistoryDao;
import kr.co.gardener.admin.model.History;
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

}
