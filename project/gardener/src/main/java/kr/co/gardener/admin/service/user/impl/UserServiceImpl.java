package kr.co.gardener.admin.service.user.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.user.UserDao;
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
		item.setUserPass(encryption(item));
		dao.add(item);
	}

	@Override
	public User item(User item) {
		item.setUserPass(encryption(item));
		return dao.item_checkPass(item);
	}

	@Override
	public void update(User item) {
		item.setUserPass(encryption(item));
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

		if (dao.duplication(id) > 0) {
			System.out.println(dao.duplication(id));
			return false;
		} else {
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
	public void insert_list(UserList item) {
		List<User> list = item.getList();
		for (User user : list) {
			user.setUserPass(encryption(user));
		}

		dao.insert_list(list);
	}

	@Override
	public void delete_list(UserList list) {
		dao.delete_list(list.getList());
	}

	@Override
	public void update_list(UserList item) {
		List<User> nowlist = item.getList();
		List<User> prelist = dao.getUpdatePreList(nowlist);
		
		for (User preUser : prelist) {
			for(User nowUser : nowlist ) {
				if(preUser.getUserId().equals(nowUser.getUserId())) {
					
					if(preUser.checkUpdate(nowUser))
						preUser.setUserPass(encryption(preUser));
					
					nowlist.remove(nowUser);
					break;
				}
			}
			
			System.out.println(preUser);
		}

		dao.update_list(prelist);
	}

	private String encryption(User user) {
		if (user == null || user.getUserPass() == null || user.getUserBirth() == null) {
			return null;
		}

		
		/*
		 * if (user.getUserBirth() == null) { user.setUserBirth();
		 * 
		 * }
		 */
		 

		byte[] salt1Value = null; // salt??? ?????? ?????? ?????????
		byte[] salt2Value = null; // salt??? ?????? ?????? ?????????
		byte[] hashValue = null; // ?????????

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			int salt = 870528 * Integer.valueOf(user.getUserId().charAt(0))+ Integer.valueOf(user.getUserId().charAt(0));

			salt1Value = md.digest(String.valueOf(salt).getBytes());
			salt2Value = md.digest(user.getUserId().getBytes());
			md.reset();
			md.update(ArrayUtils.addAll(salt1Value, salt2Value));

			hashValue = md.digest(user.getUserPass().getBytes());
			hashValue = md.digest(hashValue);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(new String(Base64.encodeBase64(hashValue)));

		return new String(Base64.encodeBase64(hashValue));
	}

	@Override
	public User login(User item) {
		User user = dao.item(item);
		if (user != null) {			
			item.setUserBirth(user.getUserBirth());
			if (user.getUserPass().equals(encryption(item))) {
				user.setUserPass(null);
				System.out.println("????????? ??????");
				return user;
			}
		}
		System.out.println("????????? ??????");
		return null;
	}

	@Override
	public void levelUp(User user) {
		dao.levelUp(user);

	}

	@Override
	public int count(User user) {
		return dao.count(user);
	}

}
