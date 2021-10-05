package kr.co.gardener.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public  class CommonList<T> {
	// thName : 테이블의 제목
	// colName : input name 속성에 들어갈 이름, 만약 수정같은거 할때 넘길 값이 아니라면 "" 처리 해줌
	// boxType : input box의 타입을 결정, none -> 수정 불가, text->일반적인 텍스트(수정가능)

	// main에 표시할 table의 열이름
	private HashMap<String, String> th;
	// combo박스가 필요 할 시에
	private HashMap<String, ComboItem[]> com;
	// insert에 관련된 정보들
	private HashMap<String, String> insert;
	String tableName;

	// view가 필요하면 true, 필요없으면 false;
	boolean view;
	
	//리스트
	private List<T> list;
	
	//페이저
	private Pager pager;
		
	

	public CommonList(String tableName) {
		super();
		this.tableName = tableName;
		this.th = new HashMap<String, String>();
		this.com = new HashMap<String, ComboItem[]>();
		this.insert = new HashMap<String, String>();
		this.list = new ArrayList<>();
		this.pager = new Pager();
		this.view = false;
	}

	// 일반적인 제목
	public void addTh(String thName, String colName, String boxType) {
		th.put("th" + th.size(), thName + "-" + colName + "-" + boxType);
	}

	// 제목이 combo 박스일 경우
	public void addTh(String thName, String colName, String boxType, int comboIndex) {
		th.put("th" + th.size(), thName + "-" + colName + "-" + boxType + "-" + String.valueOf(comboIndex));
	}

	// comboList를 저장
	public void addCom(ComboItem[] list) {
		com.put("com" + com.size(), list);
	}

	// insert할 때 열에 대한 정보
	public void addInsert(String thName, String colName, String boxType) {
		insert.put("add" + insert.size(), thName + "-" + colName + "-" + boxType);
	}

	// insert할때 타입이 combobox 여야 할때
	public void addInsert(String thName, String colName, String boxType, int comboIndex) {
		insert.put("add" + insert.size(), thName + "-" + colName + "-" + boxType + "-" + String.valueOf(comboIndex));
	}
	
	//List<ComboItem> 파싱
	public void paseComboList(List<ComboItem> comboList) {
		int nowTable = 0;
		List<ComboItem> com = new ArrayList<>();
		
		for(ComboItem value : comboList) {
			if(value.getTable() == nowTable) {
				com.add(value);								
			}
			else if(value.getTable() != nowTable) {
				this.com.put( String.format("com%d", nowTable), com.toArray(new ComboItem[com.size()]));
				com = new ArrayList<>();
				System.out.println();
				com.add(value);
				nowTable++;
			}			
		}
		this.com.put( String.format("com%d", nowTable), com.toArray(new ComboItem[com.size()]));
		
	}
	

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public int getThLength() {
		return th.size();
	}

	public int getComLength() {
		return com.size();
	}

	public int getInsertLength() {
		return insert.size();
	}

	public HashMap<String, String> getTh() {
		return th;
	}

	public HashMap<String, ComboItem[]> getCom() {
		return com;
	}

	public HashMap<String, String> getInsert() {
		return insert;
	}

	public String getTableName() {
		return tableName;
	}

	public boolean getView() {
		return view;
	}

	public void setView(boolean view) {
		this.view = view;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	
}
