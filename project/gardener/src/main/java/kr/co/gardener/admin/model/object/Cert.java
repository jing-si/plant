package kr.co.gardener.admin.model.object;

import kr.co.gardener.util.GridSystem;

public class Cert extends GridSystem{
	private int certId;
	private String certName;
	private String certImage;
	private String certInfo;
	
	public int getCertId() {
		return certId;
	}
	public void setCertId(int certId) {
		this.certId = certId;
	}
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
	public String getCertImage() {
		return certImage;
	}
	public void setCertImage(String certImage) {
		this.certImage = certImage;
	}
	public String getCertInfo() {
		return certInfo;
	}
	public void setCertInfo(String certInfo) {
		this.certInfo = certInfo;
	}
	
	@Override
	public String toString() {
		return "Cert [certId=" + certId + ", certName=" + certName + ", certImage=" + certImage + ", certInfo="
				+ certInfo + "]";
	}
	
	
}
