package com.spring.pdf;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfCell;
import com.spring.domain.PdfVO;

import javafx.scene.layout.Border;
 

public class PdfBuilder extends AbstractITextPdfView {
	

 
	@Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
    	
    			// 폰트설정
	    	String fontPath = "D:/b2b_v3/src/main/resources/pdf/NanumGothic.ttf";
	    	String fontPath2="c:/windows/Fonts/malgun.ttf";
	    	String forName = "NanumGothic";
	    	BaseFont bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	    	BaseFont bf2 = BaseFont.createFont(fontPath2, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	    	Font font = new Font(bf2, 7, Font.UNDEFINED);
	    	Font font2 = new Font(bf, 15, Font.BOLD);
	    	Font font3 = new Font(bf, 8, Font.NORMAL);
	    	Font font4 = new Font(bf, 7, Font.NORMAL);
	    	Font font5 = new Font(bf2, 7, Font.NORMAL);
	    	
	    	
			// Pdf리스트 불러오기
	    	List<PdfVO> pdftest = (List<PdfVO>) model.get("pdfView");
	    	System.out.println(pdftest);
	    	
	    	
	    	
	    	
	    	
		   
		   // 제목 
		   Paragraph title = new Paragraph("납품서(공급받는자용)",font2);
		   title.setAlignment(Element.ALIGN_CENTER);
		   document.add(title);
		   
		   document.add(new Paragraph("\r\n"));

		   
		   // 인감도장//
		  Image jpg = Image.getInstance("D:/b2b_v3/src/main/webapp/resources/img/im.png");
		  jpg.setAbsolutePosition(250, 690);
		  jpg.scaleToFit(50, 50);
		  document.add(jpg);
		   
		   document.add(new Paragraph("\r\n"));

		   
		   // 공급자, 공급받는자
		   PdfPTable t_table = new PdfPTable(12);
		   t_table.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_table.setWidths(new int[] {50,190,100,100,100,100,50,190,100,100,100,100});		   

		   PdfPCell t_title1 = new PdfPCell(new Paragraph("공\n급\n자", font3));
		   t_title1.setRowspan(4);

		   PdfPCell t_title2 = new PdfPCell(new Paragraph("상  호", font3));
		   PdfPCell t_title3 = new PdfPCell(new Paragraph("(주)SJ FOOD", font));
		   t_title3.setColspan(4);
		   t_title3.setFixedHeight(20);
		   
		   PdfPCell t_title4 = new PdfPCell(new Paragraph("사업자번호", font3));
		   PdfPCell t_title5 = new PdfPCell(new Paragraph("6038196110", font));
		   t_title5.setColspan(2);
		   t_title5.setFixedHeight(20);
		   
		   PdfPCell t_title6 = new PdfPCell(new Paragraph("성명", font3));
		   PdfPCell t_title7 = new PdfPCell(new Paragraph("강석화",font));
		   
		   PdfPCell t_title8 = new PdfPCell(new Paragraph("주  소", font3));
		   PdfPCell t_title9 = new PdfPCell(new Paragraph("서울시 노원구 공릉로 37", font));
		   t_title9.setColspan(4);
		   t_title9.setFixedHeight(20);
		   PdfPCell t_title10 = new PdfPCell(new Paragraph("업  종", font3));
		   PdfPCell t_title11 = new PdfPCell(new Paragraph("유통", font));
		   t_title11.setColspan(2);
		   t_title11.setFixedHeight(20);
		   PdfPCell t_title12 = new PdfPCell(new Paragraph("업태", font3));
		   PdfPCell t_title13= new PdfPCell(new Paragraph("식품외", font));
		   
		   t_title1.setBackgroundColor(WebColors.getRGBColor("#ececec"));


		   
		   PdfPCell t_title14 = new PdfPCell(new Paragraph("공\n급\n받\n는\n자", font3));
		   t_title14.setRowspan(4);
		   PdfPCell t_title15 = new PdfPCell(new Paragraph("상  호", font3));
		   PdfPCell t_title16 = new PdfPCell(new Paragraph(pdftest.get(0).getCustomer_NM(), font));
		   t_title16.setColspan(4);

		   PdfPCell t_title17 = new PdfPCell(new Paragraph("사업자번호", font3));
		   PdfPCell t_title18 = new PdfPCell(new Paragraph(pdftest.get(0).getC_rcd(), font));
		   t_title18.setColspan(2);
		   PdfPCell t_title19 = new PdfPCell(new Paragraph("성명", font3));	
		   PdfPCell t_title20 = new PdfPCell(new Paragraph(pdftest.get(0).getC_pre_nm(), font));
		   
		   PdfPCell t_title21 = new PdfPCell(new Paragraph("주  소", font3));
		   PdfPCell t_title22 = new PdfPCell(new Paragraph(pdftest.get(0).getC_pre_nm(), font));
		   t_title22.setColspan(4);
		   
		   PdfPCell t_title23 = new PdfPCell(new Paragraph("업  종", font3));
		   PdfPCell t_title24 = new PdfPCell(new Paragraph("유통", font));
		   t_title24.setColspan(2);
		   PdfPCell t_title25 = new PdfPCell(new Paragraph("업태", font3));
		   PdfPCell t_title26= new PdfPCell(new Paragraph("기타", font));
		   

		   
		

		   

		   
		   				// 정렬
		   t_title1.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title2.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title3.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title4.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title5.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title6.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title7.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title8.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title9.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title10.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title11.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title12.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title13.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title5.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title6.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title7.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title8.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title9.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title10.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title11.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title12.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title13.setVerticalAlignment(Element.ALIGN_MIDDLE);

		   t_title14.setBackgroundColor(WebColors.getRGBColor("#ececec"));
		   
		   t_title14.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title15.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title16.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title17.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title18.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title19.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title20.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title21.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title22.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title23.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title24.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title25.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title26.setHorizontalAlignment(Element.ALIGN_CENTER);
		   t_title14.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title15.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title16.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title17.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title18.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title19.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title20.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title21.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title22.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title23.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title24.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title25.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   t_title26.setVerticalAlignment(Element.ALIGN_MIDDLE);


		   // 공급자 , 상호
		   t_table.addCell(t_title1);
		   t_table.addCell(t_title2);
		   t_table.addCell(t_title3);
		   t_table.addCell(t_title14);
		   t_table.addCell(t_title15);
		   t_table.addCell(t_title16);
		   
		  
		   
		   // 사업자등록번호, 대표자명
		   t_table.addCell(t_title4);
		   t_table.addCell(t_title5);
		   t_table.addCell(t_title6);	
		   t_table.addCell(t_title7);
		   
		   t_table.addCell(t_title17);
		   t_table.addCell(t_title18);
		   t_table.addCell(t_title19);	
		   t_table.addCell(t_title20);
		
		   
		   // 사업자주소
		   t_table.addCell(t_title8);
		   t_table.addCell(t_title9);
		   t_table.addCell(t_title21);
		   t_table.addCell(t_title22);
	
		   // 업종, 업태
		   t_table.addCell(t_title10);
		   t_table.addCell(t_title11);
		   t_table.addCell(t_title12);
		   t_table.addCell(t_title13);
		   t_table.addCell(t_title25);
		   t_table.addCell(t_title26);
		   
		   

		   
		   
		   t_table.addCell(t_title23);
		   t_table.addCell(t_title24);
		   

		   document.add(t_table);
		   document.add(new Paragraph("\r\n"));
		   
		   

		   
	
		   
		   int a =9;
		   PdfPTable table = new PdfPTable(a);
		   table.setWidths(new int[] {20,100,200,30,30,50,50,30,60});
		   table.setHorizontalAlignment(Element.ALIGN_CENTER);
		   PdfPCell title1 = new PdfPCell(new Paragraph("No",font3));
		   PdfPCell title2 = new PdfPCell(new Paragraph("주문번호",font3));
//		   PdfPCell title3 = new PdfPCell(new Paragraph("상품코드",font3));
		   PdfPCell title4 = new PdfPCell(new Paragraph("상품명",font3));
		   PdfPCell title5 = new PdfPCell(new Paragraph("단위",font3));
		   PdfPCell title6 = new PdfPCell(new Paragraph("수량",font3));
		   PdfPCell title7 = new PdfPCell(new Paragraph("단가",font3));
		   PdfPCell title8 = new PdfPCell(new Paragraph("공급가",font3));
		   PdfPCell title9 = new PdfPCell(new Paragraph("VAT",font3));
		   PdfPCell title10 = new PdfPCell(new Paragraph("합계",font3));
		   title1.setFixedHeight(18);

		   title1.setBackgroundColor(WebColors.getRGBColor("#ececec"));
		   title2.setBackgroundColor(WebColors.getRGBColor("#ececec"));
//		   title3.setBackgroundColor(WebColors.getRGBColor("#ececec"));
		   title4.setBackgroundColor(WebColors.getRGBColor("#ececec"));
		   title5.setBackgroundColor(WebColors.getRGBColor("#ececec"));
		   title6.setBackgroundColor(WebColors.getRGBColor("#ececec"));
		   title7.setBackgroundColor(WebColors.getRGBColor("#ececec"));
		   title8.setBackgroundColor(WebColors.getRGBColor("#ececec"));
		   title9.setBackgroundColor(WebColors.getRGBColor("#ececec"));
		   title10.setBackgroundColor(WebColors.getRGBColor("#ececec"));

		   title1.setHorizontalAlignment(Element.ALIGN_CENTER);
		   title2.setHorizontalAlignment(Element.ALIGN_CENTER);
//		   title3.setHorizontalAlignment(Element.ALIGN_CENTER);
		   title4.setHorizontalAlignment(Element.ALIGN_CENTER);
		   title5.setHorizontalAlignment(Element.ALIGN_CENTER);
		   title6.setHorizontalAlignment(Element.ALIGN_CENTER);
		   title7.setHorizontalAlignment(Element.ALIGN_CENTER);
		   title8.setHorizontalAlignment(Element.ALIGN_CENTER);
		   title9.setHorizontalAlignment(Element.ALIGN_CENTER);
		   title10.setHorizontalAlignment(Element.ALIGN_CENTER);

		   title1.setVerticalAlignment(Element.ALIGN_CENTER);
		   title2.setVerticalAlignment(Element.ALIGN_CENTER);
//		   title3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   title4.setVerticalAlignment(Element.ALIGN_CENTER);
		   title5.setVerticalAlignment(Element.ALIGN_CENTER);
		   title6.setVerticalAlignment(Element.ALIGN_CENTER);
		   title7.setVerticalAlignment(Element.ALIGN_CENTER);
		   title8.setVerticalAlignment(Element.ALIGN_CENTER);
		   title9.setVerticalAlignment(Element.ALIGN_CENTER);
		   title10.setVerticalAlignment(Element.ALIGN_CENTER);
//		   
		   
		   table.addCell(title1);
		   table.addCell(title2);
//		   table.addCell(title3);
		   table.addCell(title4);
		   table.addCell(title5);
		   table.addCell(title6);
		   table.addCell(title7);
		   table.addCell(title8);
		   table.addCell(title9);
		   table.addCell(title10);
		   
		   
		   
		   for (PdfVO aPdf : pdftest) {
			   
			   PdfPCell rn = new PdfPCell(new Phrase(String.valueOf((aPdf.getRn())),font4));
			   rn.setHorizontalAlignment(Element.ALIGN_CENTER);
			   table.addCell(rn);

		  
			   PdfPCell order_cd = new PdfPCell(new Phrase(aPdf.getOrder_CD(),font4));
			   order_cd.setHorizontalAlignment(Element.ALIGN_CENTER);
			   table.addCell(order_cd);
			   
			   PdfPCell product_nm = new PdfPCell(new Phrase(aPdf.getProduct_NM(),font));
			   order_cd.setHorizontalAlignment(Element.ALIGN_CENTER);
			   table.addCell(product_nm);
			   
			   PdfPCell unit = new PdfPCell(new Phrase(aPdf.getUnit(),font4));
			   order_cd.setHorizontalAlignment(Element.ALIGN_CENTER);
			   table.addCell(unit);
			   
			   PdfPCell amount = new PdfPCell(new Phrase(String.valueOf((aPdf.getAmount())),font));
			   order_cd.setHorizontalAlignment(Element.ALIGN_RIGHT);
			   table.addCell(amount);
			   
			   PdfPCell s_product_cost = new PdfPCell(new Phrase(String.valueOf((aPdf.getS_product_cost())),font));
			   order_cd.setHorizontalAlignment(Element.ALIGN_RIGHT);
			   table.addCell(s_product_cost);
			   
			   PdfPCell s_supply = new PdfPCell(new Phrase(String.valueOf((aPdf.getS_supply())),font));
			   order_cd.setHorizontalAlignment(Element.ALIGN_RIGHT);
			   table.addCell(s_supply);
			   
			   PdfPCell tax_sum = new PdfPCell(new Phrase(String.valueOf((aPdf.getS_tax_sum())),font));
			   order_cd.setHorizontalAlignment(Element.ALIGN_RIGHT);
			   table.addCell(tax_sum);
		   
			   PdfPCell s_total = new PdfPCell(new Phrase(String.valueOf((aPdf.getS_total())),font));
			   order_cd.setHorizontalAlignment(Element.ALIGN_RIGHT);
			   table.addCell(s_total);


		        }
	

		   

		   document.add(table);
		   
		   
		   
		   
		   // ---------------------------------------------------------------
		   
		   document.add(new Paragraph("\r\n\n"));

		   PdfPTable last_table = new PdfPTable(4);
		   last_table.setWidths(new int[] {50,80,50,80});

		   
		 

		   PdfPCell a_title1 = new PdfPCell(new Paragraph("당당영업사원",font3));
		   PdfPCell a_title2 = new PdfPCell(new Paragraph(pdftest.get(0).getEmp_nm(),font));
		   PdfPCell a_title3 = new PdfPCell(new Paragraph("영업사원 연락처",font3));
		   PdfPCell a_title4 = new PdfPCell(new Paragraph(pdftest.get(0).getEmp_phone(),font));
		   
		   PdfPCell a_title5 = new PdfPCell(new Paragraph("출고처",font3));
		   PdfPCell a_title6 = new PdfPCell(new Paragraph(pdftest.get(0).getCreditor_NM(),font));
		   PdfPCell a_title7 = new PdfPCell(new Paragraph("출고처 주소",font3));
		   PdfPCell a_title8 = new PdfPCell(new Paragraph(pdftest.get(0).getAdress(),font));
		   
		   PdfPCell a_title9 = new PdfPCell(new Paragraph("납품처 연락처",font3));
		   PdfPCell a_title10 = new PdfPCell(new Paragraph(pdftest.get(0).getC_contact(),font));
		   PdfPCell a_title11 = new PdfPCell(new Paragraph("납품처 주소",font3));
		   PdfPCell a_title12 = new PdfPCell(new Paragraph(pdftest.get(0).getC_address(),font));
		   
		   PdfPCell a_title13 = new PdfPCell(new Paragraph("인수자",font3));
		   PdfPCell a_title14 = new PdfPCell(new Paragraph("",font));
		   PdfPCell a_title15 = new PdfPCell(new Paragraph("서명",font3));
		   PdfPCell a_title16 = new PdfPCell(new Paragraph("",font));
		   
		   PdfPCell a_title17 = new PdfPCell(new Paragraph("메   모",font3));
		   PdfPCell a_title18 = new PdfPCell(new Paragraph("",font));
		   a_title18.setColspan(3);

		   
		   a_title1.setFixedHeight(20);
		   a_title5.setFixedHeight(20);
		   a_title9.setFixedHeight(20);
		   a_title13.setFixedHeight(20);
		   a_title17.setFixedHeight(60);
		   
		   a_title1.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title2.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title3.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title4.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title5.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title6.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title7.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title8.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title9.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title10.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title11.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title12.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title13.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title14.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title15.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title16.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title17.setHorizontalAlignment(Element.ALIGN_CENTER);
		   a_title1.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title2.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title3.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title4.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title5.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title6.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title7.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title8.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title9.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title10.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title11.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title12.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title13.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title14.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title15.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title16.setVerticalAlignment(Element.ALIGN_CENTER);
		   a_title17.setVerticalAlignment(Element.ALIGN_MIDDLE);

		   
		   a_title1.getVerticalAlignment();
		   a_title1.getHorizontalAlignment();

		   last_table.addCell(a_title1);
		   last_table.addCell(a_title2);
		   last_table.addCell(a_title3);
		   last_table.addCell(a_title4);
		   last_table.addCell(a_title5);
		   last_table.addCell(a_title6);
		   last_table.addCell(a_title7);
		   last_table.addCell(a_title8);
		   last_table.addCell(a_title9);
		   last_table.addCell(a_title10);
		   last_table.addCell(a_title11);
		   last_table.addCell(a_title12);
		   last_table.addCell(a_title13);
		   last_table.addCell(a_title14);
		   last_table.addCell(a_title15);
		   last_table.addCell(a_title16);
		   last_table.addCell(a_title17);
		   last_table.addCell(a_title18);

		   document.add(last_table);
		   
		   
		   
		   
		   document.setMargins(0, 0, 0, 0);
		   
		   document.close();
		   System.out.println("완료");
         
    }
 
}