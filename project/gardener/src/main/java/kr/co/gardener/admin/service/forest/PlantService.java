package kr.co.gardener.admin.service.forest;

import java.util.List;

import kr.co.gardener.admin.model.forest.Plant;
import kr.co.gardener.admin.model.forest.list.PlantList;
import kr.co.gardener.util.Pager;

public interface PlantService {

	List<Plant> list();

	void add(Plant item);

	Plant item(int plantId);

	void update(Plant item);

	void delete(int plantId);

	PlantList list_pager(Pager pager);

	void insert_list(PlantList list);

	void delete_list(PlantList list);

	void update_list(PlantList list);

	String PlantThumbnailImg(int plantId);

}
