package kr.co.gardener.admin.service.object.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.BotClassDao;
import kr.co.gardener.admin.model.object.BotClass;
import kr.co.gardener.admin.model.object.list.BotClassList;
import kr.co.gardener.admin.service.object.BotClassService;
import kr.co.gardener.util.Pager;

@Service
public class BotClassServiceImpl implements BotClassService {
	List<BotClass> list;
	
	@Autowired
	BotClassDao dao;
	
	@Override
	public BotClassList list_pager(Pager pager) {
		BotClassList item = new BotClassList();
		item.setPager(pager);
		item.setList(dao.list(pager));		
		pager.setTotal(dao.total(pager));
		item.paseComboList(dao.combo());
		return item;
	}

	@Override
	public void insert(BotClassList list) {
		dao.insert(list.getList());
	}

	@Override
	public void delete(BotClassList list) {
		dao.delete(list.getList());
	}

	@Override
	public void update(BotClassList list) {
		dao.update(list.getList());
	}
	
	@Override
	public int searchBotClass(String productInfo) {
		if(list == null) {
			this.list = dao.list();
		}
		
		for(BotClass data : this.list) {
			//System.out.println("ProductInfo:"+ productInfo + ", className :" +data.getBotClassName() + ", count"+ productInfo.indexOf(data.getBotClassName()));
			if(productInfo.indexOf(data.getBotClassName())>0) {
				
				return data.getBotClassId();
			}
		}
		
		
		return 0;
	}

}
