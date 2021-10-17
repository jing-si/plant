package kr.co.gardener.admin.dao.object;

import java.util.List;

import kr.co.gardener.admin.model.object.TopClass;
import kr.co.gardener.admin.model.object.list.TopClassList;
import kr.co.gardener.main.vo.TopClassVO;
import kr.co.gardener.util.Pager;

public interface TopClassDao {

	void insert(List<TopClass> list);

	List<TopClass> list(Pager pager);

	void delete(List<TopClass> list);

	void update(List<TopClass> list);

	float total(Pager pager);

	List<TopClassVO> includMidClassList();

}
