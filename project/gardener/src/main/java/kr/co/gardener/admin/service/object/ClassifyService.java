package kr.co.gardener.admin.service.object;

import java.util.List;

import kr.co.gardener.admin.model.object.Classify;
import kr.co.gardener.admin.model.object.ClassifyList;
import kr.co.gardener.admin.model.object.productCategoryList;

public interface ClassifyService {

	ClassifyList getList();

	void topAdd(Classify item);

	void midAdd(Classify item);

	void botAdd(Classify item);

	void topUpdate(Classify item);

	void midUpdate(Classify item);

	void botUpdate(Classify item);

	void topDelete(int primaryId);

	void midDelete(int primaryId);

	void botDelete(int primaryId);

	List<productCategoryList> productCategoryList();

	

}
