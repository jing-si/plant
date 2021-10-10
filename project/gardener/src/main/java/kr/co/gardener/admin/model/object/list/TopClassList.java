package kr.co.gardener.admin.model.object.list;

import kr.co.gardener.admin.model.object.TopClass;
import kr.co.gardener.util.CommonList;

public class TopClassList extends CommonList<TopClass>{

	public TopClassList() {
		super("대분류");
	
		this.addTh("대분류ID","topClassId","number");
		this.addTh("대분류명","topClassName","text");
		
		this.addInsert("대분류ID","topClassId","number");
		this.addInsert("대분류명","topClassName","text");
		
		
	}

	

}
