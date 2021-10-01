package kr.co.gardener.admin.dao.object.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.ClassifyDao;
import kr.co.gardener.admin.model.object.Classify;

@Repository
public class ClassifyDaoImpl implements ClassifyDao {

	@Autowired
	private SqlSession sql;

	@Override
	public List<Classify> getList() {
		
		return sql.selectList("classify.list");
	}

	@Override
	public void topAdd(Classify item) {
		sql.insert("classify.topAdd", item);
	}

	@Override
	public void midAdd(Classify item) {
		sql.insert("classify.midAdd", item);
		
	}

	@Override
	public void botAdd(Classify item) {
		sql.insert("classify.botAdd", item);
		
	}

	@Override
	public void topUpdate(Classify item) {
		sql.update("classify.topUpdate", item);
	}

	@Override
	public void midUpdate(Classify item) {
		sql.update("classify.midUpdate", item);		
	}

	@Override
	public void botUpdate(Classify item) {
		sql.update("classify.botUpdate", item);		
	}

	@Override
	public void topDelete(int primaryId) {
		sql.delete("classify.topDelete", primaryId);
	}

	@Override
	public void midDelete(int primaryId) {
		sql.delete("classify.midDelete", primaryId);
	}

	@Override
	public void botDelete(int primaryId) {
		sql.delete("classify.botDelete", primaryId);
	}

	@Override
	public List<kr.co.gardener.admin.model.object.productCategoryList> productCategoryList() {
		
		return sql.selectList("classify.category");
	}

}
