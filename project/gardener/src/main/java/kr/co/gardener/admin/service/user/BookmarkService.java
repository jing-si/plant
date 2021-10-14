package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Bookmark;
import kr.co.gardener.admin.model.user.list.BookmarkList;
import kr.co.gardener.util.Pager;

public interface BookmarkService {

	List<Bookmark> list();

	void add(Bookmark item);

	Bookmark item(int bookmarkId);

	void update(Bookmark item);
	
	void delete(int bookmarkId);

	BookmarkList list_pager(Pager pager);

	void insert_list(BookmarkList list);

	void delete_list(BookmarkList list);

	void update_list(BookmarkList list);
	
	void delete(Bookmark item);

	List<Bookmark> list_date();

	List<Bookmark> list_name();

}
