package kr.co.gardener.admin.model.object;

import kr.co.gardener.util.GridSystem;

public class BotClass extends GridSystem{
	private int botClassId;
	private int midClassId;
	private String botClassName;
	
	public int getBotClassId() {
		return botClassId;
	}
	public void setBotClassId(int botClassId) {
		this.botClassId = botClassId;
	}
	public int getMidClassId() {
		return midClassId;
	}
	public void setMidClassId(int midClassId) {
		this.midClassId = midClassId;
	}
	public String getBotClassName() {
		return botClassName;
	}
	public void setBotClassName(String botClassName) {
		this.botClassName = botClassName;
	}
	
	
}
