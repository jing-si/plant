package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.PlantLevel;

public interface PlantLevelService {

	List<PlantLevel> list();

	void add(PlantLevel item);

	PlantLevel item(int plantLevelId);

	void update(PlantLevel item);

	void delete(int plantLevelId);
}
