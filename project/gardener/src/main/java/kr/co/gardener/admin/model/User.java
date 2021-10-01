package kr.co.gardener.admin.model;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private String userId;  //이메일주소
	private String userNick;
	private String userPass;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userBirth;
	private String userGender;
	private int stateId;
	private int forestId;
	private int plantId;
	private String plant; //이미지
	
	

	/*
	 * Plant table의 plantId 외래키 추가
	 */


	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public Date getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getForestId() {
		return forestId;
	}
	public void setForestId(int forestId) {
		this.forestId = forestId;
	}
	
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	
	
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNick=" + userNick + ", userPass=" + userPass + ", userBirth="
				+ userBirth + ", userGender=" + userGender + ", stateId=" + stateId + ", forestId=" + forestId
				+ ", plantId=" + plantId + ", plant=" + plant + "]";
	}
	
	public void update(User user) {
		if(user.getUserNick() != null) {
			userNick = user.getUserNick();
		}
		if(user.getUserPass() != null) {
			userPass = user.getUserPass();
		}
		if(user.getUserGender() != null) {
			userGender = user.getUserGender();
		}
		if(user.getUserBirth() != null) {
			userBirth = user.getUserBirth();
		}
		if(user.getStateId() != 0) {
			stateId = user.getStateId();
		}
		if(user.getPlantId() != 0) {
			plantId = user.getPlantId();
		}
		if(user.getForestId() != 0) {
			forestId = user.getForestId();
		}
	}
	
	//비밀번호 일치여부 검증
	public boolean pwcheck(String userPass) {
		if(this.userPass.equals(userPass)) {
			return true;
		}
		return false;
	}
	
	
}