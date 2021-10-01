package kr.co.gardener.admin.service.object;

import java.util.List;
import java.util.Map;

import kr.co.gardener.admin.model.object.CertReason;

public interface CertReasonService {

	List<CertReason> list();

	void add(CertReason item);

	CertReason item(int certReasonId);

	void update(CertReason item);

	void delete(int certReasonId);

	Map<String, Integer> listMap();

}
