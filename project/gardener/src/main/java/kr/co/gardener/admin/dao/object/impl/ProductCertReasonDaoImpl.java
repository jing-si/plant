package kr.co.gardener.admin.dao.object.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.ProductCertReasonDao;
import kr.co.gardener.admin.model.object.ProductCertReason;
import kr.co.gardener.util.Pager;

@Repository
public class ProductCertReasonDaoImpl implements ProductCertReasonDao{
	
	@Autowired
	SqlSession sql;
	
	@Override
	public void list(Pager pager) {
		sql.selectList("productCertReason.list_pager",pager);
	}

	@Override
	public void add(ProductCertReason item) {
		sql.insert("productCertReason.add", item);
	}

	@Override
	public void item(int productCertReasonId) {
		sql.selectOne("productCertReason.item", productCertReasonId);
	}

	@Override
	public void update(ProductCertReason item) {
		sql.update("productCertReason.update", item);
	}

	@Override
	public void delete(int productCertReasonId) {
		sql.delete("productCertReason.delete", productCertReasonId);
	}

	@Override
	public void checkAdd(ProductCertReason r) {
		sql.insert("productcertReason.bulkAdd", r);
	}

}
