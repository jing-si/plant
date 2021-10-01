package kr.co.gardener.admin.model.user;

import java.util.List;

import kr.co.gardener.admin.model.Inven;
import kr.co.gardener.admin.model.Location;

public class UserInven {
	String userId;
	List<Location> location;
	List<Inven> inven;
	List<Integer> deleteId;
	
	public UserInven(String userId) {
		this.userId = userId;
	}
	
	public List<Location> getLocation() {
		return location;
	}
	public void setLocation(List<Location> location) {
		this.location = location;
	}
	
	public List<Inven> getInven() {
		return inven;
	}
	public void setInven(List<Inven> inven) {
		this.inven = inven;
	}
	
	//나무를 선택
	public Location choosePlant(int plantId) {
		Inven selected = null;
		Location newItem = null;
		
		for(Inven item : inven) {
			if(plantId == item.getPlantId()) {
				if(item.getInvenAmount()> 0) {					
					selected = item;
					item.setInvenAmount(item.getInvenAmount()-1);
					newItem = new Location(userId,0,1,150,300,location.size()+1,selected.getPlantId());
				}
			}
		}
		
		
		return newItem;
		
	}
}
