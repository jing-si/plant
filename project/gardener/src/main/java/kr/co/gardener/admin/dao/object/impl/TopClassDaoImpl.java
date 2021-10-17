package kr.co.gardener.admin.dao.object.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.TopClassDao;
import kr.co.gardener.admin.model.object.TopClass;
import kr.co.gardener.main.vo.TopClassVO;
import kr.co.gardener.util.Pager;

@Repository
public class TopClassDaoImpl implements TopClassDao {

	@Autowired
	SqlSession sql;
	
	
	@Override
	public void insert(List<TopClass> list) {
		sql.insert("topclass.insert_list", list);
	}

	@Override
	public List<TopClass> list(Pager pager) {
		return sql.selectList("topclass.list_pager", pager);
	}

	@Override
	public void delete(List<TopClass> list) {
		sql.delete("topclass.delete_list", list);
	}

	@Override
	public void update(List<TopClass> list) {
		sql.update("topclass.update_list", list);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("topclass.total", pager);
	}

	@Override
	public List<TopClassVO> includMidClassList() {
		return sql.selectList("topclass.includMidClassList");
	}

}
