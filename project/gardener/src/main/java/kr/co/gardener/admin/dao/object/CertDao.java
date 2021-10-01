package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.Cert;

public interface CertDao {

	List<Cert> list();

	Cert item(int certId);

	void update(Cert item);

	void delete(int certId);

	void add(Cert item);

}
