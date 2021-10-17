package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.BotClass;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

public interface BotClassDao {

	List<BotClass> list(Pager pager);

	float total(Pager pager);

	List<ComboItem> combo();

	void insert(List<BotClass> list);

	void delete(List<BotClass> list);

	void update(List<BotClass> list);

	List<BotClass> list();

}
