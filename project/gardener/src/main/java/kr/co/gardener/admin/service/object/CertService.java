package kr.co.gardener.admin.service.object;

import java.util.List;
import java.util.Map;

import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.list.CertList;
import kr.co.gardener.util.Pager;

public interface CertService {

	List<Cert> list();

	Cert item(int certId);

	void update(Cert item);

	void delete(int certId);

	void add(Cert item);

	Map<String, Integer> listMap();

	CertList list(Pager pager);

	void insert(CertList list);

	void delete(CertList list);

	void update(CertList list);

}
