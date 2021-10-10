package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Inven;

public interface InvenService {

	List<Inven> list();

	void add(Inven item);

	Inven item(int invenId, int plantId);

	void update(Inven item);

	void delete(int invenId, int userId);

	List<Inven> list(String userId);

}
