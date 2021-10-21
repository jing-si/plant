package kr.co.gardener.admin.model.user;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import kr.co.gardener.util.GridSystem;

public class User extends GridSystem{
	private String userId;  //이메일주소
	private String userNick;
	private String userPass;
	@DateTimeFormat(pattern = "yyyy.MM.dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd",timezone="Asia/Seoul")
	private Date userBirth;
	private String userGender;
	private Integer stateId;
	private Integer forestId;
	private Integer plantId;
	
	//추가
	private String plant; //이미지

	/*
	 * Plant table의 plantId 외래키 추가
	 */

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNick=" + userNick + ", userPass=" + userPass + ", userBirth="
				+ userBirth + ", userGender=" + userGender + ", stateId=" + stateId + ", forestId=" + forestId
				+ ", plantId=" + plantId + ", plant="  + plant  + "]";
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

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getForestId() {
		return forestId;
	}

	public void setForestId(Integer forestId) {
		this.forestId = forestId;
	}

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public void update(User user) {
		if(userId.equals(user.userId)) {
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
			if(user.getStateId() != null) {
				stateId = user.getStateId();
			}
			if(user.getPlantId() != null) {
				plantId = user.getPlantId();
			}
			if(user.getForestId() != null) {
				forestId = user.getForestId();
			}
			if(user.getPlant() != null) {
				plant = user.getPlant();
			}
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