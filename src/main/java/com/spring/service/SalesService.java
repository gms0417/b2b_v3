package com.spring.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.CartVO;
import com.spring.domain.Center_ptVO;
import com.spring.domain.CustomerVO;
import com.spring.domain.PdfVO;
import com.spring.domain.SalesVO;
import com.spring.domain.SearchVO;

public interface SalesService {
	public List<SalesVO> salesList() throws Exception;
	public List<CustomerVO> customerList() throws Exception;
	public List<CustomerVO> customerSearch(SearchVO vo) throws Exception;
	public List<Center_ptVO> center_ptList(int day,String customer_cd,String delivery)throws Exception;
	public boolean cart_add(CartVO vo) throws Exception;
	public boolean cart_update(CartVO vo) throws Exception;
	public boolean cart_delete(CartVO vo) throws Exception;
	public List<CartVO> cart_List(long customer_pk)throws Exception;
	public boolean insert_cu(CustomerVO vo) throws Exception;
	public boolean update_cu(CustomerVO vo) throws Exception;
	public CustomerVO select_cu(long customer_rcd) throws Exception;
	
	public List<PdfVO> sales_ledger() throws Exception;
}
