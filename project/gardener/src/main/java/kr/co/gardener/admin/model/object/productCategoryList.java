package kr.co.gardener.admin.model.object;

import java.util.List;

public class productCategoryList {
	private String productCategoryName;
	private String productCategoryId;
	private List<Classify> midList;
	
	
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public List<Classify> getMidList() {
		return midList;
	}
	public void setMidList(List<Classify> midList) {
		this.midList = midList;
	}
	public String getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	
	
	
	
	
	
}
