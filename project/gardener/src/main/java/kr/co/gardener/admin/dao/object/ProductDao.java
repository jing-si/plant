package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.list.ProductList;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

public interface ProductDao {

	Product item(int productId);

	void add(Product product);

	void update(Product item);

	void delete(int productId);

	List<Product> list(Pager pager);

	List<Product> list(int midClassId);

	List<Product> list(String search);

	void insert_list(List<Product> list);

	void delete_list(List<Product> list);

	void update_list(List<Product> list);

	float total(Pager pager);

	List<ComboItem> combo();

}
