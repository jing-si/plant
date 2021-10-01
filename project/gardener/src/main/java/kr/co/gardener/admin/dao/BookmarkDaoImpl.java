package kr.co.gardener.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.model.Bookmark;
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

}
