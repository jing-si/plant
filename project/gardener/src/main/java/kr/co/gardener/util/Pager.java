package kr.co.gardener.util;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private int page;
	private int perPage;
	private float total;
	private int perGroup = 5;
	private int search = 0;
	private String keyword;
	
	public int getOffset() {
		return (page-1)*perPage;
	}
	
	public int getSearch() {
		return search;
	}

	public void setSearch(int search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Pager [page=" + page + ", perPage=" + perPage + ", total=" + total + ", perGroup=" + perGroup + "]";
	}

	public List<Integer> getList(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int page = getLast();
		int startPage = ((this.page - 1)/perGroup)*perGroup + 1;
		
		for(int A = startPage ; A < (startPage + perGroup) && A <= page  ; A++) {
			list.add(A);
			System.out.println("A : "+ A);
		}
		
		if(list.isEmpty()) {
			list.add(1);
		}
		for(int C : list) {
			System.out.println(C);
		}
		System.out.println(list.size());
		return list;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public Pager(){
		page = 1;
		perPage = 10;
		
	}

	public float getTotal() {
		return total;
	}
	

	public void setTotal(float total) {
		this.total = total;
		
	}

	public int getLast() {
		return (int) Math.ceil(total/perPage);
	}
	public int getPrev() {
		return Math.max((((page - 1)/perGroup)-1)*perGroup+1,1);		
	}
	
	public int getNext() {
		return Math.min((((page - 1)/perGroup)+1)*perGroup+1,getLast());
	}
	public String getQuery() {
		if(search > 0) {
			return "search="+search +"&keyword=" +keyword;
		}
		return "";
	}
}
