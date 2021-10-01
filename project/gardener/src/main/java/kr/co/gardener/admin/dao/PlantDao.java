package kr.co.gardener.admin.dao;

import java.util.List;

import kr.co.gardener.admin.model.Plant;

public interface PlantDao {

	List<Plant> list();

	void add(Plant item);

	Plant item(int plantId);

	void update(Plant item);

	void delete(int plantId);

}
