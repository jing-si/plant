package kr.co.gardener.admin.dao.authority;

import java.util.List;

import kr.co.gardener.admin.model.authority.AdminDTO;
import kr.co.gardener.admin.model.authority.Authority;
import kr.co.gardener.util.ComboItem;
import kr.co.gardener.util.Pager;

public interface AuthorityDao {

	List<Authority> list_pager(Pager pager);

	float total(Pager pager);

	List<ComboItem> combo();

	void insert_list(List<Authority> list);

	void delete_list(List<Authority> list);

	void update_list(List<Authority> list);

	Authority login(AdminDTO item);

}
