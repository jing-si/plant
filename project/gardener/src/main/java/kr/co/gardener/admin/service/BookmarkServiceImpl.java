package kr.co.gardener.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.BookmarkDao;
import kr.co.gardener.admin.model.Bookmark;
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

}
