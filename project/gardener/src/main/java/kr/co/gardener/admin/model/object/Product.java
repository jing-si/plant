package kr.co.gardener.admin.model.object;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Product {
	
	
	public Product() {
		super();
	}

	private String prodProd; // 환경표지 제품ID(PK)
	private String prodPrnm; // 제품명
	private String prodEcos; // 일반분류코드(미사용)
	private String ecosClnm; // 일반분류명(미사용)
	private String prodElcd; // EL분류
	private String elcdClnm; // EL분류명
	private String prodG2bd; // G2B분류번호
	private String g2bdClnm; // G2B분류명(미사용)
	private String prodG2sn; // 식별번호
	private String prodVcod; // 사업자번호
	private String prodStat; // 사용유무(Y/N)
	private String prodMdel; // 모델명
	private String prodSpec; // 규격
	private String prodUnit; // 판매단위
	private String prodPrce; // 가격
	private String prodEcyn; // 환경표지인증(Y/N)
	private String prodGryn; // GR인증(Y/N)
	private String prodRsid; // 인증번호
	private String prodRson; // 인증사유코드
	private String prodInrs; // 환경표지 상세인증사유
	private String prodRsst; // 환경표지 인증상태(01:인증, 02:재약정중, 03:인증포기, 04:인증만료, 05:사용안함)
	private String prodRsnm; // 환경표지 인증상태명(미사용)
	private String prodRsdt; // 환경표지 인증시작일(YYYY.MM.DD)
	private String prodRedt; // 환경표지 인증만료일(YYYY.MM.DD)
	private String prodGrid; // GR인증번호
	private String prodGrst; // GR 인증상태(01:인증, 02:취소(재약정중), 03:인증포기, 04:인증만료, 05:사용안함)
	private String prodGrnm; // GR인증 상태명(미사용)
	private String prodGsdt; // GR 인증시작일(YYYY.MM.DD)
	private String prodGedt; // GR 인증만료일(YYYY.MM.DD)
	private String prodTarg; // 판매대상코드
	private String prodIndt; // 최초입력일자 YYYYMMDDHH24MMSS
	private String prodUpdt; // 최종수정일자 YYYYMMDDHH24MMSS
	private String epdpPrid; // 저탄소 제품ID(PK)
	private String epdpRsid; // 저탄소인증번호
	private String epdpSeqn; // 순번
	private String epdpPrgb; // 저탄소 제품 용도구분
	private String epdpPrnm; // 저탄소 제품 용도
	private String epdpGrnm; // 저탄소 제품군
	private String epdpG2bd; // 물품분류번호
	private String epdpG2sn; // G2B 식별번호
	private String epdpVcod; // 사업자번호
	private String epdpStat; // 사용여부 [Y:사용,N:미사용]
	private String epdpMdel; // 제품명(모델명)
	private String epdpSpec; // 저탄소제품 규격
	private String epdpC2yn; // 인증상태 [Y:유효,N:무효]
	private String epdpRson; // 인증사유
	private String epdpRsst; // 저탄소 인증상태(01:인증, 02:취소(재약정중), 03:인증포기, 04:인증만료, 05:사용안함)
	private String epdpRsnm; // 저탄소 인증상태명(EPIMCDDT.CDDT_DSCS)(미사용)
	private String epdpCsdt; // 저탄소인증 시작일(YYYY.MM.DD)
	private String epdpCedt; // 저탄소인증 만료일(YYYY.MM.DD)
	private String epdpImg1; // 저탄소제품 이미지 경로
	private String epdpIndt; // 최초입력일자 YYYYMMDDHH24MMSS
	private String epdpUpdt; // 최종수정일자 YYYYMMDDHH24MMSS
	private String totalCount; // 조회결과건수
	private String checkDate; // 조회일자(YYYYMMDD)
	private String prodImg; // 제품 이미지
	// DB를 위한
	private String productId;
	private String productName;
	private String productSize;
	private String productImage;
	private int certId;
	private int productCertId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date productStartDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date productEndDate;
	private String companyId;
	private int g2bId;
	private int elId;

	// 추가 필드
	private List<CertReason> certReasons;
	private Cert cert;
	//유틸성
	 

	// api용 get,seet
	public String getProdProd() {
		return prodProd;
	}

	public void setProdProd(String prodProd) {
		this.prodProd = prodProd;
	}

	public String getProdPrnm() {
		return prodPrnm;
	}

	public void setProdPrnm(String prodPrnm) {
		this.prodPrnm = prodPrnm;
	}

	public String getProdEcos() {
		return prodEcos;
	}

	public void setProdEcos(String prodEcos) {
		this.prodEcos = prodEcos;
	}

	public String getEcosClnm() {
		return ecosClnm;
	}

	public void setEcosClnm(String ecosClnm) {
		this.ecosClnm = ecosClnm;
	}

	public String getProdElcd() {
		return prodElcd;
	}

	public void setProdElcd(String prodElcd) {
		this.prodElcd = prodElcd;
	}

	public String getElcdClnm() {
		return elcdClnm;
	}

	public void setElcdClnm(String elcdClnm) {
		this.elcdClnm = elcdClnm;
	}

	public String getProdG2bd() {
		return prodG2bd;
	}

	public void setProdG2bd(String prodG2bd) {
		this.prodG2bd = prodG2bd;
	}

	public String getG2bdClnm() {
		return g2bdClnm;
	}

	public void setG2bdClnm(String g2bdClnm) {
		this.g2bdClnm = g2bdClnm;
	}

	public String getProdG2sn() {
		return prodG2sn;
	}

	public void setProdG2sn(String prodG2sn) {
		this.prodG2sn = prodG2sn;
	}

	public String getProdVcod() {
		return prodVcod;
	}

	public void setProdVcod(String prodVcod) {
		this.prodVcod = prodVcod;
	}

	public String getProdStat() {
		return prodStat;
	}

	public void setProdStat(String prodStat) {
		this.prodStat = prodStat;
	}

	public String getProdMdel() {
		return prodMdel;
	}

	public void setProdMdel(String prodMdel) {
		this.prodMdel = prodMdel;
	}

	public String getProdSpec() {
		return prodSpec;
	}

	public void setProdSpec(String prodSpec) {
		this.prodSpec = prodSpec;
	}

	public String getProdUnit() {
		return prodUnit;
	}

	public void setProdUnit(String prodUnit) {
		this.prodUnit = prodUnit;
	}

	public String getProdPrce() {
		return prodPrce;
	}

	public void setProdPrce(String prodPrce) {
		this.prodPrce = prodPrce;
	}

	public String getProdEcyn() {
		return prodEcyn;
	}

	public void setProdEcyn(String prodEcyn) {
		this.prodEcyn = prodEcyn;
	}

	public String getProdGryn() {
		return prodGryn;
	}

	public void setProdGryn(String prodGryn) {
		this.prodGryn = prodGryn;
	}

	public String getProdRsid() {
		return prodRsid;
	}

	public void setProdRsid(String prodRsid) {
		this.prodRsid = prodRsid;
	}

	public String getProdRson() {
		return prodRson;
	}

	public void setProdRson(String prodRson) {
		this.prodRson = prodRson;
	}

	public String getProdInrs() {
		return prodInrs;
	}

	public void setProdInrs(String prodInrs) {
		this.prodInrs = prodInrs;
	}

	public String getProdRsst() {
		return prodRsst;
	}

	public void setProdRsst(String prodRsst) {
		this.prodRsst = prodRsst;
	}

	public String getProdRsnm() {
		return prodRsnm;
	}

	public void setProdRsnm(String prodRsnm) {
		this.prodRsnm = prodRsnm;
	}

	public String getProdRsdt() {
		return prodRsdt;
	}

	public void setProdRsdt(String prodRsdt) {
		this.prodRsdt = prodRsdt;
	}

	public String getProdRedt() {
		return prodRedt;
	}

	public void setProdRedt(String prodRedt) {
		this.prodRedt = prodRedt;
	}

	public String getProdGrid() {
		return prodGrid;
	}

	public void setProdGrid(String prodGrid) {
		this.prodGrid = prodGrid;
	}

	public String getProdGrst() {
		return prodGrst;
	}

	public void setProdGrst(String prodGrst) {
		this.prodGrst = prodGrst;
	}

	public String getProdGrnm() {
		return prodGrnm;
	}

	public void setProdGrnm(String prodGrnm) {
		this.prodGrnm = prodGrnm;
	}

	public String getProdGsdt() {
		return prodGsdt;
	}

	public void setProdGsdt(String prodGsdt) {
		this.prodGsdt = prodGsdt;
	}

	public String getProdGedt() {
		return prodGedt;
	}

	public void setProdGedt(String prodGedt) {
		this.prodGedt = prodGedt;
	}

	public String getProdTarg() {
		return prodTarg;
	}

	public void setProdTarg(String prodTarg) {
		this.prodTarg = prodTarg;
	}

	public String getProdIndt() {
		return prodIndt;
	}

	public void setProdIndt(String prodIndt) {
		this.prodIndt = prodIndt;
	}

	public String getProdUpdt() {
		return prodUpdt;
	}

	public void setProdUpdt(String prodUpdt) {
		this.prodUpdt = prodUpdt;
	}

	public String getEpdpPrid() {
		return epdpPrid;
	}

	public void setEpdpPrid(String epdpPrid) {
		this.epdpPrid = epdpPrid;
	}

	public String getEpdpRsid() {
		return epdpRsid;
	}

	public void setEpdpRsid(String epdpRsid) {
		this.epdpRsid = epdpRsid;
	}

	public String getEpdpSeqn() {
		return epdpSeqn;
	}

	public void setEpdpSeqn(String epdpSeqn) {
		this.epdpSeqn = epdpSeqn;
	}

	public String getEpdpPrgb() {
		return epdpPrgb;
	}

	public void setEpdpPrgb(String epdpPrgb) {
		this.epdpPrgb = epdpPrgb;
	}

	public String getEpdpPrnm() {
		return epdpPrnm;
	}

	public void setEpdpPrnm(String epdpPrnm) {
		this.epdpPrnm = epdpPrnm;
	}

	public String getEpdpGrnm() {
		return epdpGrnm;
	}

	public void setEpdpGrnm(String epdpGrnm) {
		this.epdpGrnm = epdpGrnm;
	}

	public String getEpdpG2bd() {
		return epdpG2bd;
	}

	public void setEpdpG2bd(String epdpG2bd) {
		this.epdpG2bd = epdpG2bd;
	}

	public String getEpdpG2sn() {
		return epdpG2sn;
	}

	public void setEpdpG2sn(String epdpG2sn) {
		this.epdpG2sn = epdpG2sn;
	}

	public String getEpdpVcod() {
		return epdpVcod;
	}

	public void setEpdpVcod(String epdpVcod) {
		this.epdpVcod = epdpVcod;
	}

	public String getEpdpStat() {
		return epdpStat;
	}

	public void setEpdpStat(String epdpStat) {
		this.epdpStat = epdpStat;
	}

	public String getEpdpMdel() {
		return epdpMdel;
	}

	public void setEpdpMdel(String epdpMdel) {
		this.epdpMdel = epdpMdel;
	}

	public String getEpdpSpec() {
		return epdpSpec;
	}

	public void setEpdpSpec(String epdpSpec) {
		this.epdpSpec = epdpSpec;
	}

	public String getEpdpC2yn() {
		return epdpC2yn;
	}

	public void setEpdpC2yn(String epdpC2yn) {
		this.epdpC2yn = epdpC2yn;
	}

	public String getEpdpRson() {
		return epdpRson;
	}

	public void setEpdpRson(String epdpRson) {
		this.epdpRson = epdpRson;
	}

	public String getEpdpRsst() {
		return epdpRsst;
	}

	public void setEpdpRsst(String epdpRsst) {
		this.epdpRsst = epdpRsst;
	}

	public String getEpdpRsnm() {
		return epdpRsnm;
	}

	public void setEpdpRsnm(String epdpRsnm) {
		this.epdpRsnm = epdpRsnm;
	}

	public String getEpdpCsdt() {
		return epdpCsdt;
	}

	public void setEpdpCsdt(String epdpCsdt) {
		this.epdpCsdt = epdpCsdt;
	}

	public String getEpdpCedt() {
		return epdpCedt;
	}

	public void setEpdpCedt(String epdpCedt) {
		this.epdpCedt = epdpCedt;
	}

	public String getEpdpImg1() {
		return epdpImg1;
	}

	public void setEpdpImg1(String epdpImg1) {
		this.epdpImg1 = epdpImg1;
	}

	public String getEpdpIndt() {
		return epdpIndt;
	}

	public void setEpdpIndt(String epdpIndt) {
		this.epdpIndt = epdpIndt;
	}

	public String getEpdpUpdt() {
		return epdpUpdt;
	}

	public void setEpdpUpdt(String epdpUpdt) {
		this.epdpUpdt = epdpUpdt;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getProdImg() {
		return prodImg;
	}

	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}

	// productId -> 제품번호
	public String getProductId() {
		if (!StringUtils.isEmpty(productId)) {
			return productId;
		}

		if (!StringUtils.isEmpty(prodProd)) {
			return prodProd;
		}

		if (!StringUtils.isEmpty(epdpPrid)) {
			return epdpPrid;
		}
		return null;
	}

	// productName -> 제품이름
	public String getProductName() {
		if (!StringUtils.isEmpty(productName)) {
			return productName;
		}

		if (!StringUtils.isEmpty(prodMdel)) {
			return prodMdel;
		}

		if (!StringUtils.isEmpty(epdpMdel)) {
			return epdpMdel;
		}
		return null;
	}

	// productSize -> 규격
	public String getProductSize() {
		if (!StringUtils.isEmpty(productSize)) {
			return productSize;
		}
		if (!StringUtils.isEmpty(prodSpec)) {
			return prodSpec;
		}

		if (!StringUtils.isEmpty(epdpMdel)) {
			return epdpMdel;
		}
		return null;
	}

	// productImage -> 제품 이미지
	public String getProductImage() {
		String url = "http://data.greenproduct.go.kr/openProductImage.do?prodProd=" + productId +"&prod_img_size=250";
		
		if (!StringUtils.isEmpty(productImage)) {
			return productImage;
		}
		
		if (!StringUtils.isEmpty(prodImg)) {
			return prodImg;
		}

		if (!StringUtils.isEmpty(epdpImg1)) {
			return epdpImg1;
		}
		return url;
	}

	// certId -> 인증ID //여기서 저탄소와 환경표지등
	public String getCertName() {
		if (cert != null) {
			return cert.getCertName();
		}

		if (!StringUtils.isEmpty(prodProd)) {
			return "환경표지";
		}

		if (!StringUtils.isEmpty(epdpPrid)) {
			return "저탄소";
		}

		return null;
	}

	// productCertId -> 제품 마크 인증 번호
	public String getProductCertId() {
		if (productCertId != 0) {
			return String.valueOf(productCertId);
		}
		if (!StringUtils.isEmpty(prodInrs)) {
			return prodRsid;
		}

		if (!StringUtils.isEmpty(epdpRsid)) {
			return epdpRsid;
		}
		return null;
	}

	// productStartDate -> 인증 시작일
	public String getProductStartDate() {
		if (productStartDate != null) {

			return new SimpleDateFormat("yyyy-MM-dd").format(productStartDate);
		}
		if (!StringUtils.isEmpty(prodRsdt)) {
			return prodRsdt;
		}

		if (!StringUtils.isEmpty(epdpCsdt)) {
			return epdpCsdt;
		}
		return null;
	}

	// productEndDate -> 인증 만료일
	public String getProductEndDate() {
		if (productEndDate != null) {
			return new SimpleDateFormat("yyyy-MM-dd").format(productEndDate);
		}
		if (!StringUtils.isEmpty(prodRedt)) {
			return prodRedt;
		}

		if (!StringUtils.isEmpty(epdpCedt)) {
			return epdpCedt;
		}
		return null;
	}

	// companyId -> 기업 ID
	public String getCompanyId() {
		if (!StringUtils.isEmpty(companyId)) {
			return companyId;
		}

		if (!StringUtils.isEmpty(prodVcod)) {
			return prodVcod;
		}

		if (!StringUtils.isEmpty(epdpVcod)) {
			return epdpVcod;
		}
		return null;
	}

	// G2BId -> G2B ID
	public int getG2bId() {
		if (g2bId != 0) {
			return g2bId;
		}
		if (!StringUtils.isEmpty(prodG2bd)) {
			return Integer.valueOf(prodProd);
		}
		return 0;
		
	}

	// ELId -> EL ID
	public int getElId() {
		if (elId != 0) {
			return elId;
		}
		if (!StringUtils.isEmpty(prodElcd)) {
			return Integer.valueOf(prodElcd);
		}
		return 0;

	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public void setCertId(int certId) {
		this.certId = certId;
	}

	public void setProductCertId(int productCertId) {
		this.productCertId = productCertId;
	}

	public void setProductStartDate(Date productStartDate) {
		this.productStartDate = productStartDate;
	}

	public void setProductEndDate(Date productEndDate) {
		this.productEndDate = productEndDate;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public void setG2bId(int g2bId) {
		this.g2bId = g2bId;
	}

	public void setElId(int elId) {
		this.elId = elId;
	}

	
	public List<CertReason> getCertReasons() {
		return certReasons;
	}

	public void setCertReasons(List<CertReason> certReasons) {
		this.certReasons = certReasons;
	}

	public Cert getCert() {
		return cert;
	}

	public void setCert(Cert cert) {
		this.cert = cert;
	}

	public int getCertId() {
		if(certId != 0) { 
		return certId;}
		if (!StringUtils.isEmpty(prodProd)) {
			return Integer.valueOf(prodProd);
		}

		if (!StringUtils.isEmpty(epdpPrid)) {
			return Integer.valueOf(epdpPrid);
		}
		return 0;
	}
  
	
	
}
