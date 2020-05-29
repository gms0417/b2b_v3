package com.spring.domain;

import java.sql.Date;

import lombok.Data;
import java.util.List;


@Data
public class PdfVO {
	
	
	//인덱스
	private int rn;
	
	
	// 구매처 정보
		// 사업자번호
	private String creditor_CD;
		// 사업자명
	private String creditor_NM;	
		// 대표자	
	private String pre_NM;
		// 주소
	private String adress;
	
	// 업종
	// 업태
	
	
		// 주문번호
	private String order_CD;	
		// 날짜
	private Date regdate;
	

	// 상품코드
	private int product_CD;
	// 상품명
	private String product_NM;	
	// 단위
	private String unit;	
	// 수량
	private int amount;	
	// 단가
	private int product_cost;
	
	// 구매단가정보	
	// 공급가
	private int supply;
	// vat
	private int tax_sum;	
	// 합계
	private int total;	
	// 센터
	private int center;
	
	
	
	// 판매처정보
		// 고객코드, 고객명, 대표자, 고객주소,연락처, 사업자번호
	private String customer_CD;
	private String customer_NM;
	private String c_pre_nm;
	private String c_address;
	private String c_contact;
	private String c_rcd;
	
		// 영업사원
	private String emp_fk;
	private String emp_nm;
	private String emp_phone;
	
	
	
	// 판매단가, 매출액, 부가세, 총합
	private int s_product_cost;
	private int s_supply;
	private int s_tax_sum;
	private int s_total;
	
	
	// 카테고리, md
	private int category_CD;
	private String MD;
	

	
	
	
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	
	
	
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getCreditor_NM() {
		return creditor_NM;
	}
	public void setCreditor_NM(String creditor_NM) {
		this.creditor_NM = creditor_NM;
	}
	public String getCreditor_CD() {
		return creditor_CD;
	}
	public void setCreditor_CD(String creditor_CD) {
		this.creditor_CD = creditor_CD;
	}
	public String getPre_NM() {
		return pre_NM;
	}
	public void setPre_NM(String pre_NM) {
		this.pre_NM = pre_NM;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getOrder_CD() {
		return order_CD;
	}
	public void setOrder_CD(String order_CD) {
		this.order_CD = order_CD;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getCustomer_NM() {
		return customer_NM;
	}
	public void setCustomer_NM(String customer_NM) {
		this.customer_NM = customer_NM;
	}
	public int getProduct_CD() {
		return product_CD;
	}
	public void setProduct_CD(int product_CD) {
		this.product_CD = product_CD;
	}
	public String getProduct_NM() {
		return product_NM;
	}
	public void setProduct_NM(String product_NM) {
		this.product_NM = product_NM;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getProduct_cost() {
		return product_cost;
	}
	public void setProduct_cost(int product_cost) {
		this.product_cost = product_cost;
	}
	public int getSupply() {
		return supply;
	}
	public void setSupply(int supply) {
		this.supply = supply;
	}
	public int getTax_sum() {
		return tax_sum;
	}
	public void setTax_sum(int tax_sum) {
		this.tax_sum = tax_sum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCenter() {
		return center;
	}
	public void setCenter(int center) {
		this.center = center;
	}
	public int getS_product_cost() {
		return s_product_cost;
	}
	public void setS_product_cost(int s_product_cost) {
		this.s_product_cost = s_product_cost;
	}
	public int getS_supply() {
		return s_supply;
	}
	public void setS_supply(int s_supply) {
		this.s_supply = s_supply;
	}
	public int getS_tax_sum() {
		return s_tax_sum;
	}
	public void setS_tax_sum(int s_tax_sum) {
		this.s_tax_sum = s_tax_sum;
	}
	public int getS_total() {
		return s_total;
	}
	public void setS_total(int s_total) {
		this.s_total = s_total;
	}
	public int getCategory_CD() {
		return category_CD;
	}
	public void setCategory_CD(int category_CD) {
		this.category_CD = category_CD;
	}
	public String getMD() {
		return MD;
	}
	public void setMD(String mD) {
		MD = mD;
	}
	public String getCustomer_CD() {
		return customer_CD;
	}
	public void setCustomer_CD(String customer_CD) {
		this.customer_CD = customer_CD;
	}
	public String getC_pre_nm() {
		return c_pre_nm;
	}
	public void setC_pre_nm(String c_pre_nm) {
		this.c_pre_nm = c_pre_nm;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public String getC_contact() {
		return c_contact;
	}
	public void setC_contact(String c_contact) {
		this.c_contact = c_contact;
	}
	public String getC_rcd() {
		return c_rcd;
	}
	public void setC_rcd(String c_rcd) {
		this.c_rcd = c_rcd;
	}
	public String getEmp_fk() {
		return emp_fk;
	}
	public void setEmp_fk(String emp_fk) {
		this.emp_fk = emp_fk;
	}
	public String getEmp_nm() {
		return emp_nm;
	}
	public void setEmp_nm(String emp_nm) {
		this.emp_nm = emp_nm;
	}
	
	
	


	

	
	
	
	
}
