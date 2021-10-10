package kr.co.gardener.admin.model.object.list;

import kr.co.gardener.admin.model.object.MidClass;
import kr.co.gardener.util.CommonList;

public class MidClassList extends CommonList<MidClass>{

	public MidClassList() {
		super("증분류");
	
		this.addTh("중분류ID","midClassId","number");
		this.addTh("대분류ID","topClassId","combo",0);
		this.addTh("중분류명","midClassName","text");
		
		this.addInsert("중분류ID","midClassId","number");
		this.addInsert("대분류ID","topClassId","combo",0);
		this.addInsert("중분류명","midClassName","text");
		
		
	}

	

}
