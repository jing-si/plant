package kr.co.gardener.admin.service.object;

import java.util.List;

import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.util.Pager;

public interface ProductService {

	void add(Product product);

	Product item(int productId);

	void update(Product item);

	void delete(int productId);

	List<Product> list(Pager pager);

	List<Product> MidList(int midClassId);

	List<Product> list(String search);

}
