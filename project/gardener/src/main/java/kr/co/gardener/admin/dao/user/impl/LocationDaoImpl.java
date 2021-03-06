package kr.co.gardener.admin.dao.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.user.LocationDao;
import kr.co.gardener.admin.model.user.Inven;
import kr.co.gardener.admin.model.user.Location;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;
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

	@Override
	public List<Location> list_pager(Pager pager) {
		return sql.selectList("location.list_pager", pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("location.total",pager);
	}

	@Override
	public List<ComboItem> combo() {
		return sql.selectList("location.combo");
	}

	@Override
	public void insert_list(List<Location> list) {
		sql.insert("location.insert_list", list);
	}

	@Override
	public void delete_list(List<Location> list) {
		sql.delete("location.delete_list", list);
	}

	@Override
	public void update_list(List<Location> list) {
		sql.update("location.update_list", list);
	}


}
