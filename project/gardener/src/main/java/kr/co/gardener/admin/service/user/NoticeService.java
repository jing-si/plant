package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.other.Notice;
import kr.co.gardener.admin.model.other.list.NoticeList;
import kr.co.gardener.util.Pager;

public interface NoticeService {

	List<Notice> list();

	void add(Notice item);

	Notice item(int noticeId);

	void update(Notice item);

	void delete(int noticeId);

	NoticeList list_pager(Pager pager);

	void insert_list(NoticeList list);

	void delete_list(NoticeList list);

	void update_list(NoticeList list);

	

}
