package kr.co.gardener.admin.service;

import java.util.List;

import kr.co.gardener.admin.model.Notice;

public interface NoticeService {

	List<Notice> list();

	void add(Notice item);

	Notice item(int noticeId);

	void update(Notice item);

	void delete(int noticeId);

	

}
