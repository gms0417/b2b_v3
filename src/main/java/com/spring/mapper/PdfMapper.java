package com.spring.mapper;

import java.util.List;

import com.spring.domain.PdfVO;

public interface PdfMapper {
	
	public List<PdfVO>orderList();	
	public List<PdfVO> pdf();


	
	
	public  List<PdfVO> pdfView (String order_CD);
}
