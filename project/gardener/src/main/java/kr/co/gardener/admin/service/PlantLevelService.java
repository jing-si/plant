package kr.co.gardener.admin.service;

import java.util.List;

import kr.co.gardener.admin.model.PlantLevel;

public interface PlantLevelService {

	List<PlantLevel> list();

	void add(PlantLevel item);

	PlantLevel item(int plantLevelId);

	void update(PlantLevel item);

	void delete(int plantLevelId);
}
