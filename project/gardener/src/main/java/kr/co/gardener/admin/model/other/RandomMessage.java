package kr.co.gardener.admin.model.other;

import kr.co.gardener.util.GridSystem;

public class RandomMessage extends GridSystem{
	private int randomMessageId;
	private String randomMessageCategory;
	private String randomMessageText;
	
	public int getRandomMessageId() {
		return randomMessageId;
	}
	public void setRandomMessageId(int randomMessageId) {
		this.randomMessageId = randomMessageId;
	}
	public String getRandomMessageCategory() {
		return randomMessageCategory;
	}
	public void setRandomMessageCategory(String randomMessageCategory) {
		this.randomMessageCategory = randomMessageCategory;
	}
	public String getRandomMessageText() {
		return randomMessageText;
	}
	public void setRandomMessageText(String randomMessageText) {
		this.randomMessageText = randomMessageText;
	}
	
	
}
