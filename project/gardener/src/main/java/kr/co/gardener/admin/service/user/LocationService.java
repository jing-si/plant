package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Location;
import kr.co.gardener.admin.model.user.list.LocationList;
import kr.co.gardener.util.Pager;

public interface LocationService {

	List<Location> list();

	void add(Location item);

	Location item(int locationId);

	void update(Location item);

	void delete(int locationId);

	List<Location> list(String userId);

	LocationList list_pager(Pager pager);

	void insert_list(LocationList list);

	void delete_list(LocationList list);

	void update_list(LocationList list);


}
