package com.spring.mapper;

import java.util.List;

<<<<<<< HEAD
import com.spring.domain.CustomerVO;
import com.spring.domain.SalesVO;

public interface SalesMapper {
	public List<SalesVO> salesList();
	public List<CustomerVO> customerList();
=======
import com.spring.domain.Center_ptVO;
import com.spring.domain.CustomerVO;
import com.spring.domain.SalesVO;
import com.spring.domain.SearchVO;


public interface SalesMapper {
	public List<SalesVO> salesList();
	public List<CustomerVO> customerList();
	public List<CustomerVO> customerSearch(SearchVO vo);
	public List<Center_ptVO> center_ptList(String customer_cd);
>>>>>>> branch 'master' of https://github.com/gms0417/b2b_v3
	
}
