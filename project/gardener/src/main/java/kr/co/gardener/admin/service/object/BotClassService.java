package kr.co.gardener.admin.service.object;

import kr.co.gardener.admin.model.object.list.BotClassList;
import kr.co.gardener.util.Pager;

public interface BotClassService {

	BotClassList list_pager(Pager pager);

	void insert(BotClassList list);

	void delete(BotClassList list);

	void update(BotClassList list);

	int searchBotClass(String productInfo);

}
