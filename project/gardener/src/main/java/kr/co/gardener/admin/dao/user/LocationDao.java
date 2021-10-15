package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Location;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

public interface LocationDao {

	List<Location> list();

	void add(Location item);

	Location item(int locationId);

	void update(Location item);

	void delete(int locationId);

	List<Location> list(String userId);

	List<Location> list_pager(Pager pager);

	float total(Pager pager);

	List<ComboItem> combo();

	void insert_list(List<Location> list);

	void delete_list(List<Location> list);

	void update_list(List<Location> list);



}
