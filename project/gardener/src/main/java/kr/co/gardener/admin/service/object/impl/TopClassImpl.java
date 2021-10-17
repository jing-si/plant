package kr.co.gardener.admin.service.object.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.TopClassDao;
import kr.co.gardener.admin.model.object.list.TopClassList;
import kr.co.gardener.admin.service.object.TopClassService;
import kr.co.gardener.main.vo.TopClassVO;
import kr.co.gardener.util.Pager;

@Service
public class TopClassImpl implements TopClassService {

	@Autowired
	TopClassDao dao;
	
	@Override
	public void insert(TopClassList list) {
		dao.insert(list.getList());
	}

	@Override
	public TopClassList list_pager(Pager pager) {
		TopClassList item = new TopClassList();
		item.setPager(pager);
		item.setList(dao.list(pager));
		pager.setTotal(dao.total(pager));
		
		return item;
	}

	@Override
	public void delete(TopClassList list) {
		dao.delete(list.getList());
	}

	@Override
	public void update(TopClassList list) {
		dao.update(list.getList());
	}

	@Override
	public List<TopClassVO> includMidClassList() {
		return dao.includMidClassList();
	}

}
