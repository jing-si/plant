package kr.co.gardener.admin.model.object;

import kr.co.gardener.util.GridSystem;

public class MidClass extends GridSystem{
	private int midClassId;
	private int topClassId;
	private String midClassName;
	
	public int getMidClassId() {
		return midClassId;
	}
	public void setMidClassId(int midClassId) {
		this.midClassId = midClassId;
	}
	public int getTopClassId() {
		return topClassId;
	}
	public void setTopClassId(int topClassId) {
		this.topClassId = topClassId;
	}
	public String getMidClassName() {
		return midClassName;
	}
	public void setMidClassName(String midClassName) {
		this.midClassName = midClassName;
	}
	
	

}
