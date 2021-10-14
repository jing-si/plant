package kr.co.gardener.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.BookmarkDao;
import kr.co.gardener.admin.model.user.Bookmark;
import kr.co.gardener.admin.service.user.BookmarkService;
@Service
public class BookmarkServiceImpl implements BookmarkService {

	@Autowired
	BookmarkDao dao;
	
	@Override
	public List<Bookmark> list() {
		return dao.list();
	}

	@Override
	public void add(Bookmark item) {
		dao.add(item);
	}

	@Override
	public Bookmark item(int bookmarkId) {
		return dao.item(bookmarkId);
	}

	@Override
	public void update(Bookmark item) {
		dao.update(item);
	}

	@Override
	public void delete(int bookmarkId) {
		dao.delete(bookmarkId);
	}

	@Override
	public List<Bookmark> list_date() {
		return dao.list_date();
	}

	@Override
	public List<Bookmark> list_name() {
		return dao.list_name();
	}

	@Override
	public void delete(Bookmark item) {
		dao.delete(item);
	}

}
