package com.spring.pdf;

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
import com.spring.service.PdfService;

public class invoice {
	

	   public static void main(String[] args) throws DocumentException, IOException {

		   PurchaseController controller = new PurchaseController();
		   
		   
		   
		   
		   
			// 기본 Document를 생성한다.
			   Document document = new Document(PageSize.A4, 0,0,30,30);
			   
			   // PDF가 저장될 위치를 지정한다.
			   PdfWriter.getInstance(document, new FileOutputStream("sample.pdf"));

			   String fontPath = "src/main/webapp/resources/font/NanumGothic-Regular.ttf";
			   String forName = "NanumGothic-Regular";
			   BaseFont bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			   Font font = new Font(bf, 9, Font.UNDEFINED);
			   Font font2 = new Font(bf, 20, Font.BOLD);
			   Font font3 = new Font(bf, 10, Font.BOLD);
			   
			   document.open();
			   
			   
			   // 제목 
			   Paragraph title = new Paragraph("납품서(공급받는자용)",font2);
			   title.setAlignment(Element.ALIGN_CENTER);
			   document.add(title);
			   
			   document.add(new Paragraph("\r\n\n"));

			   
			   // 인감도장//
			  Image jpg = Image.getInstance("src/main/webapp/resources/img/im.png");
			  jpg.setAbsolutePosition(250, 660);
			  jpg.scaleToFit(50, 50);
			  document.add(jpg);
			   
			   document.add(new Paragraph("\r\n"));
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
			   PdfPCell t_title5 = new PdfPCell(new Paragraph("603-81-96110", font));
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
			   


			   PdfPCell t_title14 = new PdfPCell(new Paragraph("공\n급\n받\n는\n자", font3));
			   t_title14.setRowspan(4);
			   PdfPCell t_title15 = new PdfPCell(new Paragraph("상  호", font3));
			   PdfPCell t_title16 = new PdfPCell(new Paragraph("*", font));
			   t_title16.setColspan(4);
			   
			   PdfPCell t_title17 = new PdfPCell(new Paragraph("사업자번호", font3));
			   PdfPCell t_title18 = new PdfPCell(new Paragraph("*", font));
			   t_title18.setColspan(2);
			   PdfPCell t_title19 = new PdfPCell(new Paragraph("성명", font3));	
			   PdfPCell t_title20 = new PdfPCell(new Paragraph("*", font));
			   
			   PdfPCell t_title21 = new PdfPCell(new Paragraph("주  소", font3));
			   PdfPCell t_title22 = new PdfPCell(new Paragraph("*", font));
			   t_title22.setColspan(4);
			   
			   PdfPCell t_title23 = new PdfPCell(new Paragraph("업  종", font3));
			   PdfPCell t_title24 = new PdfPCell(new Paragraph("*", font));
			   t_title24.setColspan(2);
			   PdfPCell t_title25 = new PdfPCell(new Paragraph("업태", font3));
			   PdfPCell t_title26= new PdfPCell(new Paragraph("*", font));
			   
			   
			   t_title1.setBackgroundColor(WebColors.getRGBColor("#ececec"));
			   t_title14.setBackgroundColor(WebColors.getRGBColor("#ececec"));

			   
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
			   
			   t_table.addCell(t_title23);
			   t_table.addCell(t_title24);
			   t_table.addCell(t_title25);
			   t_table.addCell(t_title26);
			   

			
			   

			   
			   
			   document.add(t_table);
			   document.add(new Paragraph("\r\n"));
			   int a =9;
			   PdfPTable table = new PdfPTable(a);
			   table.setWidths(new int[] {20,50,100,50,50,50,50,30,60});
			   table.setHorizontalAlignment(Element.ALIGN_CENTER);
			   PdfPCell title1 = new PdfPCell(new Paragraph("No",font3));
			   PdfPCell title2 = new PdfPCell(new Paragraph("주문번호",font3));
//			   PdfPCell title3 = new PdfPCell(new Paragraph("상품코드",font3));
			   PdfPCell title4 = new PdfPCell(new Paragraph("상품명",font3));
			   PdfPCell title5 = new PdfPCell(new Paragraph("단위",font3));
			   PdfPCell title6 = new PdfPCell(new Paragraph("수량",font3));
			   PdfPCell title7 = new PdfPCell(new Paragraph("단가",font3));
			   PdfPCell title8 = new PdfPCell(new Paragraph("공급가",font3));
			   PdfPCell title9 = new PdfPCell(new Paragraph("VAT",font3));
			   PdfPCell title10 = new PdfPCell(new Paragraph("합계",font3));
			   title1.setFixedHeight(20);

			   title1.setBackgroundColor(WebColors.getRGBColor("#ececec"));
			   title2.setBackgroundColor(WebColors.getRGBColor("#ececec"));
//			   title3.setBackgroundColor(WebColors.getRGBColor("#ececec"));
			   title4.setBackgroundColor(WebColors.getRGBColor("#ececec"));
			   title5.setBackgroundColor(WebColors.getRGBColor("#ececec"));
			   title6.setBackgroundColor(WebColors.getRGBColor("#ececec"));
			   title7.setBackgroundColor(WebColors.getRGBColor("#ececec"));
			   title8.setBackgroundColor(WebColors.getRGBColor("#ececec"));
			   title9.setBackgroundColor(WebColors.getRGBColor("#ececec"));
			   title10.setBackgroundColor(WebColors.getRGBColor("#ececec"));

			   title1.setHorizontalAlignment(Element.ALIGN_CENTER);
			   title2.setHorizontalAlignment(Element.ALIGN_CENTER);
//			   title3.setHorizontalAlignment(Element.ALIGN_CENTER);
			   title4.setHorizontalAlignment(Element.ALIGN_CENTER);
			   title5.setHorizontalAlignment(Element.ALIGN_CENTER);
			   title6.setHorizontalAlignment(Element.ALIGN_CENTER);
			   title7.setHorizontalAlignment(Element.ALIGN_CENTER);
			   title8.setHorizontalAlignment(Element.ALIGN_CENTER);
			   title9.setHorizontalAlignment(Element.ALIGN_CENTER);
			   title10.setHorizontalAlignment(Element.ALIGN_CENTER);

			   title1.setVerticalAlignment(Element.ALIGN_CENTER);
			   title2.setVerticalAlignment(Element.ALIGN_CENTER);
//			   title3.setVerticalAlignment(Element.ALIGN_MIDDLE);
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
//			   table.addCell(title3);
			   table.addCell(title4);
			   table.addCell(title5);
			   table.addCell(title6);
			   table.addCell(title7);
			   table.addCell(title8);
			   table.addCell(title9);
			   table.addCell(title10);
			   

			   PdfPCell[] cells = new PdfPCell[a];
			   for(int i=0; i<a; i++) {

				   cells[i] = new PdfPCell(new Paragraph("Cell " + i + 1));
				   int result = i;
				   table.addCell(""+result);
//				   table.setPaddingTop(20);
//				   cells[i].setVerticalAlignment(Element.ALIGN_MIDDLE);
//				   cells[i].setHorizontalAlignment(Element.ALIGN_CENTER);
			   }
			   
//			   table.addCell("1");
//			   table.addCell("2");
//			   table.addCell("3");
//			   table.addCell("4");
//			   table.addCell("5");
//			   table.addCell("6");
//			   table.addCell("7");
//			   table.addCell("8");
//			   table.addCell("9");
//			   table.addCell("10");
//			   
//			   table.addCell("1");
//			   table.addCell("2");
//			   table.addCell("3");
//			   table.addCell("4");
//			   table.addCell("5");
//			   table.addCell("6");
//			   table.addCell("7");
//			   table.addCell("8");
//			   table.addCell("9");
//			   table.addCell("10");

			   document.add(table);
			   
			   
			   
			   
			   // ---------------------------------------------------------------
			   
			   document.add(new Paragraph("\r\n\n"));

			   PdfPTable last_table = new PdfPTable(4);
			   last_table.setWidths(new int[] {50,80,50,80});


			   PdfPCell a_title1 = new PdfPCell(new Paragraph("당당영업사원",font3));
			   PdfPCell a_title2 = new PdfPCell(new Paragraph("*",font));
			   PdfPCell a_title3 = new PdfPCell(new Paragraph("영업사원 연락처",font3));
			   PdfPCell a_title4 = new PdfPCell(new Paragraph("*",font));
			   
			   PdfPCell a_title5 = new PdfPCell(new Paragraph("출고처",font3));
			   PdfPCell a_title6 = new PdfPCell(new Paragraph("*",font));
			   PdfPCell a_title7 = new PdfPCell(new Paragraph("출고처 주소",font3));
			   PdfPCell a_title8 = new PdfPCell(new Paragraph("*",font));
			   
			   PdfPCell a_title9 = new PdfPCell(new Paragraph("납품처 연락처",font3));
			   PdfPCell a_title10 = new PdfPCell(new Paragraph("*",font));
			   PdfPCell a_title11 = new PdfPCell(new Paragraph("납품처 주소",font3));
			   PdfPCell a_title12 = new PdfPCell(new Paragraph("*",font));
			   
			   PdfPCell a_title13 = new PdfPCell(new Paragraph("인수자",font3));
			   PdfPCell a_title14 = new PdfPCell(new Paragraph("*",font));
			   PdfPCell a_title15 = new PdfPCell(new Paragraph("서명",font3));
			   PdfPCell a_title16 = new PdfPCell(new Paragraph("*",font));
			   
			   PdfPCell a_title17 = new PdfPCell(new Paragraph("메   모",font3));
			   PdfPCell a_title18 = new PdfPCell(new Paragraph("*",font));
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
