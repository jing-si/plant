package kr.co.gardener.util;

public class ComboItem{
	int table;
	String id;
	String text;
	
	
	public int getTable() {
		return table;
	}


	public void setTable(int table) {
		this.table = table;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	@Override
	public String toString() {
		return "ComboItem [table=" + table + ", id=" + id + ", text=" + text + "]";
	}


		
	
}