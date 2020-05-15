package com.spring.domain;

import lombok.Data;

@Data
public class Center_ptVO {

	private int center_fk;
	private long ptcon_cd;
	private long pt_cd;
	private String pt_NM;
	private String unit;
	private String origin_NM;
	private String storage_NM;
	private String tax_NM;
	private long sale_cost;
	private long tax;
	private long total;
	private int exp_d;
	private int exp_t;
	private String creditor_fk;
}
