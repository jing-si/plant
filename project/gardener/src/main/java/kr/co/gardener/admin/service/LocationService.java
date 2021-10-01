package kr.co.gardener.admin.service;

import java.util.List;

import kr.co.gardener.admin.model.Location;

public interface LocationService {

	List<Location> list();

	void add(Location item);

	Location item(int locationId);

	void update(Location item);

	void delete(int locationId);

	List<Location> list(String userId);


}
