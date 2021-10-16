package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.other.Notice;
import kr.co.gardener.util.Pager;

public interface NoticeDao {

	List<Notice> list();

	void add(Notice item);

	Notice item(int noticeId);

	void update(Notice item);

	void delete(int noticeId);

	List<Notice> list_pager(Pager pager);

	float total(Pager pager);

	void insert_list(List<Notice> list);

	void delete_list(List<Notice> list);

	void update_list(List<Notice> list);

}
