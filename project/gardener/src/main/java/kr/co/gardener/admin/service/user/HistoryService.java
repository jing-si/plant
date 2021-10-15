package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.History;
import kr.co.gardener.admin.model.user.list.BookmarkList;
import kr.co.gardener.admin.model.user.list.HistoryList;
import kr.co.gardener.util.Pager;

public interface HistoryService {

	List<History> list();

	void add(History item);

	History item(int historyId);

	void update(History item);

	void delete(int historyId);

	HistoryList list_pager(Pager pager);

	void insert_list(HistoryList list);

	void delete_list(HistoryList list);

	void update_list(HistoryList list);


}
