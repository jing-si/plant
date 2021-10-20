package kr.co.gardener.admin.dao.user.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.user.InvenDao;
import kr.co.gardener.admin.model.user.Inven;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;
@Repository
public class InvenDaoImpl implements InvenDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Inven> list() {
		return sql.selectList("inven.list");
	}

	@Override
	public void add(Inven item) {
		sql.insert("inven.add", item);
	}

	@Override
	public Inven item(int userId, int plantId) {
	
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("userId", userId);
		map.put("plantId", plantId);
		
		return sql.selectOne("inven.item", map);
		
	}

	@Override
	public void update(Inven item) {
		sql.update("inven.update", item);
	}

	@Override
	public void delete(int userId, int plantId) {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("userId", userId);
		map.put("plantId", plantId);
				
		sql.delete("inven.delete", map);
	}

	@Override
	public List<Inven> list(String userId) {
		return sql.selectList("inven.list_userId", userId);
	}

	@Override
	public List<Inven> list_pager(Pager pager) {
		return sql.selectList("inven.list_pager",pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("inven.total",pager);
	}

	@Override
	public List<ComboItem> combo() {
		return sql.selectList("inven.combo");
	}

	@Override
	public void insert_list(List<Inven> list) {
		sql.insert("inven.insert_list", list);
	}

	@Override
	public void delete_list(List<Inven> list) {
		sql.insert("inven.delete_list", list);		
	}

	@Override
	public void update_list(List<Inven> list) {
		sql.insert("inven.update_list", list);		
	}

	@Override
	public void plant(Inven inven) {
		
	}

	@Override
	public int countDown(Inven inven) {
		return sql.update("inven.countDown",inven);
	}

	@Override
	public int countUp(Inven inven) {
		return sql.update("inven.countUp",inven);
	}

}
