package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.util.Pager;

public interface CompanyDao {

	List<Company> list(Pager pager);

	void add(Company company);

	Company item(int companyId);

	void update(Company item);

	void delete(int companyId);

	void update(List<Company> list);

	float total();

	List<Company> list();

	Company productId(String productId);

}
