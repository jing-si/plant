package kr.co.gardener.admin.dao.other.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.other.StateDao;
import kr.co.gardener.admin.model.other.State;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

@Repository
public class StateDaoImpl implements StateDao{

	@Autowired
	SqlSession sql;
	
	@Override
	public List<State> list_pager(Pager pager) {
		return sql.selectList("state.list_pager", pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("state.total", pager);
	}

	@Override
	public void insert_list(List<State> list) {
		sql.insert("state.insert_list", list);
	}

	@Override
	public void delete_list(List<State> list) {
		sql.delete("state.delete_list", list);		
	}

	@Override
	public void update_list(List<State> list) {
		sql.update("state.update_list", list);		
	}

}
