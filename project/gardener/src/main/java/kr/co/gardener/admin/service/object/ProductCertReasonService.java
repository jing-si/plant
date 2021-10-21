package kr.co.gardener.admin.service.object;

import java.util.List;

import kr.co.gardener.admin.model.object.Product;
import kr.co.gardener.admin.model.object.ProductCertReason;
import kr.co.gardener.admin.model.object.list.ProductCertReasonList;
import kr.co.gardener.util.Pager;

public interface ProductCertReasonService {

	void list(Pager pager);

	void add(ProductCertReason item);

	void item(int productCertReasonId);

	void update(ProductCertReason item);

	void delete(int productCertReasonId);

	ProductCertReasonList list_pager(Pager pager);

	void insert(ProductCertReasonList list);

	void delete(ProductCertReasonList list);

	void update(ProductCertReasonList list);

	<T extends Product> String autoInsertProductCertReason(List<T> list);

}
