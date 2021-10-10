package kr.co.gardener.admin.model.object;

import kr.co.gardener.util.GridSystem;

public class ProductCertReason extends GridSystem{
 private int productCertReasonId;
 private String productId;
 private int certReasonId;
 
public int getProductCertReasonId() {
	return productCertReasonId;
}
public void setProductCertReasonId(int productCertReasonId) {
	this.productCertReasonId = productCertReasonId;
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
