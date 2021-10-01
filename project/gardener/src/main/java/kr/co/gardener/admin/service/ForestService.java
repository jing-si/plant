package kr.co.gardener.admin.service;

import java.util.List;

import kr.co.gardener.admin.model.Forest;

public interface ForestService {

	List<Forest> list();

	void add(Forest item);

	Forest item(int forestId);

	void update(Forest item);

	void delete(int forestId);

}
