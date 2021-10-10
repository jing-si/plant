package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Location;

public interface LocationService {

	List<Location> list();

	void add(Location item);

	Location item(int locationId);

	void update(Location item);

	void delete(int locationId);

	List<Location> list(String userId);


}
