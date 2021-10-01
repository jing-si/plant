package kr.co.gardener.main.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.model.User;
@Repository
public class SettingDaoImpl implements SettingDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public void out(User item) {
		sql.delete("user.delete", item);
	}

}
