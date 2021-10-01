package kr.co.gardener.admin.dao.object.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.CompanyDao;
import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.util.Pager;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	@Autowired
	SqlSession sql;
	
	@Override
	public List<Company> list(Pager pager) {
		return sql.selectList("company.list", pager);
	}

	@Override
	public void add(Company company) {
		sql.insert("company.add", company);
	}

	@Override
	public Company item(int companyId) {
		return sql.selectOne("company.item", companyId);
	}

	@Override
	public void update(Company item) {
		sql.update("company.update", item);
	}

	@Override
	public void delete(int companyId) {
		sql.delete("company.delete", companyId);
	}

	@Override
	public void update(List<Company> list) {
		sql.update("company.auto_update", list);
	}

	@Override
	public float total() {		
		return sql.selectOne("company.total");
	}

	@Override
	public List<Company> list() {
		return sql.selectList("company.listall");
	}

	@Override
	public Company productId(String productId) {
		return sql.selectOne("company.productId", productId);
	}
	

}
