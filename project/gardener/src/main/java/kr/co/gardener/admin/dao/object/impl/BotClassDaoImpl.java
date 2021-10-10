package kr.co.gardener.admin.dao.object.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.BotClassDao;
import kr.co.gardener.admin.model.object.BotClass;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

@Repository
public class BotClassDaoImpl implements BotClassDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<BotClass> list(Pager pager) {
		return sql.selectList("botclass.list_pager", pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("botclass.total", pager);
	}

	@Override
	public List<ComboItem> combo() {
		return sql.selectList("botclass.combo");
	}

	@Override
	public void insert(List<BotClass> list) {
		sql.insert("botclass.insert_list", list);
	}

	@Override
	public void delete(List<BotClass> list) {
		sql.delete("botclass.delete_list", list);
	}

	@Override
	public void update(List<BotClass> list) {
		sql.update("botclass.update_list", list);
	}

}
