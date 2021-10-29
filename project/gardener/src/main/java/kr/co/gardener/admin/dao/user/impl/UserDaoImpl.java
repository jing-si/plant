package kr.co.gardener.admin.dao.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.user.UserDao;
import kr.co.gardener.admin.model.other.Notice;
import kr.co.gardener.admin.model.user.User;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<User> list() {
		return sql.selectList("user.list");
	}

	@Override
	public void add(User item) {
		sql.insert("user.add", item);
	}

	@Override
	public User item_checkPass(User user) {
		return sql.selectOne("user.item_checkPass", user);
	}
	@Override
	public User item(User user) {
		return sql.selectOne("user.item", user);
	}

	@Override
	public void update(User item) {
		sql.update("user.update", item);
	}

	@Override
	public void delete(String userId) {
		sql.delete("user.delete", userId);
	}

	@Override
	public String imgSrc(User user) {
		return sql.selectOne("user.imgSrc", user);
	}

	@Override
	public int duplication(String id) {
		return sql.selectOne("user.duplication",id);
	}

	@Override
	public List<User> list_pager(Pager pager) {
		return sql.selectList("user.list_pager",pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("user.total", pager);
	}

	@Override
	public List<ComboItem> combo() {
		return sql.selectList("user.combo");
	}

	@Override
	public void insert_list(List<User> list) {
		sql.insert("user.insert_list", list);
	}

	@Override
	public void delete_list(List<User> list) {
		sql.delete("user.delete_list", list);
	}

	@Override
	public void update_list(List<User> list) {
		sql.update("user.update_list", list);
	}

	@Override
	public int levelUp(User user) {
		return sql.update("user.levelUp",user);
	}

	@Override
	public int count(User user) {
		return sql.selectOne("user.count", user);
	}

	@Override
	public List<User> getUpdatePreList(List<User> list) {
		return sql.selectList("user.updatePreList",list);
	}




}
