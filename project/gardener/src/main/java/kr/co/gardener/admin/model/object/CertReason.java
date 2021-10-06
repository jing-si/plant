package kr.co.gardener.admin.model.object;

import kr.co.gardener.util.GridSystem;

public class CertReason extends GridSystem {
	private int certReasonId;
	private String certReasonName;
	private String certReasonImage;
	private String certReasonInfo;
	
	
	public int getCertReasonId() {
		return certReasonId;
	}
	public void setCertReasonId(int certReasonId) {
		this.certReasonId = certReasonId;
	}
	public String getCertReasonName() {
		return certReasonName;
	}
	public void setCertReasonName(String certReasonName) {
		this.certReasonName = certReasonName;
	}
	public String getCertReasonImage() {
		return certReasonImage;
	}
	public void setCertReasonImage(String certReasonImage) {
		this.certReasonImage = certReasonImage;
	}
	public String getCertReasonInfo() {
		return certReasonInfo;
	}
	public void setCertReasonInfo(String certReasonInfo) {
		this.certReasonInfo = certReasonInfo;
	}
	
	
	
}
