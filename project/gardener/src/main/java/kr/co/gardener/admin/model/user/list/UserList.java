package kr.co.gardener.admin.model.user.list;

import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.util.CommonList;

public class UserList extends CommonList<User> {

	public UserList() {
		super("유저 관리");
		
		this.addTh("UserID","userId","none");
		this.addTh("닉네임","userNick","text");
		this.addTh("비밀번호","userPass","pass");
		this.addTh("생년월일","userBirth","date");
		this.addTh("성별","userGender","combo",0);
		this.addTh("상태ID","stateId","combo",1);
		this.addTh("숲ID","forestId","combo",2);
		this.addTh("식물ID","plantId","combo",3);
	
		this.addInsert("UserID","userId","text");
		this.addInsert("닉네임","userNick","text");
		this.addInsert("비밀번호","userPass","pass");
		this.addInsert("생년월일","userBirth","date");
		this.addInsert("성별","userGender","combo",0);
		this.addInsert("상태ID","stateId","combo",1);
		this.addInsert("숲ID","forestId","combo",2);
		this.addInsert("식물ID","plantId","combo",3);
		
		
		setView(true);
	}


}
