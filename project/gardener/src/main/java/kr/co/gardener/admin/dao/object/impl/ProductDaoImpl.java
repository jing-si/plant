package kr.co.gardener.admin.dao.object.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.object.ProductDao;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.list.ProductList;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public Product item(int productId) {
		return sql.selectOne("product.item", productId);
	}

	@Override
	public void add(Product product) {
		sql.insert("product.add", product);
	}

	@Override
	public void update(Product item) {
		sql.update("product.update", item);
	}

	@Override
	public void delete(int productId) {
		sql.delete("product.delete", productId);
	}

	@Override
	public List<Product> list(Pager pager) {
		return sql.selectList("product.list_pager", pager);
	}
	@Override
	public float total(Pager pager) {		
		return sql.selectOne("product.total",pager);
	}

	@Override
	public List<Product> list(int midClassId) {
		return sql.selectList("product.list_mid", midClassId);
	}
	
	@Override
	public List<Product> list(String search) {
		return sql.selectList("product.list_search",search);
	}

	
	@Override
	public void insert_list(List<Product> list) {
		sql.insert("product.insert_list",list);
	}

	@Override
	public void delete_list(List<Product> list) {
		sql.delete("product.delete_list", list);
	}

	@Override
	public void update_list(List<Product> list) {
		sql.update("product.update_list",list);
	}

	@Override
	public List<ComboItem> combo() {
		return sql.selectList("product.combo");
	}

	@Override
	public void autoClassify(List<Product> items) {
		sql.update("product.autoClassify",items);
	}

	@Override
	public int count(int barcode) {
		return sql.selectOne("product.count", barcode);
	}

}
