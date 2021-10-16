package kr.co.gardener.admin.model.other.list;

import kr.co.gardener.admin.model.other.RandomMessage;
import kr.co.gardener.util.CommonList;

public class RandomMessageList extends CommonList<RandomMessage>{

	public RandomMessageList() {
		super("랜덤 메시지 관리");
		

		addTh("랜덤메시지ID", "randomMessageId", "none");
		addTh("카테고리", "randomMessageCategory", "text");
		addTh("메시지", "randomMessageText", "text");
		
		addInsert("랜덤메시지ID", "randomMessageId", "none");
		addInsert("카테고리", "randomMessageCategory", "text");
		addInsert("메시지", "randomMessageText", "text");
		
		setView(true);
	}

	
}
