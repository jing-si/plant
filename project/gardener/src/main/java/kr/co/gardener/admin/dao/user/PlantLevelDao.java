package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.user.PlantLevel;

public interface PlantLevelDao {

	List<PlantLevel> list();

	void add(PlantLevel item);

	PlantLevel item(int plantLevelId);

	void update(PlantLevel item);

	void delete(int plantLevelId);

}
