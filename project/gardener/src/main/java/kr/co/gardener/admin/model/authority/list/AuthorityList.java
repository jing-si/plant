package kr.co.gardener.admin.model.authority.list;

import kr.co.gardener.admin.model.authority.Authority;
import kr.co.gardener.util.CommonList;

public class AuthorityList extends CommonList<Authority>{

	public AuthorityList() {
		super("Admin 관리");
		addTh("아이디", "adminId", "none");
		addTh("비밀번호", "adminPass", "pass");
		addTh("이름", "adminName", "text");
		addTh("Product 권한", "product", "combo",0);
		addTh("User 권한", "user", "combo",0);
		addTh("Forest 권한", "forest", "combo",0);
		addTh("Other 권한", "other", "combo",0);
		addTh("Authority 권한", "authority", "combo",0);
		
		
		addInsert("아이디", "adminId", "text");
		addInsert("비밀번호", "adminPass", "pass");
		addInsert("이름", "adminName", "text");
		addInsert("Product 권한", "product", "combo",0);
		addInsert("User 권한", "user", "combo",0);
		addInsert("Forest 권한", "forest", "combo",0);
		addInsert("Other 권한", "other", "combo",0);
		addInsert("Authority 권한", "authority", "combo",0);
		
		setView(true);
	}

}
