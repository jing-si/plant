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
	public List<Company> list() {
		return sql.selectList("company.listall");
	}

	@Override
	public Company productId(String productId) {
		return sql.selectOne("company.productId", productId);
	}

	@Override
	public void insert_list(List<Company> list) {
		sql.insert("company.insert_list", list);
	}

	@Override
	public void delete_list(List<Company> list) {
		sql.delete("company.delete_list", list);
	}

	@Override
	public void update_list(List<Company> list) {
		sql.update("company.update_list",list);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("company.total", pager);
	}

	@Override
	public Company item(String companyId) {
		return sql.selectOne("company.item",companyId);
	}

	@Override
	public void insert(Company item) {
		sql.update("company.insert",item);
	}
	

}
