package kr.co.gardener.admin.model.object.list;

import kr.co.gardener.admin.model.object.ProductCertReason;
import kr.co.gardener.util.CommonList;

public class ProductCertReasonList extends CommonList<ProductCertReason> {

	public ProductCertReasonList() {
		super("제품 인증 사유 관리");
		
		this.addTh("제품 인증 사유 ID","productCertReasonId","none");
		this.addTh("제 품","productId","none");
		this.addTh("인증 사유 ","certReasonId","combo",1);
		
		this.addInsert("제품 인증 사유 ID","productCertReasonId","none");
		this.addInsert("제 품","productId","combo",0);
		this.addInsert("인증 사유 ","certReasonId","combo",1);
		
		
	}

}
