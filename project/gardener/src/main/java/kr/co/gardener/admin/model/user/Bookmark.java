package kr.co.gardener.admin.model.user;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.co.gardener.util.GridSystem;

public class Bookmark extends GridSystem {
	private int bookmarkId;
	private String userId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date bookmarkDatetime;
	private int productId;
	private String companyId;
	
	private String productImage;
	private String productName;
	
	
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
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
