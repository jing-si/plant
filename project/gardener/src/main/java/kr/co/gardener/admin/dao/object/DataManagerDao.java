package kr.co.gardener.admin.dao.object;

public interface DataManagerDao {

	String list(int start, int end);

	String productList(long companyId);

	String eProductList(long companyId);

	String productList(int start, int end);

	String eproductList(int start, int end);
	
	
}
