package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.PdfService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/pdf/*")
public class PdfController {
	
	@Autowired
	PdfService service;
	
	
	
	public void orderList() {
		
	}

}
