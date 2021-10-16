package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.forest.Forest;
import kr.co.gardener.util.Pager;

public interface ForestDao {

	List<Forest> list();

	void add(Forest item);

	Forest item(int forestId);

	void update(Forest item);

	void delete(int forestId);

	List<Forest> list_pager(Pager pager);

	float total(Pager pager);

	void insert_list(List<Forest> list);

	void delete_list(List<Forest> list);

	void update_list(List<Forest> list);

}
