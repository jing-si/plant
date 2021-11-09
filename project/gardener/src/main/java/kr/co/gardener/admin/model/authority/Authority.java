package kr.co.gardener.admin.model.authority;

import javax.management.ConstructorParameters;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import kr.co.gardener.util.GridSystem;


public class Authority extends GridSystem{
	private String adminId;
	private String adminPass;
	private String adminName;
	private String product;
	private String user;
	private String forest;
	private String other;
	private String authority;
	
	
	@Override
	public String toString() {
		return "Authority [adminId=" + adminId + ", adminPass=" + adminPass + ", adminName=" + adminName + ", product="
				+ product + ", user=" + user + ", forest=" + forest + ", other=" + other + ", authority=" + authority
				+ "]";
	}
	
	
	public Authority(String adminId
					,String adminPass) {
		super();
		this.adminId = adminId;
		this.adminPass = adminPass;
	}
	
	public Authority(String adminId
			, String adminPass
			, String adminName) {
		super();
		this.adminId = adminId;
		this.adminPass = adminPass;
		this.adminName = adminName;
	}
	
	@JsonCreator
	@ConstructorParameters({"adminId","adminPass","adminName","product","user","forest","other","authority"})
	public Authority(
			@JsonProperty("adminId") String adminId
			, @JsonProperty("adminPass") String adminPass
			, @JsonProperty("adminName") String adminName
			, @JsonProperty("product") String product
			, @JsonProperty("user") String user
			, @JsonProperty("forest") String forest
			, @JsonProperty("other") String other
			, @JsonProperty("authority") String authority) {
		super();
		this.adminId = adminId;
		this.adminPass = adminPass;
		this.adminName = adminName;
		this.product = result(product);
		this.user = result(user);
		this.forest = result(forest);
		this.other = result(other);
		this.authority = result(authority);
		
	
	}
	
	
	private String result(String value) {
		switch (value) {
		case "28":
			value = "Y";
			break;
		case "0":
			value = "N";
			break;
		
		}
		
		return value;
	}


	public String getAdminId() {
		return adminId;
	}


	public String getAdminPass() {
		return adminPass;
	}


	public String getAdminName() {
		return adminName;
	}


	public String getProduct() {
		return product;
	}


	public String getUser() {
		return user;
	}


	public String getForest() {
		return forest;
	}


	public String getOther() {
		return other;
	}


	public String getAuthority() {
		return authority;
	}
	
	// 코드 리턴	
	public int getProductCode() {
		if(product.equals("Y")) {
			return 28;
		}else if(product.equals("N")){
			return 0;
		}
		return 99;
	}


	public int getUserCode() {
		if(user.equals("Y")) {
			return 28;
		}else if(user.equals("N")){
			return 0;
		}
		return 99;
	}


	public int getForestCode() {
		if(forest.equals("Y")) {
			return 28;
		}else if(forest.equals("N")){
			return 0;
		}
		return 99;
	}


	public int getOtherCode() {
		if(other.equals("Y")) {
			return 28;
		}else if(other.equals("N")){
			return 0;
		}
		return 99;
	}


	public int getAuthorityCode() {
		if(authority.equals("Y")) {
			return 28;
		}else if(authority.equals("N")){
			return 0;
		}
		return 99;
	}
	
	
}
