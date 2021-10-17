package kr.co.gardener.admin.dao.other;

import java.util.List;

import kr.co.gardener.admin.model.other.State;
import kr.co.gardener.util.Pager;

public interface StateDao {

	List<State> list_pager(Pager pager);

	float total(Pager pager);

	void insert_list(List<State> list);

	void delete_list(List<State> list);

	void update_list(List<State> list);

}
