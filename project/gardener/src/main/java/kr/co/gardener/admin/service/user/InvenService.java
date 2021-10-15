package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Inven;
import kr.co.gardener.admin.model.user.list.InvenList;
import kr.co.gardener.util.Pager;

public interface InvenService {

	List<Inven> list();

	void add(Inven item);

	Inven item(int invenId, int plantId);

	void update(Inven item);

	void delete(int invenId, int userId);

	List<Inven> list(String userId);

	InvenList list_pager(Pager pager);

	void insert_list(InvenList list);

	void delete_list(InvenList list);

	void update_list(InvenList list);

}
