package kr.co.gardener.admin.model.object.list;

import kr.co.gardener.admin.model.object.BotClass;
import kr.co.gardener.util.CommonList;

public class BotClassList extends CommonList<BotClass>{

	public BotClassList() {
		super("소분류");
	
		this.addTh("소분류ID","botClassId","none");
		this.addTh("중분류","midClassId","combo",0);
		this.addTh("소분류명","botClassName","text");
		
		this.addInsert("소분류ID","botClassId","number");
		this.addInsert("중분류","midClassId","combo",0);
		this.addInsert("소분류명","botClassName","text");
		
		setView(true);
	}

	

}
