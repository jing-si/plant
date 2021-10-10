package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Forest;

public interface ForestDao {

	List<Forest> list();

	void add(Forest item);

	Forest item(int forestId);

	void update(Forest item);

	void delete(int forestId);

}
