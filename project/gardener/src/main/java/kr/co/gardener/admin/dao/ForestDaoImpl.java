package kr.co.gardener.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.model.Forest;
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

}
