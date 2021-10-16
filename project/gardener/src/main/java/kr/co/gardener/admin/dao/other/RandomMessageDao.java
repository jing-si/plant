package kr.co.gardener.admin.dao.other;

import java.util.List;

import kr.co.gardener.admin.model.other.RandomMessage;
import kr.co.gardener.util.Pager;

public interface RandomMessageDao {

	List<RandomMessage> list_pager(Pager pager);

	float total(Pager pager);

	void insert_list(List<RandomMessage> list);

	void delete_list(List<RandomMessage> list);

	void update_list(List<RandomMessage> list);

}
