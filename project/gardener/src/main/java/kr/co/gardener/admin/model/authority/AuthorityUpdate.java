package kr.co.gardener.admin.model.authority;

public class AuthorityUpdate extends Authority{
	
	public AuthorityUpdate(String adminId, String preAdminPass,String newAdminPass, String adminName, String product, String user,
			String forest, String other, String authority) {
		super(adminId, preAdminPass, adminName, product, user, forest, other, authority);
		this.newAdminPass = newAdminPass;
		 
	}

	String newAdminPass;

	public String getNewAdminPass() {
		return newAdminPass;
	}

	public void setNewAdminPass(String newAdminPass) {
		this.newAdminPass = newAdminPass;
	}

	
	
	
	

}
