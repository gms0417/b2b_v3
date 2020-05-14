package com.spring.mapper;

import java.util.List;

import com.spring.domain.CustomerVO;
import com.spring.domain.SalesVO;

public interface SalesMapper {
	public List<SalesVO> salesList();
	public List<CustomerVO> customerList();
	
}
