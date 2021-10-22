package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.admin.model.user.list.UserList;
import kr.co.gardener.util.Pager;

public interface UserService {

	List<User> list();

	void add(User item);

	void update(User item);

	void delete(String userId);

	String imgSrc(User user);

	boolean duplication(String id);

	UserList list_pager(Pager pager);

	void insert_list(UserList list);

	void delete_list(UserList list);

	void update_list(UserList list);

	User item(User item);

	User login(User item);
	
	void levelUp(User user);

	int count(User user);


}
