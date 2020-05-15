package com.spring.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.Criteria;
import com.spring.domain.CustomerVO;
import com.spring.domain.PageVO;
import com.spring.domain.ProductVO;
import com.spring.domain.PwVO;
import com.spring.mail.MailHandler;
import com.spring.mail.TempKey;
import com.spring.service.ProductService;
import com.spring.service.PurchaseService;
import com.spring.service.PwService;
import com.spring.service.SalesService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/standartize/*")
public class StandartizeController {
	@Autowired
	ProductService service;

	@Autowired
	PurchaseService service3;
	@Autowired
	private PwService service_pw;
	@Autowired
	SalesService service2;
	@Autowired
	private JavaMailSender mailSender;
	private PasswordEncoder passwordEncoder;

	@GetMapping(value = "product_view")
	public void product_view(@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("상품 페이지 " + cri);
		log.info("category" + cri.getCategory());

		try {

			model.addAttribute("list", service.getList(cri));
			int totalRows = service.totalRows(cri);
			log.info("전체 갯수 " + totalRows);
			model.addAttribute("pageVO", new PageVO(cri, totalRows));

			model.addAttribute("cate", service.getCate());
			model.addAttribute("origin", service.getOrigin());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	//상품 조건 검색
//	@GetMapping("/search")
//	public void search(String keyword, String category , Model model) throws Exception{
//		log.info("상품 검색 :"+keyword+" "+category);
//		ProductVO vo = new ProductVO();
//		
//		try {			
//			int pt_cd = Integer.parseInt(keyword);
//			vo.setPt_cd(pt_cd);
//			vo.setPt_NM("");
//			int category_fk = Integer.parseInt(category);
//			vo.setCategory_fk(category_fk);
//			if(category==null) {
//				category = "0";
//			}
//			if(keyword==null) {
//				keyword = "";
//			}
//		} catch (Exception e) {
//			vo.setPt_NM(keyword);
//			vo.setPt_cd(0);
//		}
//		
//		try {
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.info("카테고리 숫자아닌 경우");
//			return;
//		}				
//	}

	@GetMapping(value = "creditor_view")
	public void creditor_view(Model model) {
		log.info("협력사 페이지");
		try {
			model.addAttribute("list_cr", service3.creditorList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping(value = "customer_view")
	public void customer_view(Model model) {
		log.info("고객사 페이지");
		try {
			model.addAttribute("list_c", service2.customerList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostMapping(value = "add_product")
	public String add_product(ProductVO vo, RedirectAttributes rttr) {
		log.info("상품 삽입" + vo);
		boolean result;
		try {
			result = service.insert_pt(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		rttr.addAttribute("category", vo.getCategory_fk());
		rttr.addAttribute("type", "C");

		return "redirect:product_view";
	}

	@PostMapping(value = "update_product")
//	@ResponseBody
	public String update_product(ProductVO vo, RedirectAttributes rttr) {
		log.info("상품 변경" + vo);
		boolean result;
		// boolean result=false;
		try {
			result = service.update_pt(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		rttr.addAttribute("category", vo.getCategory_fk());
		rttr.addAttribute("type", "C");

		return "redirect:product_view";
	}

	@PostMapping(value = "add_customer")
	public String add_customer(CustomerVO vo, RedirectAttributes rttr) {
		log.info("신규 고객사 등록" + vo);
		passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		boolean result;
		try {
			String password = new TempKey().getKey(10, false);
			vo.setPassword(password);
			result = service2.insert_cu(vo);
			 vo.setPassword(passwordEncoder.encode(vo.getPassword()));
			if (result == true) {
				vo = service2.select_cu(vo.getCustomer_rcd());
				String key = new TempKey().getKey(50, false);
				PwVO pw = new PwVO();
				pw.setEmail(vo.getEmail());
				pw.setKey(key);
				pw.setGroup_GB("cu");
				try {
					if (service_pw.add_pw(pw)) {
						MailHandler sendMail = new MailHandler(mailSender);
						sendMail.setSubject("[비밀번호 변경 이메일 인증]"); // 메일제목
						sendMail.setText( // 메일내용
								"    <div " + 
								"      style='" + 
								"        width: 600px; " + 
								"        height: 600px; " + 
								"        border: 1px solid #cacaca; " + 
								"        margin: 0 auto; " + 
								"      ' " + 
								"    > " + 
								"      <div " + 
								"        style=\" " + 
								"          width: calc(100%-3px); " + 
								"          background-color: #007bb5; " + 
								"          color: white; " + 
								"          padding: 5px; " + 
								"          font-size: 20px; " + 
								"          font-weight: bold; " + 
								"        \" " + 
								"      ></div> " + 
								"      <div " + 
								"        style=\" " + 
								"          color: #007bb5; " + 
								"          font-family: Yj TEUNTEUN; " + 
								"          font-size: 50px; " + 
								"          text-align: center; " + 
								"        \" " + 
								"      > " + 
								"        <p>(주)SJFOOD</p> " + 
								"    " + 
								"      </div> " + 
								"      <div style=\"padding: 0 50px;\"> " + 
								"        <div style=\"font-size: 15px; font-weight: bold;\"> " + 
								"          회원가입을 축하드립니다.<br /><br /> " + 
								"        </div> " + 
								"        <div style=\"font-size: 14px;\"> " + 
								"            본 메일은 (주)삼정식품의 관계사에게 발송되는 메일입니다. <br> " + 
								"            관계자가 아닐 경우 (주)삼정식품으로 문의바랍니다.  " + 
								"             " + 
								"                " + 
								"          <table style=\"padding: 30px;\"> " + 
								"              <tr> " + 
								"                  <th style=\"text-align-last: right;\">회사명</th> " + 
								"                  <td>"+vo.getCustomer_NM()+"</td> " + 
								"                </tr> " + 
								"                 " + 
								"                <tr> " + 
								"                    <th style=\"text-align-last: right;\">아이디</th> " + 
								"                    <td>"+vo.getCustomer_cd()+"</td> " + 
								"                </tr> " + 
								"                 " + 
								"                <tr> " + 
								"                    <th style=\"text-align-last: right;\">초기 비밀번호</th> " + 
								"                    <td>"+vo.getPassword()+"</td> " + 
								"                </tr> " + 
								"                </table> " + 
								"           " + 
								"    " + 
								" " + 
								"           " + 
								"          " + 
								"            비밀번호를 다시 설정하려면 '비밀번호 변경' 버튼을 클릭해주세요. " + 
								"          </div> " + 
								"          <br> " + 
								"          <hr> " + 
								"             <br> <br> " + 
								"      <div style=\"text-align: center;\"> " + 
								"              <a  href='http://192.168.0.9:8080/reset-password?u=cu"
								+ "&key=" + key + "' target='_blenk'"+
								"                style=\"                                     " + 
								"                  background-color: #007bb5; " + 
								"                  border-radius: 5px;                   " + 
								"                  cursor: pointer; " + 
								"                  color: #ffffff; " + 
								"                  font-family: Arial; " + 
								"                  font-size: 20px; " + 
								"                  padding: 12px 37px; " + 
								"                  text-decoration: none; " + 
								"                  padding: 20px 45px;\"                 " + 
								"                                " + 
								"                >비밀번호 변경</a> " + 
								"            </div> " + 
								"            <br> " + 
								"         " + 
								"            <br> " + 
								"    " + 
								"             " + 
								"                <div style=\"text-align: center; font-size: 10px; color: #9c9c9c;\"> " + 
								"                  본 메일은 발신 전용으로 회신이 불가합니다. 문의사항은 담당자에게 연락 바랍니다.<br> " + 
								"                  Copyright © 2020 Distruition All rights reserved. " + 
								"                </div> " + 
								" " + 
								"      </div> " + 
								"    </div>");
						sendMail.setFrom("demian1722@naver.com", "관리자"); // 보낸이
						sendMail.setTo(vo.getEmail()); // 받는이
						sendMail.send();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:customer_view";
	}

	@PostMapping(value = "update_customer")
//	@ResponseBody
	public String update_customer(CustomerVO vo, RedirectAttributes rttr) {
		log.info("고객사 수정 등록" + vo);
		boolean result;
		// boolean result=false;
		try {
			result = service2.update_cu(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		rttr.addAttribute("customer_cd", vo.getCustomer_cd());

		return "redirect:customer_view";
	}
}
