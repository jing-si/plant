package kr.co.gardener.admin.model.forest.list;

import kr.co.gardener.admin.model.forest.PlantLevel;
import kr.co.gardener.util.CommonList;

public class PlantLevelList extends CommonList<PlantLevel>{

	public PlantLevelList() {
		super("식물 레벨 관리");
		
		this.addTh("식물","plantName","none");
		this.addTh("식물Level","plantLevelId","none");
		this.addTh("식물Image","plantImage","file");
		this.addTh("식물ID","plantId","hide");
		
		this.addInsert("식물ID","plantId","combo",0);
		this.addInsert("식물Level","plantLevelId","number");
		this.addInsert("식물Image","plantImage","file");
		
		setView(true);
		
	}

	
}
