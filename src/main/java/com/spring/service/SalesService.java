package com.spring.service;

import java.util.List;

<<<<<<< HEAD
import com.spring.domain.CustomerVO;
import com.spring.domain.SalesVO;

public interface SalesService {
	public List<SalesVO> salesList() throws Exception;
	public List<CustomerVO> customerList() throws Exception;
=======
import com.spring.domain.Center_ptVO;
import com.spring.domain.CustomerVO;
import com.spring.domain.SalesVO;
import com.spring.domain.SearchVO;

public interface SalesService {
	public List<SalesVO> salesList() throws Exception;
	public List<CustomerVO> customerList() throws Exception;
	public List<CustomerVO> customerSearch(SearchVO vo) throws Exception;
	public List<Center_ptVO> center_ptList(String customer_cd)throws Exception;
>>>>>>> branch 'master' of https://github.com/gms0417/b2b_v3
}
