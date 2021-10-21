package kr.co.gardener.admin.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.gardener.admin.dao.user.LocationDao;
import kr.co.gardener.admin.model.user.Inven;
import kr.co.gardener.admin.model.user.Location;
import kr.co.gardener.admin.model.user.list.BookmarkList;
import kr.co.gardener.admin.model.user.list.LocationList;
import kr.co.gardener.admin.service.user.InvenService;
import kr.co.gardener.admin.service.user.LocationService;
import kr.co.gardener.util.Pager;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationDao dao;
	
	@Autowired
	InvenService invenService;

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

	@Override
	public LocationList list_pager(Pager pager) {
		LocationList list = new LocationList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		pager.setTotal(dao.total(pager));
		list.paseComboList(dao.combo());
		return list;
	}

	@Override
	public void insert_list(LocationList list) {
		dao.insert_list(list.getList());

	}

	@Override
	public void delete_list(LocationList list) {
		dao.delete_list(list.getList());
	}

	@Override
	@Transactional
	public void update_list(LocationList list) {
		dao.update_list(list.getList());
	}

	@Override
	@Transactional
	public void save(LocationList list) {
		List<Location> nomalItem = new ArrayList<Location>();
		List<Location> newItem = new ArrayList<Location>();
		List<Location> deleteItem = new ArrayList<Location>();

		for (Location item : list.getList()) {
			switch (item.getLocationState()) {
			case 0:
				nomalItem.add(item);
				break;
			case 1:
				newItem.add(item);
				break;
			case 2:
				deleteItem.add(item);
				break;
			}
		}
		if (nomalItem.size() > 0)
			dao.update_list(nomalItem);

		if (newItem.size() > 0) {
			
			List<Inven> invenList = new ArrayList<Inven>();
			for (Location location : newItem) {
				Inven inven = new Inven();
				inven.setPlantId(location.getPlantId());
				inven.setUserId(location.getUserId());
				invenList.add(inven);
			}
			dao.insert_list(newItem);
			invenService.countDown_list(invenList);

		}

		if (deleteItem.size() > 0) {
			List<Inven> invenList = new ArrayList<Inven>();
			
			for (Location location : deleteItem) {
				Inven inven = new Inven();
				inven.setPlantId(location.getPlantId());
				inven.setUserId(location.getUserId());
				invenList.add(inven);
			}			
			dao.delete_list(deleteItem);
			invenService.countUp_list(invenList);
		}
		
	}

}
