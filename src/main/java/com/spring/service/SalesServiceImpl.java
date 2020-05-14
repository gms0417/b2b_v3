package com.spring.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.domain.Center_ptVO;
import com.spring.domain.CustomerVO;
import com.spring.domain.SalesVO;
import com.spring.domain.SearchVO;
import com.spring.mapper.SalesMapper;


@Service
public class SalesServiceImpl implements SalesService {
	
	@Autowired
	private SalesMapper mapper;

	@Override
	public List<SalesVO> salesList() throws Exception {		
		return mapper.salesList();
	}

	@Override
	public List<CustomerVO> customerList() throws Exception {
		return mapper.customerList();
	}

	@Override
	public List<CustomerVO> customerSearch(SearchVO vo) throws Exception {
		return mapper.customerSearch(vo);
	}

	@Override
	public List<Center_ptVO> center_ptList(int day,String customer_cd,String delivery) throws Exception {
		return mapper.center_ptList(day, customer_cd, delivery);
	}

}
