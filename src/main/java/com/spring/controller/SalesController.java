package com.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.domain.Center_ptVO;
import com.spring.domain.CustomerVO;
import com.spring.domain.SearchVO;
import com.spring.service.ProductService;
import com.spring.service.SalesService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping("/sales/*")
public class SalesController {

	
	@Autowired
	SalesService service3;
	
	@Autowired
	ProductService service;
	
	@GetMapping(value="sales_creation")
	public void sales_creation(Model model) {
		log.info("매출등록 페이지");
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	@GetMapping(value="sales_ledger")
	public void sales_ledger() {
		log.info("매출원장 페이지");
		
	}
	
	@GetMapping(value="sales_exception_price")
	public void sales_exception_price() {
		log.info("판가관리 페이지");
		
	}
	@GetMapping(value="accounts_payable")
	public void accounts_payable() {
		log.info("미수금 페이지");
		
	}
	
	//판매처 검색 메소드
	@PostMapping(value="customer_search")
	@ResponseBody
	public List<CustomerVO>  customer_search(SearchVO vo) {
		log.info(vo.toString());
		List<CustomerVO> list = null;
		try {		
			list=service3.customerSearch(vo);
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return list;
	}
	
	//판매처 위치에 따른 상품리스트
	@PostMapping(value="center_ptList")
	@ResponseBody
	public List<Center_ptVO>  center_ptList(String customer_cd,String delivery) {
		log.info("판매처 위치에 따른 상품리스트");
		log.info(customer_cd);
		List<Center_ptVO> list = null;
		delivery=delivery.replace("-", "");
		int day = 0;
		try {		
			Date today = new Date();
			SimpleDateFormat format = new SimpleDateFormat("HH");
			if(Integer.parseInt(format.format(today))>=17) {
				//17시 지났다면
				day = 1;
			}
			 list = service3.center_ptList(day,customer_cd,delivery);
			 
		} catch (Exception e) {
			e.printStackTrace();				
		}
		return list;
	}
	
	
}