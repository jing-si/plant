package kr.co.gardener.admin.service;

import java.util.List;

import kr.co.gardener.admin.model.Bookmark;

public interface BookmarkService {

	List<Bookmark> list();

	void add(Bookmark item);

	Bookmark item(int bookmarkId);

	void update(Bookmark item);

	void delete(int bookmarkId);

}
