package com.spring.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring.controller.PurchaseController;
import com.spring.domain.PdfVO;
import com.spring.mapper.PdfMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring.controller.PurchaseController;
import com.spring.domain.PdfVO;


@Service
public class PdfServiceImpl implements PdfService {

	@Autowired
	PdfMapper mapper;
	
	@Override
	public List<PdfVO> getOrderList() throws Exception { 
//		pdf_test();
		System.out.println("serviceImpl");
		return mapper.orderList();
	}

	@Override
	public List<PdfVO> orderList() throws Exception {
		
		
		return mapper.orderList();
	}





	
	
	@Override
	public  List<PdfVO> pdfView(String order_CD) {
		return mapper.pdfView(order_CD);
	}


}
