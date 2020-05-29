package com.spring.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.PdfVO;
import com.spring.service.PdfService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PdfController {
	
	@Autowired
	PdfService service;
	

//    @GetMapping(value="*/pdf/pdf")
//    public ModelAndView getPdf(Model model, @RequestParam(value="order_cd",  required=false) String order_cd) throws Exception {
//    	 	
//    	
//    	System.out.println(order_cd);
//    	model.addAttribute("pdf",service.order_cd(order_cd));
//    	System.out.println("PDF 테스트");
//
//        return new ModelAndView("pdf", "pdf", service.pdf());
// 
//    }
    
    @GetMapping(value="*/pdfView")
    public ModelAndView pdfView(String order_CD) throws Exception {    	

    	 return new ModelAndView("pdfView", "pdfView",service.pdfView(order_CD));
    	
    }       
    	

    
  
}
