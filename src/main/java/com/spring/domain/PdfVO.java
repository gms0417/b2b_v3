package com.spring.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class PdfVO {
	
	// 사업자명
	private String creditor_NM;	
	// 사업자번호
	private String creditor_CD;
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
	
	// 고객명
	private String customer_NM;
	
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
	
	// 공급가
	private int supply;
	// vat
	private int tax_sum;
	
	// 합계
	private int total;
	
	// 센터
	private int center;
	
	
	
	
	// 판매단가, 매출액, 부가세, 총합
	private int s_product_cost;
	private int s_supply;
	private int s_tax_sum;
	private int s_total;
	
	
	// 카테고리, md
	private int category_CD;
	private String MD;
	

}
