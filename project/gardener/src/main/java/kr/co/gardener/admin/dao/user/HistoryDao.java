package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.user.History;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

public interface HistoryDao {

	List<History> list();

	void add(History item);

	History item(int historyId);

	void update(History item);

	void delete(int historyId);

	List<History> list_pager(Pager pager);

	float total(Pager pager);

	List<ComboItem> combo();

	void insert_list(List<History> list);

	void delete_list(List<History> list);

	void update_list(List<History> list);

}
