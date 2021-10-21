package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.util.Pager;

public interface CertReasonDao {

	List<CertReason> list();

	void add(CertReason item);

	CertReason item(int certReasonId);

	void update(CertReason item);

	void delete(int certReasonId);

	float total(Pager pager);

	List<CertReason> list(Pager pager);

	void insert(List<CertReason> list);

	void delete(List<CertReason> list);

	void update(List<CertReason> list);

	

}
