package kr.co.gardener.admin.dao.other.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.other.RandomMessageDao;
import kr.co.gardener.admin.model.other.RandomMessage;
import kr.co.gardener.util.Pager;

@Repository
public class RandomMessageDaoImpl implements RandomMessageDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<RandomMessage> list_pager(Pager pager) {
		return sql.selectList("randomMessage.list_pager",pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("randomMessage.total", pager);
	}

	@Override
	public void insert_list(List<RandomMessage> list) {
		sql.insert("randomMessage.insert_list", list);
	}

	@Override
	public void delete_list(List<RandomMessage> list) {
		sql.delete("randomMessage.delete_list", list);

	}

	@Override
	public void update_list(List<RandomMessage> list) {
		sql.update("randomMessage.update_list", list);
	}

	@Override
	public String item(Integer stateId) {
		return sql.selectOne("randomMessage.item", stateId);
	}

}
