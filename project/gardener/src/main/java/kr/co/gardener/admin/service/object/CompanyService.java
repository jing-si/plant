package kr.co.gardener.admin.service.object;

import java.util.HashMap;
import java.util.List;

import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.admin.model.object.list.CompanyList;
import kr.co.gardener.util.Pager;

public interface CompanyService {

	List<Company> list(Pager pager);

	Company search(String companyId);

	void autoUpdate(CompanyList list);

	List<Company> list();

	Company productId(String productId);

	CompanyList list_pager(Pager pager);

	void insert_list(CompanyList list);

	void delete_list(CompanyList list);

	void update_list(CompanyList list);

	boolean existCompany(Company company);

	Company itemIncludeProduct(HashMap<String, String> hm);

}
