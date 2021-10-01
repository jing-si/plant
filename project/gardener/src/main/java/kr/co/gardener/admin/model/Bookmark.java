package kr.co.gardener.admin.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Bookmark {
	private int bookmarkId;
	private String userId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date bookmarkDatetime;
	private int productId;
	public int getBookmarkId() {
		return bookmarkId;
	}
	public void setBookmarkId(int bookmarkId) {
		this.bookmarkId = bookmarkId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getBookmarkDatetime() {
		return bookmarkDatetime;
	}
	public void setBookmarkDatetime(Date bookmarkDatetime) {
		this.bookmarkDatetime = bookmarkDatetime;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
}
