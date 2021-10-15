package kr.co.gardener.admin.model.object;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.co.gardener.util.GridSystem;

public class Product extends GridSystem {

	public Product() {
		super();
	}

	// DB를 위한
	protected String productId;
	protected String productName;
	protected String productSize;
	protected String productImage;
	protected int certId;
	protected int productCertId;

	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone="Asia/Seoul")
	protected Date productStartDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone="Asia/Seoul")
	protected Date productEndDate;
	protected String companyId;
	protected int g2bId;
	protected int elId;

	

	// 추가 필드
	protected List<CertReason> certReasons;
	protected Cert cert;
	protected String bookmark;
	
	public String getBookmark() {
		return bookmark;
	}
	public void setBookmark(String bookmark) {
		this.bookmark = bookmark;
	}
	// 유틸성
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getCertId() {
		return certId;
	}
	public void setCertId(int certId) {
		this.certId = certId;
	}
	public String getProductCertId() {
		return String.valueOf(productCertId);
	}
	public void setProductCertId(int productCertId) {
		this.productCertId = productCertId;
	}
	public String getProductStartDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(productStartDate);
	}
	public void setProductStartDate(Date productStartDate) {
		this.productStartDate = productStartDate;
	}
	public String getProductEndDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(productEndDate);
	}
	public void setProductEndDate(Date productEndDate) {
		this.productEndDate = productEndDate;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public int getG2bId() {
		return g2bId;
	}
	public void setG2bId(int g2bId) {
		this.g2bId = g2bId;
	}
	public int getElId() {
		return elId;
	}
	public void setElId(int elId) {
		this.elId = elId;
	}
	public List<CertReason> getCertReasons() {
		return certReasons;
	}
	public void setCertReasons(List<CertReason> certReasons) {
		this.certReasons = certReasons;
	}
	public Cert getCert() {
		return cert;
	}
	public void setCert(Cert cert) {
		this.cert = cert;
	}

	// api용 get,seet
	

	

}
