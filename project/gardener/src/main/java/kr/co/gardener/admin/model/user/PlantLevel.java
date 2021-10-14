package kr.co.gardener.admin.model.user;

import kr.co.gardener.util.GridSystem;

public class PlantLevel extends GridSystem{
	private int plantLevelId;
	private int plantId;
	private String plantImage;
	
	public int getPlantLevelId() {
		return plantLevelId;
	}
	public void setPlantLevelId(int plantLevelId) {
		this.plantLevelId = plantLevelId;
	}
	public int getPlantId() {
		return plantId;
	}
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	public String getPlantImage() {
		return plantImage;
	}
	public void setPlantImage(String plantImage) {
		this.plantImage = plantImage;
	}	

}
