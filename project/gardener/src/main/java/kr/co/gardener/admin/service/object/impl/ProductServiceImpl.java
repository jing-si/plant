package kr.co.gardener.admin.service.object.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.ProductDao;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.service.object.ProductService;
import kr.co.gardener.util.Pager;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	@Override
	public void add(Product product) {
		dao.add(product);
	}

	@Override
	public Product item(int productId) {
		return dao.item(productId);
	}

	@Override
	public void update(Product item) {
		dao.update(item);
	}

	@Override
	public void delete(int productId) {
		dao.delete(productId);
	}

	@Override
	public List<Product> list(Pager pager) {		
		pager.setTotal(dao.total());
		return dao.list(pager);
	}

	@Override
	public List<Product> MidList(int midClassId) {
		return dao.list(midClassId);
	}

	@Override
	public List<Product> list(String search) {
		search = "%" + search.replaceAll(" ", "%") + "%";
		return dao.list(search);
	}

}
