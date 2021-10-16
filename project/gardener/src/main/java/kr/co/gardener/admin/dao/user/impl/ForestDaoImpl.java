package kr.co.gardener.admin.dao.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.user.ForestDao;
import kr.co.gardener.admin.model.forest.Forest;
import kr.co.gardener.util.Pager;
@Repository
public class ForestDaoImpl implements ForestDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Forest> list() {
		return sql.selectList("forest.list");
	}

	@Override
	public void add(Forest item) {
		sql.insert("forest.add", item);
	}

	@Override
	public Forest item(int forestId) {
		return sql.selectOne("forest.item", forestId);
	}

	@Override
	public void update(Forest item) {
		sql.update("forest.update", item);
	}

	@Override
	public void delete(int forestId) {
		sql.delete("forest.delete", forestId);
	}

	@Override
	public List<Forest> list_pager(Pager pager) {
		return sql.selectList("forest.list_pager", pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("forest.total", pager);
	}

	@Override
	public void insert_list(List<Forest> list) {
		sql.insert("forest.insert_list",list);
	}

	@Override
	public void delete_list(List<Forest> list) {
		sql.delete("forest.delete_list",list);		
	}

	@Override
	public void update_list(List<Forest> list) {
		sql.update("forest.update_list",list);		
	}

}
