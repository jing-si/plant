package kr.co.gardener.admin.dao.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.user.PlantLevelDao;
import kr.co.gardener.admin.model.forest.PlantLevel;
import kr.co.gardener.main.vo.PlantImage;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;
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

	@Override
	public List<PlantLevel> list_pager(Pager pager) {
		return sql.selectList("plantLevel.list_pager", pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("plantLevel.total", pager);
	}

	@Override
	public List<ComboItem> combo() {
		return sql.selectList("plantLevel.combo");
	}

	@Override
	public void insert_list(List<PlantLevel> list) {
		sql.insert("plantLevel.insert_list", list);
	}

	@Override
	public void delete_list(List<PlantLevel> list) {
		sql.insert("plantLevel.delete_list", list);
		
	}

	@Override
	public void update_list(List<PlantLevel> list) {
		sql.insert("plantLevel.update_list", list);
		
	}

	@Override
	public List<PlantLevel> maturePlant() {
		
		return sql.selectList("plantLevel.maturePlant");
	}

	@Override
	public List<PlantImage> plantImage() {
		
		return sql.selectList("plantLevel.plantImage");
	}

}
