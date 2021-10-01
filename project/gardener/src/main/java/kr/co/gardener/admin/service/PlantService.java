package kr.co.gardener.admin.service;

import java.util.List;

import kr.co.gardener.admin.model.Plant;

public interface PlantService {

	List<Plant> list();

	void add(Plant item);

	Plant item(int plantId);

	void update(Plant item);

	void delete(int plantId);

}
