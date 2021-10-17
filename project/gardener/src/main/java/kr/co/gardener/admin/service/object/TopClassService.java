package kr.co.gardener.admin.service.object;

import java.util.List;

import kr.co.gardener.admin.model.object.list.TopClassList;
import kr.co.gardener.main.vo.TopClassVO;
import kr.co.gardener.util.Pager;

public interface TopClassService {

	void insert(TopClassList list);

	TopClassList list_pager(Pager pager);

	void delete(TopClassList list);

	void update(TopClassList list);

	List<TopClassVO> includMidClassList();

}
