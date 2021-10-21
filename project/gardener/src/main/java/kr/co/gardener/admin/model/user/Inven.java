package kr.co.gardener.admin.model.user;

import kr.co.gardener.util.GridSystem;

public class Inven extends GridSystem{
	private String userId;
	private String plantName;
	private int invenAmount;
	
	private int plantId;		
	private String plantThumbnail;
	private String plantShadow;
	private String plantCategory;
	
	
	
	public String getPlantThumbnail() {
		return plantThumbnail;
	}
	public void setPlantThumbnail(String plantThumbnail) {
		this.plantThumbnail = plantThumbnail;
	}
	public String getPlantShadow() {
		return plantShadow;
	}
	public void setPlantShadow(String plantShadow) {
		this.plantShadow = plantShadow;
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
	public String getPlantCategory() {
		return plantCategory;
	}
	public void setPlantCategory(String plantCategory) {
		this.plantCategory = plantCategory;
	}
	
	
	
}
