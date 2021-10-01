package kr.co.gardener.admin.dao.object.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.CertDao;
import kr.co.gardener.admin.model.object.Cert;

@Repository
public class CertDaoImpl implements CertDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Cert> list() {
		return sql.selectList("cert.list");
	}

	@Override
	public Cert item(int certId) {
		return sql.selectOne("cert.item",certId);
	}

	@Override
	public void update(Cert item) {
		sql.update("cert.update",item);
	}

	@Override
	public void delete(int certId) {
		sql.delete("cert.delete", certId);
	}

	@Override
	public void add(Cert item) {
		sql.insert("cert.add",item);
	}

}
