package kr.co.gardener.admin.dao;

import java.util.List;

import kr.co.gardener.admin.model.History;

public interface HistoryDao {

	List<History> list();

	void add(History item);

	History item(int historyId);

	void update(History item);

	void delete(int historyId);

}
