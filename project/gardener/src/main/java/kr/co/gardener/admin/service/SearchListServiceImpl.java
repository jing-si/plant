package kr.co.gardener.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.SearchListDao;
import kr.co.gardener.admin.model.SearchList;
@Service
public class SearchListServiceImpl implements SearchListService {

	@Autowired
	SearchListDao dao;
	
	@Override
	public List<SearchList> list() {
		return dao.list();
	}

	@Override
	public void add(SearchList item) {
		dao.add(item);
	}

	@Override
	public SearchList item(int searchId) {
		return dao.item(searchId);
	}

	@Override
	public void update(SearchList item) {
		dao.update(item);
	}

	@Override
	public void delete(int searchId) {
		dao.delete(searchId);
	}

}
