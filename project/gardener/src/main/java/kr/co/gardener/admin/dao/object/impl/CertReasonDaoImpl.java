package kr.co.gardener.admin.dao.object.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.CertReasonDao;
import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.util.Pager;

@Repository
public class CertReasonDaoImpl implements CertReasonDao{

	@Autowired
	SqlSession sql;
	
	@Override
	public List<CertReason> list() {
		return sql.selectList("certReason.list");
	}

	@Override
	public void add(CertReason item) {
		sql.insert("certReason.add", item);
	}

	@Override
	public CertReason item(int certReasonId) {
		return sql.selectOne("certReason.item", certReasonId);
	}

	@Override
	public void update(CertReason item) {
		sql.update("certReason.update", item);
	}

	@Override
	public void delete(int certReasonId) {
		sql.delete("certReason.delete",certReasonId);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("certReason.total", pager);
	}

	@Override
	public List<CertReason> list(Pager pager) {
		return sql.selectList("certReason.list_pager", pager);
	}

	@Override
	public void insert(List<CertReason> list) {
		sql.insert("certReason.insert_list", list);
	}

	@Override
	public void delete(List<CertReason> list) {
		sql.delete("certReason.delete_list", list);
	}

	@Override
	public void update(List<CertReason> list) {
		sql.update("certReason.update_list", list);
	}


}
