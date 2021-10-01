package kr.co.gardener.admin.dao.object.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.CertReasonDao;
import kr.co.gardener.admin.model.object.CertReason;

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

}
