package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.MidClass;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

public interface MidClassDao {

	List<MidClass> list(Pager pager);

	float total(Pager pager);

	List<ComboItem> combo();

	void insert(List<MidClass> list);

	void delete(List<MidClass> list);

	void update(List<MidClass> list);

	String item(int midClassId);

}
