package kr.co.gardener.admin.model.object.list;

import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.util.CommonList;

public class CertList extends CommonList<Cert>{

	public CertList() {
		super("인증 관리");

		this.addTh("인증ID","certId","none");
		this.addTh("인증명","certName","text");
		this.addTh("인증마크","certImage","file");
		this.addTh("인증내용","certInfo","area");
		
		this.addInsert("인증ID","certId","none");
		this.addInsert("인증명","certName","text");
		this.addInsert("인증마크","certImage","file");
		this.addInsert("인증내용","certInfo","area");
		
	}

}
