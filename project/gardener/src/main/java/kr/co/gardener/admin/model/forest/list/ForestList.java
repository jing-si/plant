package kr.co.gardener.admin.model.forest.list;

import kr.co.gardener.admin.model.forest.Forest;
import kr.co.gardener.util.CommonList;

public class ForestList extends CommonList<Forest>{

	public ForestList() {
		super("숲 관리");
		
		this.addTh("숲ID","forestId","none");
		this.addTh("숲 이름","forestName","text");
		this.addTh("숲 Image","forestImage","file");
		this.addTh("숲 INFO","forestInfo","area");
		
		this.addInsert("숲ID","forestId","none");
		this.addInsert("숲 이름","forestName","text");
		this.addInsert("숲 Image","forestImage","file");
		this.addInsert("숲 INFO","forestInfo","area");
		
		
		setView(true);
	}

}
