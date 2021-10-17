package kr.co.gardener.admin.dao.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.dao.user.NoticeDao;
import kr.co.gardener.admin.model.other.Notice;
import kr.co.gardener.util.Pager;
@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Notice> list() {
		return sql.selectList("notice.list");
	}

	@Override
	public void add(Notice item) {
		sql.insert("notice.add", item);
	}

	@Override
	public Notice item(int noticeId) {
		return sql.selectOne("notice.item", noticeId);
	}

	@Override
	public void update(Notice item) {
		sql.update("notice.update", item);
	}

	@Override
	public void delete(int noticeId) {
		sql.delete("notice.delete", noticeId);
	}

	@Override
	public List<Notice> list_pager(Pager pager) {
		return sql.selectList("notice.list_pager", pager);
	}

	@Override
	public float total(Pager pager) {
		return sql.selectOne("notice.total", pager);
	}

	@Override
	public void insert_list(List<Notice> list) {
		sql.insert("notice.insert_list",list);
	}

	@Override
	public void delete_list(List<Notice> list) {
		sql.delete("notice.delete_list",list);
	}

	@Override
	public void update_list(List<Notice> list) {
		sql.update("notice.update_list",list);		
	}

}
