package kr.co.gardener.admin.dao;

import java.util.List;

import kr.co.gardener.admin.model.Inven;

public interface InvenDao {

	List<Inven> list();

	void add(Inven item);

	Inven item(int userId, int plantId);

	void update(Inven item);

	void delete(int userId, int plantId);

	List<Inven> list(String userId);

}
