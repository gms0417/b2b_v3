package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.CartVO;
import com.spring.domain.Center_ptVO;
import com.spring.domain.CustomerVO;
import com.spring.domain.SalesVO;
import com.spring.domain.SearchVO;

public interface SalesMapper {
	public List<SalesVO> salesList();
	public List<CustomerVO> customerList();
	public List<CustomerVO> customerSearch(SearchVO vo);
	public List<Center_ptVO> center_ptList(@Param("day")int day,@Param("customer_cd")String customer_cd,@Param("delivery")String delivery);
	public int cart_add(CartVO vo);
	public int cart_update(CartVO vo);
	public int cart_delete(CartVO vo);
	public List<CartVO> cart_List(@Param("customer") long customer);
	
}
