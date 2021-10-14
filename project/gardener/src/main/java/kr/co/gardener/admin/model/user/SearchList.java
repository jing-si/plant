package kr.co.gardener.admin.model.user;

import kr.co.gardener.util.GridSystem;

public class SearchList extends GridSystem{
	private String userId;
	private int searchId;
	private String searchWord;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getSearchId() {
		return searchId;
	}
	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	
}
