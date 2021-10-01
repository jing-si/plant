package kr.co.gardener.admin.service.object;

import java.util.List;

import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.util.Pager;

public interface CompanyService {

	List<Company> list(Pager pager);

	void add(Company company);

	Company item(int companyId);

	void update(Company item);

	void delete(int companyId);

	Company search(String companyId);

	void autoUpdate(List<String> companyIds);

	List<Company> list();

	Company productId(String productId);

}
