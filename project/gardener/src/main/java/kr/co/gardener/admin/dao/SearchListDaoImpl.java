package kr.co.gardener.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.gardener.admin.model.SearchList;
@Repository
public class SearchListDaoImpl implements SearchListDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<SearchList> list() {
		return sql.selectList("searchList.list");
	}

	@Override
	public void add(SearchList item) {
		sql.insert("searchList.add",item);
	}

	@Override
	public SearchList item(int searchId) {
		return sql.selectOne("searchList.item", searchId);
	}

	@Override
	public void update(SearchList item) {
		sql.update("searchList.update", item);
	}

	@Override
	public void delete(int searchId) {
		sql.delete("searchList.delete", searchId);
	}

}
