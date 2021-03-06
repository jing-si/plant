package kr.co.gardener.admin.dao.object;

import java.util.HashMap;
import java.util.List;

import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.main.vo.BrandVO;
import kr.co.gardener.util.Pager;

public interface CompanyDao {

	List<Company> list(Pager pager);

	List<Company> list();

	Company productId(String productId);

	void insert_list(List<Company> list);

	void delete_list(List<Company> list);

	void update_list(List<Company> list);

	float total(Pager pager);

	Company item(String companyId);

	void insert(Company item);

	Company itemIncludeProduct(HashMap<String, String> hm);

	List<BrandVO> brandList();

	List<Company> listIncludeCount();

}
