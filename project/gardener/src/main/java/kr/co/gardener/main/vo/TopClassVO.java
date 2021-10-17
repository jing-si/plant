package kr.co.gardener.main.vo;

import java.util.List;

import kr.co.gardener.admin.model.object.MidClass;
import kr.co.gardener.admin.model.object.TopClass;

public class TopClassVO extends TopClass{
	private List<MidClass> midList;

	public List<MidClass> getMidList() {
		return midList;
	}

	public void setMidList(List<MidClass> midList) {
		this.midList = midList;
	}
	
}
