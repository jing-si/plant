package kr.co.gardener.admin.service.forest;

import java.util.List;

import kr.co.gardener.admin.model.forest.PlantLevel;
import kr.co.gardener.admin.model.forest.list.PlantLevelList;
import kr.co.gardener.util.Pager;

public interface PlantLevelService {

	List<PlantLevel> list();

	void add(PlantLevel item);

	PlantLevel item(int plantLevelId);

	void update(PlantLevel item);

	void delete(int plantLevelId);

	PlantLevelList list_pager(Pager pager);

	void insert_list(PlantLevelList list);

	void delete_list(PlantLevelList list);

	void update_list(PlantLevelList list);

	List<PlantLevel> random();

}
