package com.spring.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class CartVO {
	private long customer_pk;
	private String exp_D;
	private int ptcon_fk;
	private String delivery_date;
	private long pt_cd;
	private String pt_NM;
	private String unit;
	private String origin_NM;
	private String storage_NM;
	private String tax_NM;
	private long sale_cost;
	private	int amount;
	private long supply_price;
	private long vat;
	private long column5;
	private int exp;
	private String creditor_fk;
	private int center_fk;
}
