package kr.co.gardener.admin.dao;

import java.util.List;

import kr.co.gardener.admin.model.User;

public interface UserDao {

	List<User> list();

	void add(User item);

	User item(String userId);

	void update(User item);

	void delete(String userId);

	String imgSrc(User user);

}
