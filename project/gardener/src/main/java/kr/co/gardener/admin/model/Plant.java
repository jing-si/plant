package kr.co.gardener.admin.model;

public class Plant {
	private int plantId;
	private String plantName;
	private String plantCategory;
	private String plantInfo;
	private String plantShadow;
	
	/*
	 * plantShadow 필드 추가
	 */
	
	public String getPlantShadow() {
		return plantShadow;
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
