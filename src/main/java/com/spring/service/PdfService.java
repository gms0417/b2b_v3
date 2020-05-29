
package com.spring.service;


import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.PdfVO;



public interface PdfService {
	public List<PdfVO> getOrderList() throws Exception;	
	public List<PdfVO> orderList() throws Exception;		

	
	
	public  List<PdfVO> pdfView (String order_CD);
	
}