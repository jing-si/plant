package kr.co.gardener.main.vo;

import java.util.List;

import kr.co.gardener.admin.model.object.Company;

public class BrandVO {
	private String title;
	private List<Company> list;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Company> getList() {
		return list;
	}
	public void setList(List<Company> list) {
		this.list = list;
	}
	
	
}
