package kr.co.gardener.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.model.Plant;
@Repository
public class PlantDaoImpl implements PlantDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Plant> list() {
		return sql.selectList("plant.list");
	}

	@Override
	public void add(Plant item) {
		sql.insert("plant.add", item);
	}

	@Override
	public Plant item(int plantId) {
		return sql.selectOne("plant.item", plantId);
	}

	@Override
	public void update(Plant item) {
		sql.update("plant.update", item);
	}

	@Override
	public void delete(int plantId) {
		sql.delete("plant.delete", plantId);
	}

}
