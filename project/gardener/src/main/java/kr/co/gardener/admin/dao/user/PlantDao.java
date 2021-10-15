package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.forest.Plant;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

public interface PlantDao {

	List<Plant> list();

	void add(Plant item);

	Plant item(int plantId);

	void update(Plant item);

	void delete(int plantId);

	List<Plant> list_pager(Pager pager);

	float total(Pager pager);

	List<ComboItem> combo();

	void insert_list(List<Plant> list);

	void delete_list(List<Plant> list);

	void update_list(List<Plant> list);

}
