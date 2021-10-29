package kr.co.gardener.admin.dao.user;

import java.util.List;

import kr.co.gardener.admin.model.other.Notice;
import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

public interface UserDao {

	List<User> list();

	void add(User item);


	void update(User item);

	void delete(String userId);

	String imgSrc(User user);

	int duplication(String id);

	List<User> list_pager(Pager pager);

	float total(Pager pager);

	List<ComboItem> combo();

	void insert_list(List<User> list);

	void delete_list(List<User> list);

	void update_list(List<User> list);

	User item(User user);

	User item_checkPass(User user);

	int levelUp(User user);

	int count(User user);

	List<User> getUpdatePreList(List<User> list);



}
