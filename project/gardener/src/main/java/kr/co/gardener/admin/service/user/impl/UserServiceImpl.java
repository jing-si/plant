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
	public void insert_list(UserList item) {
		List<User> list = item.getList();
		for(User user : list) {
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
		List<User> list = item.getList();
		for(User user : list) {
			user.setUserPass(encryption(user));
		}
		
		dao.update_list(list);
	}

	private String encryption(User user) {
		if (user == null) {
		    return null;
		}
		
		if(user.getUserBirth() == null) {
			user.setUserBirth(null);
		}
		
		byte[] salt1Value = null; //salt를 위한 임시 데이터
		byte[] salt2Value = null; //salt를 위한 임시 데이터
		byte[] hashValue = null; // 해쉬값
		
		try {
			
			
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(user.getUserBirth());
			int salt = calendar.get(Calendar.YEAR) *1987 + calendar.get(Calendar.MONTH) * 5 + calendar.get(Calendar.DAY_OF_MONTH) * 28;
			
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
		
		item.setUserBirth(user.getUserBirth());
		if(user.getUserPass().equals(encryption(item))) {
			user.setUserPass("");
			return user;
		}
		return null;
	}

}
