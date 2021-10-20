package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.forest.PlantLevel;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

public interface PlantLevelDao {

	List<PlantLevel> list();

	void add(PlantLevel item);

	PlantLevel item(int plantLevelId);

	void update(PlantLevel item);

	void delete(int plantLevelId);

	List<PlantLevel> list_pager(Pager pager);

	float total(Pager pager);

	List<ComboItem> combo();

	void insert_list(List<PlantLevel> list);

	void delete_list(List<PlantLevel> list);

	void update_list(List<PlantLevel> list);

	List<PlantLevel> maturePlant();

}
