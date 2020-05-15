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
                <a> 매입원장</a>
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
                  <span>구매처명/코드</span>
                  <input type="text" />
                </label>

                <label for="">
                  <span>일자</span>
                  <input type="text" />
                </label>

                <label for="">
                  <span>상품명/코드</span>
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
                 
                    <th>매입일자</th>
                    <th>구매처코드</th>
                    <th>구매처명</th>
                    <th>센터</th>
                    <th>상품코드</th>
                    <th>상품명</th>
                    <th>단위</th>
					<th>수량</th>
                    <th>매입단가</th>
                    <th>매입액</th>

<c:forEach var="vo" items="${list}"> 
                  <tr>
                
                    <td>${vo.regdate}</td>
                    <td>${vo.creditor_CD}</td>
                    <td>${vo.creditor_NM}</td>
                    <td>${vo.center}</td>
                    <td>${vo.product_CD}</td>
                    <td>${vo.product_NM}</td>
                    <td>${vo.unit}</td>                 
                    <td>${vo.amount}</td>
                    <td>${vo.product_cost}</td>
                    <td>${vo.supply}</td>
                  
                  
                  </tr>
	</c:forEach>
              
                </table>
              </div>
            </div>
          </div>
        </article>
      </section>
<jsp:include page="../layout/footer.jsp"></jsp:include>