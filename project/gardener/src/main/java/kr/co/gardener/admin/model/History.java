package kr.co.gardener.admin.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class History {
	private int historyId;
	private String userId;
	private String productId;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date historyDateTime;
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
	public Date getHistoryDateTime() {
		return historyDateTime;
	}
	public void setHistoryDateTime(Date historyDateTime) {
		this.historyDateTime = historyDateTime;
	}
	public String getHistoryComment() {
		return historyComment;
	}
	public void setHistoryComment(String historyComment) {
		this.historyComment = historyComment;
	}
	
	
	
	
}
