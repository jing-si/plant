package kr.co.gardener.admin.dao;

import java.util.List;

import kr.co.gardener.admin.model.Bookmark;

public interface BookmarkDao {

	List<Bookmark> list();

	void add(Bookmark item);

	Bookmark item(int bookmarkId);

	void update(Bookmark item);

	void delete(int bookmarkId);

}
