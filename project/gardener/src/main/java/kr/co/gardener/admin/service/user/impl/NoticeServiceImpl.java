package kr.co.gardener.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.NoticeDao;
import kr.co.gardener.admin.model.other.Notice;
import kr.co.gardener.admin.model.other.list.NoticeList;
import kr.co.gardener.admin.model.other.list.StateList;
import kr.co.gardener.admin.service.user.NoticeService;
import kr.co.gardener.util.Pager;
@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao dao;
	
	
	@Override
	public List<Notice> list() {
		return dao.list();
	}

	@Override
	public void add(Notice item) {
		dao.add(item);
	}

	@Override
	public Notice item(int noticeId) {
		return dao.item(noticeId);
	}

	@Override
	public void update(Notice item) {
		dao.update(item);
	}

	@Override
	public void delete(int noticeId) {
		dao.delete(noticeId);
	}

	@Override
	public NoticeList list_pager(Pager pager) {
		NoticeList list = new NoticeList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		pager.setTotal(dao.total(pager));
		return list;
	}

	@Override
	public void insert_list(NoticeList list) {
		dao.insert_list(list.getList());
	}

	@Override
	public void delete_list(NoticeList list) {
		dao.delete_list(list.getList());		
	}

	@Override
	public void update_list(NoticeList list) {
		dao.update_list(list.getList());		
	}

}
