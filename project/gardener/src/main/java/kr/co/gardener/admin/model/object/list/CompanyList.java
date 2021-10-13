package kr.co.gardener.admin.model.object.list;

import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.util.CommonList;

public class CompanyList extends CommonList<Company>{

	public CompanyList() {
		super("기업 관리");
		

		this.addTh("사업자 번호","companyId","none");
		this.addTh("회사명","companyName","text");
		this.addTh("전화번호","companyTel","text");
		this.addTh("주소","companyAddress","text");
		this.addTh("홈페이지","companyHomepage","text");
		
		this.addInsert("사업자 번호","companyId","text");
		this.addInsert("회사명","companyName","text");
		this.addInsert("전화번호","companyTel","text");
		this.addInsert("주소","companyAddress","text");
		this.addInsert("홈페이지","companyHomepage","text");
		
		setView(true);
	}

}
