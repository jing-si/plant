package kr.co.gardener.admin.model.object;

import kr.co.gardener.util.GridSystem;

public class ProductCertReason extends GridSystem{
 private int productcertReasonId;
 private String productId;
 private int certReasonId;
public int getProductcertReasonId() {
	return productcertReasonId;
}
public void setProductcertReasonId(int productcertReasonId) {
	this.productcertReasonId = productcertReasonId;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public int getCertReasonId() {
	return certReasonId;
}
public void setCertReasonId(int certReasonId) {
	this.certReasonId = certReasonId;
}
 
 
}
