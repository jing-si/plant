package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.list.CertList;
import kr.co.gardener.util.Pager;

public interface CertDao {

	List<Cert> list();

	Cert item(int certId);

	void update(Cert item);

	void delete(int certId);

	void add(Cert item);

		void insert(List<Cert> list);

	void delete(List<Cert> list);

	void update(List<Cert> list);

	List<Cert> list(Pager pager);

	float total(Pager pager);

}
