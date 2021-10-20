package kr.co.gardener.admin.model.user;

import kr.co.gardener.admin.model.forest.Plant;
import kr.co.gardener.util.GridSystem;

public class Inven extends GridSystem{
	private String userId;
	private String plantName;
	private int invenAmount;
	
	private int plantId;
	
	private Plant plant;
	
	public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
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
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	
	
}
