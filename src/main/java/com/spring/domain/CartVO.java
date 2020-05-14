package com.spring.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class CartVO {
	private long customer_pk;
	private String exp_D;
	private int ptcon_fk;
	private Date delivery_date;
	private	int amount;
	private long supply_price;
	private long vat;
	private long column5;
}
