package kr.co.gardener.admin.model.user.list;

import kr.co.gardener.admin.model.user.Bookmark;
import kr.co.gardener.util.CommonList;

public class BookmarkList extends CommonList<Bookmark>{

	public BookmarkList() {
		super("즐겨찾기");
		
		
		this.addTh("즐겨찾기ID","bookmarkId","none");
		this.addTh("유저ID","userId","none");
		this.addTh("등록날짜","bookmarkDatetime","datetime");
		this.addTh("제품ID","productId","combo",0);
		this.addTh("사업자ID","companyId","combo",1);
		
		this.addInsert("즐겨찾기ID","bookmarkId","none");
		this.addInsert("유저ID","userId","combo",1);
		this.addInsert("등록날짜","bookmarkDatetime","datetime");
		this.addInsert("제품ID","productId","combo",0);
		this.addInsert("사업자ID","companyId","combo",2);
		
		setView(true);
	}

}
