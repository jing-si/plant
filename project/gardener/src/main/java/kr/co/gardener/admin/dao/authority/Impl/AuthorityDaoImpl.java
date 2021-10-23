package kr.co.gardener.admin.dao.authority.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.authority.AuthorityDao;
import kr.co.gardener.admin.model.authority.AdminDTO;
import kr.co.gardener.admin.model.authority.Authority;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Authority> list_pager(Pager pager) {
		return sql.selectList("authority.list_pager",pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("authority.total",pager);
	}

	@Override
	public List<ComboItem> combo() {
		return sql.selectList("authority.combo");
	}

	@Override
	public void insert_list(List<Authority> list) {
		sql.insert("authority.insert_list", list);
	}

	@Override
	public void delete_list(List<Authority> list) {
		sql.insert("authority.delete_list", list);

	}

	@Override
	public void update_list(List<Authority> list) {
		sql.insert("authority.update_list", list);

	}

	@Override
	public Authority login(AdminDTO item) {
		return sql.selectOne("authority.login",item);
	}

}
