package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Bookmark;

public interface BookmarkDao {

	List<Bookmark> list();

	void add(Bookmark item);

	Bookmark item(int bookmarkId);

	void update(Bookmark item);

	void delete(int bookmarkId);

	List<Bookmark> list_date();

	List<Bookmark> list_name();

	void delete(Bookmark item);

}
