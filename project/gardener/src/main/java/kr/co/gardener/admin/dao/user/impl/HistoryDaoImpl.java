package kr.co.gardener.admin.dao.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.user.HistoryDao;
import kr.co.gardener.admin.model.user.History;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;
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

	@Override
	public List<History> list_pager(Pager pager) {
		return sql.selectList("history.list_pager", pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("history.total");
	}

	@Override
	public List<ComboItem> combo() {
		return sql.selectList("history.combo");
	}

	@Override
	public void insert_list(List<History> list) {
		sql.insert("history.insert_list", list);
	}

	@Override
	public void delete_list(List<History> list) {
		sql.insert("history.delete_list", list);		
	}

	@Override
	public void update_list(List<History> list) {
		sql.insert("history.update_list", list);		
	}

}
