package kr.co.gardener.main.dao;

import kr.co.gardener.admin.model.user.User;

public interface LoginDao {

	User item(String userId);

}
