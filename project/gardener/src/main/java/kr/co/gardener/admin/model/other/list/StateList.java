package kr.co.gardener.admin.model.other.list;

import kr.co.gardener.admin.model.other.State;
import kr.co.gardener.util.CommonList;

public class StateList extends CommonList<State>{

	public StateList() {
		super("상태 관리");
		
		addTh("상태ID", "stateId", "none");
		addTh("상태명", "stateName", "text");
		addTh("상태 메시지", "stateMessage", "text");
		
		addInsert("상태ID", "stateId", "number");
		addInsert("상태명", "stateName", "text");
		addInsert("상태 메시지", "stateMessage", "text");
	}

}
