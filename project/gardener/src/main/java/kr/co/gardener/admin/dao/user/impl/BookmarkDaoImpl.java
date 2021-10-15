package kr.co.gardener.admin.dao.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.user.BookmarkDao;
import kr.co.gardener.admin.model.user.Bookmark;
import kr.co.gardener.util.Pager;
@Repository
public class BookmarkDaoImpl implements BookmarkDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Bookmark> list() {
		return sql.selectList("bookmark.list");
	}

	@Override
	public void add(Bookmark item) {
		sql.insert("bookmark.add", item);
	}

	@Override
	public Bookmark item(int bookmarkId) {
		return sql.selectOne("bookmark.item", bookmarkId);
	}

	@Override
	public void update(Bookmark item) {
		sql.update("bookmark.update", item);
	}

	@Override
	public void delete(int bookmarkId) {
		sql.delete("bookmark.delete", bookmarkId);
	}

	@Override
	public List<Bookmark> list_pager(Pager pager) {
		return sql.selectList("bookmark.list_parger", pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("bookmark.total",pager);
	}

	@Override
	public void insert_list(List<Bookmark> list) {
		sql.insert("bookmark.insert_list", list);
	}

	@Override
	public void delete_list(List<Bookmark> list) {
		sql.insert("bookmark.delete_list", list);		
	}

	@Override
	public void update_list(List<Bookmark> list) {
		sql.insert("bookmark.update_list", list);		
	}
	@Override
	public List<Bookmark> list_date() {
		return sql.selectList("bookmark.list_date");
	}

	@Override
	public List<Bookmark> list_name() {
		return sql.selectList("bookmark.list_name");
	}

	@Override
	public void delete(Bookmark item) {
		sql.delete("bookmark.delete2", item);
	}

	@Override
	public List<Bookmark> list_name(String userId) {
		return sql.selectList("bookmark.list_name", userId);
	}

	@Override
	public List<Bookmark> list_date(String userId) {
		return sql.selectList("bookmark.list_date", userId);
	}

}
