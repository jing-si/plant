package kr.co.gardener.admin.service.object.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.ProductDao;
import kr.co.gardener.admin.dao.user.UserDao;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.list.ProductList;
import kr.co.gardener.admin.service.object.BotClassService;
import kr.co.gardener.admin.service.object.CertService;
import kr.co.gardener.admin.service.object.ProductService;
import kr.co.gardener.util.Pager;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;
	
	@Autowired
	CertService certService;
	
	@Autowired
	BotClassService botClassService; 
	
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
		pager.setTotal(dao.total(pager));
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

	@Override
	public ProductList list_pager(Pager pager) {
		ProductList item = new ProductList();
		item.setPager(pager);
		item.setList(dao.list(pager));
		item.paseComboList(dao.combo());
		pager.setTotal(dao.total(pager));
		return item;
	}

	@Override
	public void insert_list(ProductList list) {
		List<Product> items = list.getList();		
		dao.insert_list(items);
	}

	@Override
	public void delete_list(ProductList list) {
		dao.delete_list(list.getList());
	}

	@Override
	public void update_list(ProductList list) {
		dao.update_list(list.getList());
	}

	@Override
	public void autoUpdate(ProductList list) {
		List<Product> items = list.getList();
		for(Product item : items) {
			item.setElId(botClassService.searchBotClass(item.getProductInfo()));
		}
		dao.autoClassify(items);
	}

	@Override
	public String certify(int barcode) {
		/* String productId = dao.item(barcode).getProductId(); */
		int count = dao.count(barcode);
		if(count>0) {
			/* System.out.println(productId); */
			System.out.println(count);
			return "인증성공";
		}
		else {
			/* System.out.println(); */
			/* System.out.println(productId + " " + String.valueOf(barcode)); */
			System.out.println(barcode + " " + count);
			return "인증실패";
		}
	}

}
