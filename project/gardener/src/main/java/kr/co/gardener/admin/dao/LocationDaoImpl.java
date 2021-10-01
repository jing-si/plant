package kr.co.gardener.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.model.Location;
@Repository
public class LocationDaoImpl implements LocationDao {
	
	@Autowired
	SqlSession sql;
	
	@Override
	public List<Location> list() {
		return sql.selectList("location.list");
	}

	@Override
	public void add(Location item) {
		sql.insert("location.add", item);
	}

	@Override
	public Location item(int locationId) {
		return sql.selectOne("location.item", locationId);
	}

	@Override
	public void update(Location item) {
		sql.update("location.update", item);
	}

	@Override
	public void delete(int locationId) {
		sql.delete("location.delete", locationId);
	}

	@Override
	public List<Location> list(String userId) {
		return sql.selectList("location.list_userId", userId);
	}

}
