package kr.co.gardener.admin.service.forest;

import java.util.List;

import kr.co.gardener.admin.model.forest.Forest;

public interface ForestService {

	List<Forest> list();

	void add(Forest item);

	Forest item(int forestId);

	void update(Forest item);

	void delete(int forestId);

}
