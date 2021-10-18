package kr.co.gardener.admin.service.object;

import kr.co.gardener.admin.model.object.list.MidClassList;
import kr.co.gardener.util.Pager;

public interface MidClassService {

	MidClassList list_pager(Pager pager);

	void insert(MidClassList list);

	void delete(MidClassList list);

	void update(MidClassList list);

	String item(int midClassId);

}
