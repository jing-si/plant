package kr.co.gardener.admin.model.user.list;

import kr.co.gardener.admin.model.user.Inven;
import kr.co.gardener.admin.model.user.Location;
import kr.co.gardener.util.CommonList;

public class InvenList extends CommonList<Inven> {

	public InvenList() {
		super("인벤관리 관리");

		this.addTh("유저ID","userId","none");
		this.addTh("식물이름","plantName","none");
		this.addTh("갯수","invenAmount","number");
		this.addTh("식물ID","plantId","hide");
		
		this.addInsert("유저ID","userId","combo",0);
		this.addInsert("식물","plantId","combo",1);
		this.addInsert("갯수","invenAmount","number");
		
		setView(true);
	}

}
