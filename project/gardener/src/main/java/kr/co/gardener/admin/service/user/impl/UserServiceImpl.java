package kr.co.gardener.admin.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.UserDao;
import kr.co.gardener.admin.model.user.Notice;
import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.admin.model.user.list.UserList;
import kr.co.gardener.admin.service.user.UserService;
import kr.co.gardener.util.Pager;

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

	@Override
	public UserList list_pager(Pager pager) {
		UserList list = new UserList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		pager.setTotal(dao.total(pager));
		list.paseComboList(dao.combo());
		return list;
	}

	@Override
	public void insert_list(UserList list) {
		dao.insert_list(list.getList());
	}

	@Override
	public void delete_list(UserList list) {
		dao.delete_list(list.getList());
	}

	@Override
	public void update_list(UserList list) {
		dao.update_list(list.getList());
	}


}
