package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Bookmark;

public interface BookmarkService {

	List<Bookmark> list();

	void add(Bookmark item);

	Bookmark item(int bookmarkId);

	void update(Bookmark item);
	
	void delete(int bookmarkId);

	void delete(Bookmark item);

	List<Bookmark> list_date();

	List<Bookmark> list_name();

}
