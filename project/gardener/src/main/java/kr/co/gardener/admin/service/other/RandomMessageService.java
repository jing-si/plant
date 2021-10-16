package kr.co.gardener.admin.service.other;

import kr.co.gardener.admin.model.other.list.RandomMessageList;
import kr.co.gardener.util.Pager;

public interface RandomMessageService {

	RandomMessageList list_pager(Pager pager);

	void insert_list(RandomMessageList list);

	void delete_list(RandomMessageList list);

	void update_list(RandomMessageList list);

}
