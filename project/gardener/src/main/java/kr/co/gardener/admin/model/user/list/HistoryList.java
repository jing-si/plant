package kr.co.gardener.admin.model.user.list;

import kr.co.gardener.admin.model.user.History;
import kr.co.gardener.util.CommonList;

public class HistoryList extends CommonList<History>{

	public HistoryList() {
		super("인증 기록");
		
		
		this.addTh("기록ID","historyId","none");
		this.addTh("유저ID","userId","none");
		this.addTh("제품ID","productId","combo",1);
		this.addTh("인증날짜","historyDatetime","datetime");
		this.addTh("코멘트","historyComment","area");
		
		this.addInsert("기록ID","historyId","none");
		this.addInsert("유저ID","userId","combo",0);
		this.addInsert("제품ID","productId","combo",1);
		this.addInsert("인증날짜","historyDatetime","datetime");
		this.addInsert("코멘트","historyComment","area");
		
		setView(true);
	}

}
