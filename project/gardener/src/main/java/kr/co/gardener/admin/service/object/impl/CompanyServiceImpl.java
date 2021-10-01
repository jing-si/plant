package kr.co.gardener.admin.service.object.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.CompanyDao;
import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.admin.service.object.CompanyService;
import kr.co.gardener.util.JsoupCrawler;
import kr.co.gardener.util.Pager;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyDao dao;
	
	@Override
	public List<Company> list(Pager pager) {
		pager.setTotal(dao.total());
		return dao.list(pager);
	}

	@Override
	public void add(Company company) {
		dao.add(company);
	}

	@Override
	public Company item(int companyId) {
		return dao.item(companyId);
	}

	@Override
	public void update(Company item) {
		dao.update(item);
	}

	@Override
	public void delete(int companyId) {
		dao.delete(companyId);
	}

	@Override	
	public Company search(String companyId) {
		JsoupCrawler jc = new JsoupCrawler();
		Map<String,String> map = jc.companySearch(companyId);
		Company company = new Company();
		company.setCompanyId(companyId);
		company.setCompanyName(map.get("사업자이름"));
		company.setCompanyTel(map.get("전화번호"));
		company.setCompanyAddress(map.get("회사주소"));
		company.setCompanyHomepage(map.get("홈페이지"));
		return company;
	}

	@Override
	public void autoUpdate(List<String> companyIds) {
		List<Company> list = new ArrayList<Company>();
		companyIds.forEach((data)->{
			System.out.print("companyID :" +data);
			Company company = search(data.replaceAll("-", ""));
			System.out.print(company.toString() + "\n");
			list.add(company);
		});
		
		dao.update(list);
	}

	@Override
	public List<Company> list() {
		return dao.list();
	}

	@Override
	public Company productId(String productId) {
		return dao.productId(productId);
	}
	
	
}
