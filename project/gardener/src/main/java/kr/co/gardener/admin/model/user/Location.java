package kr.co.gardener.admin.model.user;

import kr.co.gardener.util.GridSystem;

public class Location extends GridSystem{
	private int locationId;
	private String userId;	
	private float locationSize;
	private double locationX;
	private double locationY;
	private int locationOrder;
	private int plantId;

	private String plantImage; // 식물 이미지(join으로 PlantLevel에서 가지고올것)
	private int locationState = 0; //0이 기본값, 0이면 정상, 1이면 신규, 2면 삭제 요망
	
	
	public int getLocationState() {
		return locationState;
	}

	public void setLocationState(int locationState) {
		this.locationState = locationState;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public float getLocationSize() {
		return locationSize;
	}

	public void setLocationSize(float locationSize) {
		this.locationSize = locationSize;
	}

	public double getLocationX() {
		return locationX;
	}



	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}



	public double getLocationY() {
		return locationY;
	}



	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}



	public int getLocationOrder() {
		return locationOrder;
	}



	public void setLocationOrder(int locationOrder) {
		this.locationOrder = locationOrder;
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



	// 서버에 데이터 보낼때 사용?
	// plantImage는 어디서 가져오는건지?
	// float 타입은 != 0 이 부분을 어떻게 표기하는지?
	public void save(Location item) {
		if (locationId == item.getLocationId()) {

			if (item.getLocationOrder() != 0) {
				locationOrder = item.getLocationOrder();
			}
			if (item.getLocationSize() != 0) {
				locationSize = item.getLocationSize();
			}
			if (item.getLocationX() != 0) {
				locationX = item.getLocationX();
			}
			if (item.getLocationY() != 0) {
				locationY = item.getLocationY();
			}
			if (item.getPlantId() != 0) {
				plantId = item.getPlantId();
			}

		}
	}
	
	
	
	public Location(String userId, int locationId, int plantId, float locationSize, int locationX, int locationY,
			int locationOrder) {
		super();
		this.userId = userId;
		this.locationId = locationId;
		this.plantId = plantId;
		this.locationSize = locationSize;
		this.locationX = locationX;
		this.locationY = locationY;
		this.locationOrder = locationOrder;
		this.plantImage = "upload/plant" + plantId+"-5";		
	}
	
	public Location() {
		super();
	}

	@Override
	public String toString() {
		return "Location [userId=" + userId + ", locationId=" + locationId + ", plantId=" + plantId + ", locationSize="
				+ locationSize + ", locationX=" + locationX + ", locationY=" + locationY + ", locationOrder="
				+ locationOrder + ", plantImage=" + plantImage + "]";
	}

}
