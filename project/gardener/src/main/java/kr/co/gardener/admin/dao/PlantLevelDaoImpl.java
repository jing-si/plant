package kr.co.gardener.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.model.PlantLevel;
@Repository
public class PlantLevelDaoImpl implements PlantLevelDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<PlantLevel> list() {
		return sql.selectList("plantLevel.list");
	}

	@Override
	public void add(PlantLevel item) {
		sql.insert("plantLevel.add", item);
	}

	@Override
	public PlantLevel item(int plantLevelId) {
		return sql.selectOne("plantLevel.item", plantLevelId);
	}

	@Override
	public void update(PlantLevel item) {
		sql.update("plantLevel.update", item);
	}

	@Override
	public void delete(int plantLevelId) {
		sql.delete("plantLevel.delete", plantLevelId);
	}

}
