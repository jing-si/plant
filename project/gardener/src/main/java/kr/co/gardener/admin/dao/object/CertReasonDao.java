package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.CertReason;

public interface CertReasonDao {

	List<CertReason> list();

	void add(CertReason item);

	CertReason item(int certReasonId);

	void update(CertReason item);

	void delete(int certReasonId);
	

}
