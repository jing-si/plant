package kr.co.gardener.admin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.model.Inven;
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

}
