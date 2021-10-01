package kr.co.gardener.admin.service.object.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gardener.admin.dao.object.ClassifyDao;
import kr.co.gardener.admin.model.object.Classify;
import kr.co.gardener.admin.model.object.ClassifyList;
import kr.co.gardener.admin.service.object.ClassifyService;

@Service
public class ClassifyServiceImpl implements ClassifyService {

	@Autowired
	ClassifyDao classifyDao;	

	@Override
	public ClassifyList getList() {
		List<Classify> list = classifyDao.getList();
		
		ClassifyList classifyList = new ClassifyList();
		
		//1 = top, 2=mid, 3=bot
		for(Classify classify : list) {
			switch (classify.getTable()) {
			case 1:
				classifyList.getTopClass().add(classify);
				break;
			case 2:
				classifyList.getMidClass().add(classify);
				break;
			case 3:
				classifyList.getBotClass().add(classify);
				break;
			}
		}
		
		return classifyList;
	}

	@Override
	public void topAdd(Classify item) {
		classifyDao.topAdd(item);
	}

	@Override
	public void midAdd(Classify item) {
		classifyDao.midAdd(item);
		
	}

	@Override
	public void botAdd(Classify item) {
		classifyDao.botAdd(item);
		
	}

	@Override
	public void topUpdate(Classify item) {
		classifyDao.topUpdate(item);
	}

	@Override
	public void midUpdate(Classify item) {
		classifyDao.midUpdate(item);		
	}

	@Override
	public void botUpdate(Classify item) {
		classifyDao.botUpdate(item);		
	}

	@Override
	public void topDelete(int primaryId) {
		classifyDao.topDelete(primaryId);		
	}

	@Override
	public void midDelete(int primaryId) {
		classifyDao.midDelete(primaryId);
	}

	@Override
	public void botDelete(int primaryId) {
		classifyDao.botDelete(primaryId);
	}

	@Override
	public List<kr.co.gardener.admin.model.object.productCategoryList> productCategoryList() {
		
		return classifyDao.productCategoryList();
	}

	
}
