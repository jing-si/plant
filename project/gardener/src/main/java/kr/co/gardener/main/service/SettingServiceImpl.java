package kr.co.gardener.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.model.User;
import kr.co.gardener.main.dao.SettingDao;
@Service
public class SettingServiceImpl implements SettingService {

	@Autowired
	SettingDao dao;
	
	@Override
	public void out(User item) {
		dao.out(item);
	}

}
