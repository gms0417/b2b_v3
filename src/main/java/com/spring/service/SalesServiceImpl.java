package com.spring.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.CartVO;
import com.spring.domain.Center_ptVO;
import com.spring.domain.CustomerVO;
import com.spring.domain.PdfVO;
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

	@Override
	public boolean cart_add(CartVO vo) throws Exception {
		
		return mapper.cart_add(vo)>0?true:false;
	}

	@Override
	public boolean cart_update(CartVO vo) throws Exception {
		
		return mapper.cart_update(vo)>0?true:false;
	}

	@Override
	public boolean cart_delete(CartVO vo) throws Exception {
		
		return mapper.cart_delete(vo)>0?true:false;
	}

	@Override
	public List<CartVO> cart_List(long customer_pk) throws Exception {
		
		return mapper.cart_List(customer_pk);
	}
	
	@Override
	public boolean insert_cu(CustomerVO vo) throws Exception {
		return mapper.insert_cu(vo)>0?true:false;
	}

	@Override
	public boolean update_cu(CustomerVO vo) throws Exception {
		return mapper.update_cu(vo)>0?true:false;
	}

	@Override
	public CustomerVO select_cu(long customer_rcd) throws Exception {
		
		return mapper.select_cu(customer_rcd);
	}

	@Override
	public List<PdfVO> sales_ledger() throws Exception {
		// TODO Auto-generated method stub
		return mapper.sales_ledger();
	}


}
