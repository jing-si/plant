package kr.co.gardener.admin.model.user;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.co.gardener.util.GridSystem;

public class History extends GridSystem{
	private int historyId;
	private String userId;
	private String productId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss",timezone="Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
	private Date historyDatetime;
	private String historyComment;
	
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Date getHistoryDatetime() {
		return historyDatetime;
	}
	public void setHistoryDatetime(Date historyDatetime) {
		this.historyDatetime = historyDatetime;
	}
	public String getHistoryComment() {
		return historyComment;
	}
	public void setHistoryComment(String historyComment) {
		this.historyComment = historyComment;
	}
	
	
	
	
	
}
