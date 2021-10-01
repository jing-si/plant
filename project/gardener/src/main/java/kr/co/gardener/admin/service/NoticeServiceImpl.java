package kr.co.gardener.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.NoticeDao;
import kr.co.gardener.admin.model.Notice;
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

}
