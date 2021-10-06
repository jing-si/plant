package kr.co.gardener.admin.dao.object.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.CertDao;
import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.list.CertList;
import kr.co.gardener.util.Pager;

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

	@Override
	public void insert(List<Cert> list) {
		sql.insert("cert.insert_list", list);
	}

	@Override
	public void delete(List<Cert> list) {
		sql.delete("cert.delete_list", list);
	}

	@Override
	public void update(List<Cert> list) {
		sql.update("cert.update_list",list);
	}

	@Override
	public List<Cert> list(Pager pager) {
		return sql.selectList("cert.list_pager",pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("cert.total", pager);
	}

	
}
