package kr.co.gardener.admin.service.authority.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.authority.AuthorityDao;
import kr.co.gardener.admin.model.authority.AdminDTO;
import kr.co.gardener.admin.model.authority.Authority;
import kr.co.gardener.admin.model.authority.AuthorityUpdate;
import kr.co.gardener.admin.model.authority.list.AuthorityList;
import kr.co.gardener.admin.service.authority.AuthorityService;
import kr.co.gardener.util.Pager;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityDao dao;

	@Override
	public AuthorityList list_pager(Pager pager) {
		AuthorityList list = new AuthorityList();
		list.setList(dao.list_pager(pager));
		list.setPager(pager);
		list.paseComboList(dao.combo());
		pager.setTotal(dao.total(pager));
		return list;
	}

	@Override
	public void insert_list(AuthorityList item) {
		List<Authority> prelist = item.getList();
		List<Authority> nowlist = new ArrayList<Authority>();
		for (Authority a : prelist) {
			Authority authority = new Authority(a.getAdminId(), encryption(a), a.getAdminName(), a.getProduct(),
					a.getUser(), a.getForest(), a.getOther(), a.getAuthority());
			nowlist.add(authority);
		}
		dao.insert_list(nowlist);

	}

	@Override
	public void delete_list(AuthorityList list) {
		dao.delete_list(list.getList());
	}

	@Override
	public void update_list(AuthorityList item) {
		List<Authority> nowlist = item.getList();
		List<Authority> prelist = dao.updatePreList(nowlist);
		List<Authority> newlist = new ArrayList<Authority>();
		
		
		
		for (Authority now : nowlist) {
			for(Authority pre : prelist) {
				if(pre.getAdminId().equals(now.getAdminId())) {
					String pass;
					if(pre.getAdminPass().equals(now.getAdminPass())) {
						pass = pre.getAdminPass();
					}else {
						pass = encryption(now);
					}
					Authority authority = new Authority(now.getAdminId(), pass, now.getAdminName(), 
							now.getProduct(), now.getUser(), now.getForest(), now.getOther(), now.getAuthority());
					
					newlist.add(authority);
					break;
				}
			}
		}
		dao.update_list(newlist);
	}

	private String encryption(Authority admin) {
		if (admin == null || admin.getAdminId() == null || admin.getAdminName() == null
				|| admin.getAdminPass() == null) {
			return null;
		}

		byte[] salt1Value = null; // salt를 위한 임시 데이터
		byte[] salt2Value = null; // salt를 위한 임시 데이터
		byte[] hashValue = null; // 해쉬값

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			int salt = 960303 * Integer.valueOf(admin.getAdminId().charAt(0))+ Integer.valueOf(admin.getAdminId().charAt(0));

			salt1Value = md.digest(String.valueOf(salt).getBytes());
			salt2Value = md.digest(admin.getAdminId().getBytes());
			
			md.reset();
			md.update(ArrayUtils.addAll(salt1Value, salt2Value));

			hashValue = md.digest(admin.getAdminPass().getBytes());
			hashValue = md.digest(hashValue);


		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(new String(Base64.encodeBase64(hashValue)));

		return new String(Base64.encodeBase64(hashValue));
	}

	@Override
	public Authority login(AdminDTO item) {
		Authority author = dao.login(item);
		if (author == null)
			return null;
		
		Authority temp = new Authority(item.getAdminId(), item.getAdminPass(), author.getAdminName());
		String pass = encryption(temp);
		
		if(!pass.equals(author.getAdminPass()))
			return null;
		
		
		
		return new Authority(
				author.getAdminId()
				,null
				,author.getAdminName()				
				,author.getProduct()
				,author.getUser()
				,author.getForest()
				,author.getOther()
				,author.getAuthority()
				);
	}

	

}
