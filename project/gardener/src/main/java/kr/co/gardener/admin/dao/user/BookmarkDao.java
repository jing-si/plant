package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Bookmark;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

public interface BookmarkDao {

	List<Bookmark> list();

	void add(Bookmark item);

	Bookmark item(int bookmarkId);

	void update(Bookmark item);

	void delete(int bookmarkId);

	List<Bookmark> list_pager(Pager pager);

	float total(Pager pager);

	void insert_list(List<Bookmark> list);

	void delete_list(List<Bookmark> list);

	void update_list(List<Bookmark> list);
	
	List<Bookmark> list_date();

	List<Bookmark> list_name();

	void delete(Bookmark item);

	List<Bookmark> list_name(String userId);

	List<Bookmark> list_date(String userId);
	
	List<ComboItem> combo();

}
