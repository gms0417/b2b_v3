<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="../layout/header3.jsp"></jsp:include>
   <section>

        <article class="contents">
          <div class="form_header">
            <form action="">
              <div class="contents_header">
                <span class="material-icons">
                  assignment
                </span>
                <a> 매출원장</a>
              </div>
              <div id="button">
                <button type="submit">
                  <span class="material-icons">
                    search
                  </span>
                  조회
                </button>
              </div>
              <div class="formbox">
                <label for="">
                  <a id="point-star">*</a>
                  <span>기간</span>
                  <input type="text" style="width: 75px;" /> ~
                  <input type="text" style="width: 75px;" />
                </label>


                <label for="">
                  <span>고객코드/명</span>
                  <input type="text" />
                </label>

               
              </div>
            </form>
          </div>

          <!--본문박스 / 스크롤 없애려면 hidden -->
          <div class="contentbox" style="overflow: scroll;">
            <div id="contentbox_header">
              <div class="table">
                <table>
                  <tr>
                   
                    <th>일자</th>
                    <th>주문번호</th>
          
                    <th>고객명</th>
                    <th>센터</th>
                    <th>상품코드</th>
                    <th>상품명</th>
                    <th>단위</th>
                   
                    <th>수량</th>
                   
                    <th>매출단가</th>
                    <th>매출액</th>
                    <th>부가세</th>
                    <th>총 매출액</th>
          
            
                  </tr>
                  
		<c:forEach var="vo" items="${list}"> 
                  <tr>
                   
                    <td>${vo.regdate}</td>
                    <td><a href="pdfView?order_CD=${vo.order_CD}" id="pdfView" name="pdfView">${vo.order_CD}</a></td>
                    <td>${vo.customer_NM}</td>
                    <td>${vo.center}</td>
                    <td>${vo.product_CD}</td>
                    <td>${vo.product_NM}</td>
                    <td>${vo.unit}</td>
              
                    <td>${vo.amount}</td>
                  
                    <td>${vo.s_product_cost}</td>
                    <td>${vo.s_supply}</td>
                    <td>${vo.s_tax_sum}</td>
                    <td>${vo.s_total}</td>
               
                  </tr>
			</c:forEach>
			
              
                  
                
                </table>
              </div>
            </div>
          </div>
        </article>
      </section>

<jsp:include page="../layout/footer.jsp"></jsp:include>