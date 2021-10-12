package kr.co.gardener.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.UserDao;
import kr.co.gardener.admin.model.user.Notice;
import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.admin.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;
	
	@Override
	public List<User> list() {
		return dao.list();
	}

	@Override
	public void add(User item) {
		dao.add(item);
	}

	@Override
	public User item(String userId) {
		return dao.item(userId);
	}

	@Override
	public void update(User item) {
		dao.update(item);
	}

	@Override
	public void delete(String userId) {
		dao.delete(userId);
	}

	@Override
	public String imgSrc(User user) {
		return dao.imgSrc(user);
	}

	@Override
	public List<Notice> notice() {
		return dao.notice();
	}

	@Override
	public boolean duplication(String id) {
		
		if(dao.duplication(id)>0) {
			System.out.println(dao.duplication(id));
			return false;
		}else {
			System.out.println(dao.duplication(id));
			return true;
		}
		
		/* return dao.duplication(id); */
	}


}
