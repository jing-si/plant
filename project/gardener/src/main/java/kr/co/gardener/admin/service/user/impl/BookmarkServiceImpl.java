package kr.co.gardener.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.BookmarkDao;
import kr.co.gardener.admin.model.user.Bookmark;
import kr.co.gardener.admin.model.user.list.BookmarkList;
import kr.co.gardener.admin.model.user.list.UserList;
import kr.co.gardener.admin.service.user.BookmarkService;
import kr.co.gardener.util.Pager;
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
	public BookmarkList list_pager(Pager pager) {
		BookmarkList list = new BookmarkList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		pager.setTotal(dao.total(pager));
		return list;
	}

	@Override
	public void insert_list(BookmarkList list) {
		dao.insert_list(list.getList());
	}

	@Override
	public void delete_list(BookmarkList list) {
		dao.delete_list(list.getList());		
	}

	@Override
	public void update_list(BookmarkList list) {
		dao.update_list(list.getList());		
	}

}
