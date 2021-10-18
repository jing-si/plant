package kr.co.gardener.admin.dao.object.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.MidClassDao;
import kr.co.gardener.admin.model.object.MidClass;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

@Repository
public class MidClassDaoImpl implements MidClassDao{

	
	@Autowired
	SqlSession sql;

	@Override
	public List<MidClass> list(Pager pager) {
		return sql.selectList("midclass.list_pager", pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("midclass.total", pager);
	}

	@Override
	public List<ComboItem> combo() {
		return sql.selectList("midclass.combo");
	}

	@Override
	public void insert(List<MidClass> list) {
		sql.insert("midclass.insert_list", list);
	}

	@Override
	public void delete(List<MidClass> list) {
		sql.delete("midclass.delete_list",list);
	}

	@Override
	public void update(List<MidClass> list) {
		sql.update("midclass.update_list",list);
	}

	@Override
	public String item(int midClassId) {
		return sql.selectOne("midclass.item", midClassId);
	}
	
	
}
