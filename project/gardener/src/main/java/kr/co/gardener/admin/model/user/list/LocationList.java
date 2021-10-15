package kr.co.gardener.admin.model.user.list;

import kr.co.gardener.admin.model.user.Location;
import kr.co.gardener.util.CommonList;

public class LocationList extends CommonList<Location> {

	public LocationList() {
		super("배치 관리");

		this.addTh("배치ID","locationId","none");
		this.addTh("UserID","userId","none");
		this.addTh("크기","locationSize","number");
		this.addTh("X축","locationX","number");
		this.addTh("Y축","locationY","number");
		this.addTh("순서","locationOrder","number");
		this.addTh("식물","plantId","combo",1);
		
		this.addInsert("배치ID","locationId","none");
		this.addInsert("유저ID","userId","combo",0);
		this.addInsert("크기","locationSize","number");
		this.addInsert("X축","locationX","number");
		this.addInsert("Y축","locationY","number");
		this.addInsert("순서","locationOrder","number");
		this.addInsert("식물","plantId","combo",1);
		
		
		setView(true);
	}

}
