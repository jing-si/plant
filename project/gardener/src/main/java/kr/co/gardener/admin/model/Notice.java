package kr.co.gardener.admin.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Notice {
	
	private int noticeId;
	private String noticeTitle;
	private String noticeContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date noticeDate;
	
	
	

	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	

}
