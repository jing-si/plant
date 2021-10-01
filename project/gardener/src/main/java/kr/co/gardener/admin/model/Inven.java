package kr.co.gardener.admin.model;

public class Inven {
	private int invenId;
	private String userId;
	private int plantId;
	private int invenAmount;
	
	public int getInvenId() {
		return invenId;
	}
	public void setInvenId(int invenId) {
		this.invenId = invenId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	public int getInvenAmount() {
		return invenAmount;
	}
	public void setInvenAmount(int invenAmount) {
		this.invenAmount = invenAmount;
	}
}
