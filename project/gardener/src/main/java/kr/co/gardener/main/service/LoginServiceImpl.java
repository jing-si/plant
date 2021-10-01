package kr.co.gardener.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.model.User;
import kr.co.gardener.main.dao.LoginDao;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao dao;
	
	@Override
	public User item(String userId) {
		return dao.item(userId);
	}

}
