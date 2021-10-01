package kr.co.gardener.admin.model.object;

import java.util.List;

public class Company {
	private String vendVcod;
	private String vendVcnm;
	private String vendTel;
	private String vendAddr;
	private String vendHome;
	
	private List<Product> list;
	
	
	
	
	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public String getCompanyId() {
		return vendVcod;
	}

	public void setCompanyId(String companyId) {
		this.vendVcod = companyId;
	}

	public String getCompanyName() {
		return vendVcnm;
	}

	public void setCompanyName(String companyName) {
		this.vendVcnm = companyName;
	}

	public String getCompanyTel() {
		return vendTel;
	}

	public void setCompanyTel(String companyTel) {
		this.vendTel = companyTel;
	}

	public String getCompanyAddress() {
		return vendAddr;
	}

	public void setCompanyAddress(String companyAddress) {
		this.vendAddr = companyAddress;
	}

	public String getCompanyHomepage() {
		return vendHome;
	}

	public void setCompanyHomepage(String companyHomepage) {
		this.vendHome = companyHomepage;
	}

	@Override
	public String toString() {
		return "Company [vendVcod=" + vendVcod + ", vendVcnm=" + vendVcnm + ", vendTel=" + vendTel + ", vendAddr="
				+ vendAddr + ", vendHome=" + vendHome + "]";
	}

	public Product getProduct(String productId) {
		for(Product item : list) {
			if(item.getProductId().equals(productId)) {
				return item;
			}
		}
		
		return null;
	}

	
	
	
	
}
