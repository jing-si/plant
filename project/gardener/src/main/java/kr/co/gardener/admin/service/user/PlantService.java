package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Plant;

public interface PlantService {

	List<Plant> list();

	void add(Plant item);

	Plant item(int plantId);

	void update(Plant item);

	void delete(int plantId);

}
