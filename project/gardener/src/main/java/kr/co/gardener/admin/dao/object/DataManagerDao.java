package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.ApiProduct;

public interface DataManagerDao {

	String list(int start, int end);

	String productList(long companyId);

	String eProductList(long companyId);

	String productList(int start, int end);

	String eproductList(int start, int end);

	void UploadApiProduct(List<ApiProduct> list);
	
	
}
