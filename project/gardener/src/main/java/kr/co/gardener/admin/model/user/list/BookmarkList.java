package kr.co.gardener.admin.model.user.list;

import kr.co.gardener.admin.model.user.Bookmark;
import kr.co.gardener.util.CommonList;

public class BookmarkList extends CommonList<Bookmark>{

	public BookmarkList() {
		super("즐겨찾기");
		
		
		this.addTh("제품명","productName","none");
		this.addTh("유저ID","userId","none");
		this.addTh("등록날짜","bookmarkDatetime","datetime");
		this.addTh("기업명","companyName","none");
		this.addTh("사업자ID","companyId","hide");
		this.addTh("제품ID","productId","hide");
		
		this.addInsert("유저ID","userId","combo",1);
		this.addInsert("제품ID","productId","combo",0);
		this.addInsert("등록날짜","bookmarkDatetime","datetime");
		
		setView(true);
	}

}
