package kr.co.gardener.admin.dao;

import java.util.List;

import kr.co.gardener.admin.model.Notice;

public interface NoticeDao {

	List<Notice> list();

	void add(Notice item);

	Notice item(int noticeId);

	void update(Notice item);

	void delete(int noticeId);

}
