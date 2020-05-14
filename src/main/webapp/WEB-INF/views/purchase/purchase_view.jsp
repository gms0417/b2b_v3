<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header3.jsp"></jsp:include>
<script src="http://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.9/js/select2.min.js"></script>
<link	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.9/css/select2.min.css"	rel="stylesheet" />

<script>
function changeTrColor(trObj, oldColor, newColor) {
	trObj.style.backgroundColor = newColor;
	trObj.onmouseout = function() {
		trObj.style.backgroundColor = oldColor;
	}
}
</script>
 
 
 
      <section>
        <article class="contents">
          <div class="form_header">
            <form action="">
              <div class="contents_header">
                <span class="material-icons">
                  assignment
                </span>
                <a> 일일 주문내역</a>
              </div>
              <div id="button">
                <button
                  type="button"
                  onclick="window.open('creditor_creation.html')"
                >
                  <span class="material-icons"> post_add </span>저장
                </button>
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
                  <a id="point-star">*</a>
                  <span>입고일자</span>
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
                  	<th>No</th>
                    <th>사업자번호</th>
                    <th>사업자명</th>
                    <th>주문번호</th>
                    <th>날짜</th>
                    <th>고객명</th>
                    <th>센터</th>
                    <th>상품코드</th>
                    <th>상품명</th>
                    <th>단위</th>            
                    <th>수량</th>             
                    <th>MD</th>
                  </tr>


                  <c:forEach var="vo" items="${list}">
                  <tr onclick="javascript:clickTrEvent(this)"
								onmouseover="javascript:changeTrColor(this, '#FFFFFF', '#F4FFFD')">
                  
                   	<td>No</td>
                   	<td>${vo.creditor_CD }</td>
                   	<td>${vo.creditor_NM }</td>
                    <td>${vo.order_CD}</td>
                    <td>${vo.regdate }</td>
                    <td>${vo.customer_NM }</td>
                    <td>${vo.center }</td>
                    <td>${vo.product_CD}</td>
                    <td>${vo.product_NM}</td>
                    <td>${vo.unit}</td>            
                    <td>${vo.amount}</td>             
                    <td>MD</td>
                  </tr>
                  </c:forEach>
                  
                  
                </table>
              </div>
            </div>
          </div>
        </article>
      </section>
<jsp:include page="../layout/footer.jsp"></jsp:include>