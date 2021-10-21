package kr.co.gardener.admin.model.other;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.co.gardener.util.GridSystem;

public class Notice extends GridSystem{
	
	private int noticeId;
	private String noticeTitle;
	
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd",timezone="Asia/Seoul")
	private Date noticeDate;
	
	private String noticeContent;

	
	
	

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
