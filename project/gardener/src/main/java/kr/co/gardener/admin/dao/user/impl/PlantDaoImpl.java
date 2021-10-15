package kr.co.gardener.admin.dao.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.user.PlantDao;
import kr.co.gardener.admin.model.forest.Plant;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;
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

	@Override
	public List<Plant> list_pager(Pager pager) {
		return sql.selectList("plant.list_pager", pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("plant.total",pager);
	}

	@Override
	public List<ComboItem> combo() {
		return sql.selectList("plant.combo");
	}

	@Override
	public void insert_list(List<Plant> list) {
		sql.insert("plant.insert_list", list);
	}

	@Override
	public void delete_list(List<Plant> list) {
		sql.delete("plant.delete_list", list);
		
	}

	@Override
	public void update_list(List<Plant> list) {
		sql.update("plant.update_list", list);
		
	}

}
