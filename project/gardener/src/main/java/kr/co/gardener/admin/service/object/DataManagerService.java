package kr.co.gardener.admin.service.object;

import java.util.List;

import kr.co.gardener.admin.model.object.ApiProduct;
import kr.co.gardener.admin.model.object.Company;
import kr.co.gardener.admin.model.object.list.ApiProductList;

public interface DataManagerService {

	List<Company> list(int start, int end);

	List<ApiProduct> productList(long companyId);

	List<ApiProduct> eProductList(long companyId);

	List<ApiProduct> productList(int start, int end);


	String UploadApiProduct(ApiProductList list);


}
