package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.History;

public interface HistoryService {

	List<History> list();

	void add(History item);

	History item(int historyId);

	void update(History item);

	void delete(int historyId);

}
