package kr.co.gardener.admin.service.forest;

import java.util.List;

import kr.co.gardener.admin.model.forest.Forest;
import kr.co.gardener.admin.model.forest.list.ForestList;
import kr.co.gardener.util.Pager;

public interface ForestService {

	List<Forest> list();

	void add(Forest item);

	Forest item(int forestId);

	void update(Forest item);

	void delete(int forestId);

	ForestList list_pager(Pager pager);

	void insert_list(ForestList list);

	void delete_list(ForestList list);

	void update_list(ForestList list);

}
