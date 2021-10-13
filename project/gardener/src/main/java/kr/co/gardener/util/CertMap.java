package kr.co.gardener.util;

import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.CertReason;

public interface CertMap {

	Cert getCert(String value);

	CertReason getCertReason(String value);
	
	boolean reload(String value);	

}
