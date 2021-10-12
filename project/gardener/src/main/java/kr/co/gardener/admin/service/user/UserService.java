package kr.co.gardener.admin.service.user;

import java.util.List;

import kr.co.gardener.admin.model.user.Notice;
import kr.co.gardener.admin.model.user.User;

public interface UserService {

	List<User> list();

	void add(User item);

	User item(String userId);

	void update(User item);

	void delete(String userId);

	String imgSrc(User user);

	List<Notice> notice();

	boolean duplication(String id);


}
