package kr.co.gardener.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.gardener.admin.model.object.Cert;
import kr.co.gardener.admin.model.object.CertReason;
import kr.co.gardener.admin.service.object.CertReasonService;
import kr.co.gardener.admin.service.object.CertService;

@Component
public class CertMapImpl implements CertMap{
	
	private Map<String,Cert> certMap;
	
	private Map<String,CertReason> certReasonMap;
	
	@Autowired
	SqlSession sql;
	
	
	public CertMapImpl() {
		
	
		certMap = new HashMap<>();
		
		certReasonMap = new HashMap<>();
		
	//	List<Cert> csList = sql.selectList("cert.list");
		//List<CertReason> crsList = sql.selectList("certReason.list");
		
			System.out.println("생성자 생성자 생성자 생성자 나는 생성되었지 I am CertMAP");
		/*	
		for(Cert item : csList) {
			certMap.put(item.getCertName(), item);
			certMap.put(String.valueOf(item.getCertId()), item);
		}
		
		for(CertReason item : crsList) {
			certReasonMap.put(item.getCertReasonName(), item);
			certReasonMap.put(String.valueOf(item.getCertReasonId()), item);
		}
		*/
		
	}
	
	@Override
	public Cert getCert(String value) {
		
		return certMap.get(value);
	}
	@Override
	public CertReason getCertReason(String value) {
		return certReasonMap.get(value);
	}
	
}
