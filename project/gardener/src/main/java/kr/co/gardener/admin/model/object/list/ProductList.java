package kr.co.gardener.admin.model.object.list;

import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.util.CommonList;

public class ProductList extends CommonList<Product> {

	public ProductList() {
		super("제품 관리");
		

		this.addTh("제품ID","productId","text");
		this.addTh("제품명","productName","text");
		this.addTh("사이즈","productSize","text");
		this.addTh("제품이미지","productImage","text");
		this.addTh("인증","certId","combo",0);
		this.addTh("제품인증번호","productCertId","text");
		this.addTh("인증 시작일","productStartDate","date");
		this.addTh("인증 만료일","productEndDate","date");
		this.addTh("사업자 번호","companyId","text");
		this.addTh("G2B ID","g2bId","number");
		this.addTh("분류번호(EL)","elId","combo",1);
		
		this.addInsert("제품ID","productId","text");
		this.addInsert("제품명","productName","text");
		this.addInsert("사이즈","productSize","text");
		this.addInsert("제품이미지","productImage","text");
		this.addInsert("인증","certId","combo",0);
		this.addInsert("제품인증번호","productCertId","text");
		this.addInsert("인증 시작일","productStartDate","date");
		this.addInsert("인증 만료일","productEndDate","date");
		this.addInsert("사업자 번호","companyId","text");
		this.addInsert("G2B ID","g2bId","number");
		this.addInsert("분류번호(EL)","elId","combo",1);
		
		setView(true);
		
	}

	
}