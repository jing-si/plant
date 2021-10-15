package kr.co.gardener.admin.model.forest.list;

import kr.co.gardener.admin.model.forest.Plant;
import kr.co.gardener.util.CommonList;

public class PlantList extends CommonList<Plant>{

	public PlantList() {
		super("식물 종류 관리");
		
		this.addTh("식물ID","plantId","none");
		this.addTh("식물이름","plantName","text");
		this.addTh("식물카테고리","plantCategory","combo",0);
		this.addTh("식물INFO","plantInfo","area");
		this.addTh("실루엣","plantShadow","file");
		
		this.addInsert("식물ID","plantId","none");
		this.addInsert("식물이름","plantName","text");
		this.addInsert("식물카테고리","plantCategory","combo",0);
		this.addInsert("식물INFO","plantInfo","area");
		this.addInsert("실루엣","plantShadow","file");
		
		setView(true);
		
	}

	
}
