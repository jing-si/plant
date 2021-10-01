package kr.co.gardener.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.model.History;
@Repository
public class HistoryDaoImpl implements HistoryDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<History> list() {
		return sql.selectList("history.list");
	}

	@Override
	public void add(History item) {
		sql.insert("history.add", item);
	}

	@Override
	public History item(int historyId) {
		return sql.selectOne("history.item", historyId);
	}

	@Override
	public void update(History item) {
		sql.update("history.update", item);
	}

	@Override
	public void delete(int historyId) {
		sql.delete("history.delete", historyId);
	}

}
