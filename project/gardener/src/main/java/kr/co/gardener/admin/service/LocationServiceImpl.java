package kr.co.gardener.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.LocationDao;
import kr.co.gardener.admin.model.Location;
@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationDao dao;
	
	@Override
	public List<Location> list() {
		return dao.list();
	}

	@Override
	public void add(Location item) {
		dao.add(item);
	}

	@Override
	public Location item(int locationId) {
		return dao.item(locationId);
	}

	@Override
	public void update(Location item) {
		dao.update(item);
	}

	@Override
	public void delete(int locationId) {
		dao.delete(locationId);
	}

	@Override
	public List<Location> list(String userId) {
		return dao.list(userId);
	}

}
