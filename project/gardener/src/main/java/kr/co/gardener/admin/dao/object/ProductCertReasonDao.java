package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.ProductCertReason;
import kr.co.gardener.util.Pager;

public interface ProductCertReasonDao {

	void list(Pager pager);

	void add(ProductCertReason item);

	void item(int productCertReasonId);

	void update(ProductCertReason item);

	void delete(int productCertReasonId);

	void checkAdd(ProductCertReason r);

}
