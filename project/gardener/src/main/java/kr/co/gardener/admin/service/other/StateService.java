package kr.co.gardener.admin.service.other;

import kr.co.gardener.admin.model.other.list.StateList;
import kr.co.gardener.util.Pager;

public interface StateService {

	StateList list_pager(Pager pager);

	void insert_list(StateList list);

	void delete_list(StateList list);

	void update_list(StateList list);

}
