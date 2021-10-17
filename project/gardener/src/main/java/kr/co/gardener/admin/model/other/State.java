package kr.co.gardener.admin.model.other;

import kr.co.gardener.util.GridSystem;

public class State extends GridSystem{
	private int StateId;
	private String StateName;
	private String StateMessage;
	
	public int getStateId() {
		return StateId;
	}
	public void setStateId(int stateId) {
		StateId = stateId;
	}
	public String getStateName() {
		return StateName;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	public String getStateMessage() {
		return StateMessage;
	}
	public void setStateMessage(String stateMessage) {
		StateMessage = stateMessage;
	}
	
	
}
