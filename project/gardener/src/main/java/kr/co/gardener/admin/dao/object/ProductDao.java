package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.util.Pager;

public interface ProductDao {

	Product item(int productId);

	void add(Product product);

	void update(Product item);

	void delete(int productId);

	List<Product> list(Pager pager);

	float total();

	List<Product> list(int midClassId);

	List<Product> list(String search);

}
