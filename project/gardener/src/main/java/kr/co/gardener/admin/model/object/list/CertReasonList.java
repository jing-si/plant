package kr.co.gardener.admin.model.object.list;

import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.util.CommonList;

public class CertReasonList extends CommonList<CertReason> {

	public CertReasonList() {
		super("인증 사유 관리");
		
		this.addTh("인증사유ID","certReasonId","none");
		this.addTh("인증명","certReasonName","text");
		this.addTh("인증마크","certReasonImage","file");
		this.addTh("인증내용","certReasonInfo","area");
		
		this.addInsert("인증ID","certReasonId","none");
		this.addInsert("인증명","certReasonName","text");
		this.addInsert("인증마크","certReasonImage","file");
		this.addInsert("인증내용","certReasonInfo","area");
	}

}
