package kr.co.gardener.admin.service;

import java.util.List;

import kr.co.gardener.admin.model.History;

public interface HistoryService {

	List<History> list();

	void add(History item);

	History item(int historyId);

	void update(History item);

	void delete(int historyId);

}
