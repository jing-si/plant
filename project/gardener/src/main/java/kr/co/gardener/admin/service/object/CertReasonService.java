package kr.co.gardener.admin.service.object;

import java.util.List;
import java.util.Map;

import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.list.CertReasonList;
import kr.co.gardener.util.Pager;

public interface CertReasonService {

	List<CertReason> list();

	void add(CertReason item);

	CertReason item(int certReasonId);

	void update(CertReason item);

	void delete(int certReasonId);

	Map<String, Integer> listMap();

	CertReasonList list(Pager pager);

	void insert(CertReasonList list);

	void delete(CertReasonList list);

	void update(CertReasonList list);

	CertReason getCertReasonItem(String value);

	void fillProduct(Product item);

}
