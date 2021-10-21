package kr.co.gardener.admin.model.forest;

import kr.co.gardener.util.GridSystem;

public class Plant extends GridSystem{
	private int plantId;
	private String plantName;
	private String plantCategory;
	private String plantInfo;
	private String plantShadow;
	private String plantThumbnail;
	
	/*
	 * plantShadow 필드 추가
	 */
	
	
	
	public String getPlantShadow() {
		return plantShadow;
	}
	public String getPlantThumbnail() {
		return plantThumbnail;
	}
	public void setPlantThumbnail(String plantThumbnail) {
		this.plantThumbnail = plantThumbnail;
	}
	public void setPlantShadow(String plantShadow) {
		this.plantShadow = plantShadow;
	}
	
	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
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
	public String getPlantInfo() {
		return plantInfo;
	}
	public void setPlantInfo(String plantInfo) {
		this.plantInfo = plantInfo;
	}
	
	
}
