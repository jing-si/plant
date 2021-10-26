package kr.co.gardener.admin.service.authority;

import kr.co.gardener.admin.model.authority.AdminDTO;
import kr.co.gardener.admin.model.authority.Authority;
import kr.co.gardener.admin.model.authority.list.AuthorityList;
import kr.co.gardener.util.Pager;

public interface AuthorityService {

	AuthorityList list_pager(Pager pager);

	void insert_list(AuthorityList list);

	void delete_list(AuthorityList list);

	void update_list(AuthorityList list);

	Authority login(AdminDTO item);

}
