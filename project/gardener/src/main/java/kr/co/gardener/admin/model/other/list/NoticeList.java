package kr.co.gardener.admin.model.other.list;

import kr.co.gardener.admin.model.other.Notice;
import kr.co.gardener.util.CommonList;

public class NoticeList extends CommonList<Notice>{

	public NoticeList() {
		super("공지 관리");
		
		addTh("공지ID", "noticeId", "none");
		addTh("제목", "noticeTitle", "text");
		addTh("날짜", "noticeDate", "date");
		addTh("내용", "noticeContent", "area");
		
		addInsert("상태ID", "noticeId", "none");
		addInsert("상태명", "noticeTitle", "text");
		addInsert("상태 메시지", "noticeContent", "area");
		
		setView(true);
	}

}
