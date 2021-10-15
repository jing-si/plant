package kr.co.gardener.admin.model.forest;

import kr.co.gardener.util.GridSystem;

public class PlantLevel extends GridSystem{
	private String plantName;
	private int plantId;
	private String plantImage;
	private int plantLevelId;
	
	
	
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
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
