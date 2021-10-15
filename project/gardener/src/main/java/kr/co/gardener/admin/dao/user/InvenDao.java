package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Inven;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

public interface InvenDao {

	List<Inven> list();

	void add(Inven item);

	Inven item(int userId, int plantId);

	void update(Inven item);

	void delete(int userId, int plantId);

	List<Inven> list(String userId);

	List<Inven> list_pager(Pager pager);

	float total(Pager pager);

	List<ComboItem> combo();

	void insert_list(List<Inven> list);

	void delete_list(List<Inven> list);

	void update_list(List<Inven> list);

}
