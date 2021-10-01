package kr.co.gardener.admin.service;

import java.util.List;

import kr.co.gardener.admin.model.SearchList;

public interface SearchListService {

	List<SearchList> list();

	void add(SearchList item);

	SearchList item(int searchId);

	void update(SearchList item);

	void delete(int searchId);

}
