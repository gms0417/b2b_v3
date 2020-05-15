<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../layout/header3.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(function() {
		$('#customer_modal').on('hide.bs.modal', function(e) {
			$('#customer_result').html("");
			$('#customer_key').val('');
			$('#customer_criteria').val('customer_cd');
		})
	});
	function changeTrColor(trObj) {
		//행 마우스 올리면 색변환
		trObj.style.backgroundColor = '#F4FFFD';
		trObj.onmouseout = function() {
			trObj.style.backgroundColor = '#FFFFFF';
		}
	}
	function clickTrEvent(trObj) {
		// 행 클릭시 변경 창 보이기

	}
	function customer_modal() {
		$("#customer_modal").modal("show");
	}
	function customer_modal_close() {
		$("#customer_modal").modal("hide");
	}

	function customer_search() {
		if ($('#customer_key').val() == '') {
			alert("검색값을 입력해주세요");
		} else {
			//값 가져오기
			var keyword = document.getElementById("customer_key").value;
			var criteria = document.getElementById("customer_critieria").value;
			$
					.ajax({
						//select.php 로 가서
						url : "customer_search",
						method : "POST",
						//위에서 클릭한 employee_id 데이터를 url로 넘겨주고
						data : {
							'criteria' : criteria,
							'keyword' : keyword
						},
						success : function(data) {

							if (data) {
								var table = "";
								for (var i = 0; i < data.length; i++) {
									var customer_cd = data[i].customer_cd;
									var cusotmer_NM = data[i].customer_NM;
									var pre_NM = data[i].pre_NM;
									var address = data[i].address;
									table += "<div style='width:100%;border:1px solid #cacaca;' onclick='javascript:customer_search_click(this)'>";
									table += "<div style='float:left;height:40px;line-height:40px;background:#FFFFFF';padding:5px; class='cd'' >"
											+ customer_cd
											+ " </div>"
											+ "<div style='height:20px;line-height:20px;background:#F4FFFD' >"
											+ cusotmer_NM
											+ "</div>"
											+ "<div style='height:20px;line-height:20px;display:inline-flex;justify-content:space-around;'><div>"
											+ pre_NM
											+ "</div><div>"
											+ address
											+ "</div></div>";
									table += "</div>";
								}
								$('#customer_result').html(table);
							} else {
								alert("검색 결과가 없습니다.");
							}

						}
					});
		}
	}
	function customer_search_click(obj) {

		var cd = $(obj).children().eq(0).text();
		var nm = $(obj).children().eq(1).text();
		document.getElementById("customer_cd").value = cd;
		document.getElementById("customer_NM").value = nm;

		pt_list();
		cart_list();
	}

	function pt_list() {
		var cd = document.getElementById("customer_cd").value;
		var delivery = $("input[name='delivery']").val();
		$("#customer_modal").modal("hide");
		$
				.ajax({
					url : "center_ptList",
					method : "POST",
					data : {
						'customer_cd' : cd,
						'delivery' : delivery
					},
					success : function(data) {
						var table = "<table><tr><th>선택</th>	<th>센터</th>	<th>상품코드</th><th>상품명</th>"
								+ "<th>단위</th><th>원산지</th><th>보관방법</th><th>면/과세</th><th>공급가</th>"
								+ "<th>부가세</th><th>합계</th><th>마감일</th><th>마감시간</th><th>구매처</th></tr>";
						for (var i = 0; i < data.length; i++) {
							var center_fk = data[i].center_fk;
							var ptcon_cd = data[i].ptcon_cd;
							var pt_cd = data[i].pt_cd;
							var pt_NM = data[i].pt_NM;
							var unit = data[i].unit;
							var origin_NM = data[i].origin_NM;
							var storage_NM = data[i].storage_NM;
							var tax_NM = data[i].tax_NM;
							var sale_cost = data[i].sale_cost;
							var tax = data[i].tax;
							var total = data[i].total;
							var exp_d = data[i].exp_d;
							var exp_t = data[i].exp_t;
							var creditor_fk = data[i].creditor_fk;

							table += "<tr onmouseover='javascript:changeTrColor(this)'"
									+ "onclick='javascript:clickTrEvent(this)'><td><input type='checkbox' class='pt' /></td>"
									+ "<td>"
									+ center_fk
									+ "</td><td>"
									+ pt_cd
									+ "</td><td>"
									+ pt_NM
									+ "</td><td>"
									+ unit
									+ "</td><td>"
									+ origin_NM
									+ "</td><td>"
									+ storage_NM
									+ "</td><td>"
									+ tax_NM
									+ "</td><td>"
									+ sale_cost
									+ "</td><td>"
									+ tax
									+ "</td><td>"
									+ total
									+ "</td><td>"
									+ exp_d
									+ "</td><td>"
									+ exp_t
									+ "</td><td>"
									+ creditor_fk
									+ "</td><input type='hidden' value='"+ptcon_cd+"'><input type='hidden' value=0><input type='hidden' name='delivery' value="+delivery+"></tr>";

						}
						table += "</table>";
						$('#search').html(table);
					}
				});

	}
	function search() {
		var cd = document.getElementById("customer_cd").value;
		if (cd === '') {
			alert("업체를 선택해 주세요");
		} else {
			pt_list();
		}
	}
	
	function save() {
		var cd = document.getElementById("customer_cd").value;
		if (cd === '') {
			alert("업체를 선택해 주세요");
		} else {
			var list = [];
			var param = [];
			var checkbox = $("input:checkbox.cart:checked");
			checkbox.each(function(i) {
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
				$.ajax({
					url : "cart_update",
					method : "POST",
					data : {
						"customer_pk" : cd,
						"ptcon_fk" : td.eq(16).val(),
						"delivery_date" : td.eq(15).text(),
						"amount" : td.eq(10).children,
						"supply_price" : td.eq(9).text(),
						"vat" : td.eq(12).text(),
					},
					success : function(data) {
					},
					error : function(data) {
					}
				});
			});
			cart_list();
		}
	}
	function add_cart() {
		var cd = document.getElementById("customer_cd").value;
		if (cd === '') {
			alert("업체를 선택해 주세요");
		} else {
			var list = [];
			var param = [];
			var checkbox = $("input:checkbox.pt:checked");
			checkbox.each(function(i) {
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
				var date = new Date(td.eq(16).val());
				$.ajax({
					url : "cart_add",
					method : "POST",
					data : {
						"customer_pk" : cd,
						"exp" : td.eq(11).text(),
						"ptcon_fk" : td.eq(14).val(),
						"delivery_date" : td.eq(16).val(),
						"amount" : 1,
						"supply_price" : td.eq(8).text(),
						"vat" : td.eq(9).text(),
						"column5" : td.eq(10).text()
					},
					success : function(data) {

					},
					error : function(data) {
					}
				});
			});
			cart_list();

		}
	}

	function cart_list() {
		var cd = document.getElementById("customer_cd").value;
		$
				.ajax({
					url : "cart_list",
					method : "POST",
					data : {
						"customer_pk" : cd,
					},
					success : function(data) {
						var table = "<table><tr><th>선택</th>	<th>마감일</th><th>센터</th><th>상품코드</th>	<th>상품명</th><th>단위</th><th>원산지</th><th>보관방법</th>"
								+ "<th>면/과세</th>	<th>단가</th>	<th>주문수량</th><th>공급가</th><th>부가세</th>	<th>합계</th>	<th>구매처</th><th>인수일자</th>	</tr>";
						for (var i = 0; i < data.length; i++) {
							var customer_pk = data[i].customer_pk;
							var exp_D = data[i].exp_D;
							var delivery_date = data[i].delivery_date;
							var ptcon_fk = data[i].ptcon_fk;
							var amount = data[i].amount;
							var supply_price = data[i].supply_price;
							var vat = data[i].vat;
							var column5 = data[i].column5;
							var pt_cd = data[i].pt_cd;
							var pt_NM = data[i].pt_NM;
							var unit = data[i].unit;
							var origin_NM = data[i].origin_NM;
							var storage_NM = data[i].storage_NM;
							var tax_NM = data[i].tax_NM;
							var sale_cost = data[i].sale_cost;
							var creditor_fk = data[i].creditor_fk;
							var center_fk = data[i].center_fk;
							table += "<tr><td><input type='checkbox' class='cart' /></td>"
							table += "<td>"
									+ exp_D
									+ "</td><td>"
									+ center_fk
									+ "</td><td>"
									+ pt_cd
									+ "</td><td>"
									+ pt_NM
									+ "</td><td>"
									+ unit
									+ "</td><td>"
									+ origin_NM
									+ "</td><td>"
									+ storage_NM
									+ "</td><td>"
									+ tax_NM
									+ "</td><td>"
									+ sale_cost
									+ "</td><td><input type='text' class='amount' value="+amount+ "></td><td>"
									+ supply_price + "</td><td>" + vat
									+ "</td><td>" + column5 + "</td><td>"
									+ creditor_fk + "</td><td>" + delivery_date
									+ "</td><input type='hidden' value="+ptcon_fk+"><tr>"
						}
						table += "</table>";
						$('#cart').html(table);
					}
				});

	}

	function minus_cart() {
		var cd = document.getElementById("customer_cd").value;
		if (cd === '') {
			alert("업체를 선택해 주세요");
		} else {
			alert("성공");
		}
	}
</script>
<script>
	$(function() {
		$('#datePicker	').datepicker({
			dateFormat : 'yy-mm-dd', //데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
			startDate : '-10d', //달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
			endDate : '+10d', //달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
			autoclose : true, //사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
			calendarWeeks : false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
			clearBtn : false, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
			datesDisabled : [ '2019-06-24', '2019-06-26' ],//선택 불가능한 일 설정 하는 배열 위에 있는 format 과 형식이 같아야함.
			daysOfWeekDisabled : [ 0, 6 ], //선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
			daysOfWeekHighlighted : [ 3 ], //강조 되어야 하는 요일 설정
			disableTouchKeyboard : false, //모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
			immediateUpdates : false, //사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
			multidate : false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false 
			multidateSeparator : ",", //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01,2019-06-01
			templates : {
				leftArrow : '&laquo;',
				rightArrow : '&raquo;'
			}, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
			showWeekDays : true,// 위에 요일 보여주는 옵션 기본값 : true
			title : "테스트", //캘린더 상단에 보여주는 타이틀
			todayHighlight : true, //오늘 날짜에 하이라이팅 기능 기본값 :false 
			toggleActive : true, //이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
			weekStart : 0,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
			language : "ko", //달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
			minDate : 0
		});

		$('#datepicker').datepicker({
			onSelect : function(dateText, inst) {
				$("input[name='delivery']").val(dateText);
				alert("성공");
			}
		});
		$("#datepicker").datepicker({
			minDate : 0
		});
		var date = new Date();
		date.setDate(date.getDate() + 1);
		$("#datePicker").datepicker("setDate", date);
	});//ready end
</script>
<section>
	<article class="contents">
		<div class="form_header">
			<form action="">
				<div class="contents_header">
					<span class="material-icons"> assignment </span> <a> 주문하기</a>
				</div>
				<div id="button">
					<button type="button" onclick="javascript:save()">
						<span class="material-icons"> post_add </span>저장
					</button>
					<button type="button" onclick="javascript:search()">
						<span class="material-icons"> search </span> 조회
					</button>
				</div>
				<div class="formbox">
					
						<label for="" style="padding: 0 5px 0 20px;">고객코드</label> 
						<input							id="customer_cd" readonly onclick="javascript:customer_modal()"							name="customer_cd"> 
					
					<label for=""	style="padding: 0 5px 0 20px;"> <a id="point-star">*</a>
							<span style="padding: 0">인수일자</span>
<input type="text"
							id="datePicker" class="form-control" name="delivery"
							style="display: inline; width: 150px; height:30px; border:1px solid  initial">
						</label>
				

					<label for="" style="padding: 0 5px 0 20px;"> <a
						id="point-star">*</a> <span style="padding: 0">센터</span> <input />
					</label> <label for="" style="padding: 0 5px 0 20px;"> <span
						style="padding: 0">상품코드/명</span> <input />
					</label>
				</div>
			</form>
		</div>

		<!--본문박스 / 스크롤 없애려면 hidden -->
		<div class="contentbox" style="overflow: scroll; height: 300px;">
			<div>
				<div class="table" id="search">
					<table>
						<tr>
							<th>선택</th>
							<th>센터</th>
							<th>상품코드</th>
							<th>상품명</th>
							<th>단위</th>
							<th>원산지</th>
							<th>보관방법</th>
							<th>면/과세</th>

							<th>공급가</th>
							<th>부가세</th>
							<th>합계</th>
							<th>마감일</th>
							<th>마감시간</th>
							<th>구매처</th>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class="order_icon" style="margin: 11px; text-align: center;">
			<span class="material-icons" style="border: 1px solid #cacaca;"
				onclick="javascript:add_cart()"> keyboard_arrow_down </span> <span
				class="material-icons" style="border: 1px solid #cacaca;"
				onclick="javascript:minus_cart()"> keyboard_arrow_up </span>
		</div>

		<div class="contentbox" style="overflow: scroll; height: 300px;">
			<div>
				<div class="table" id="cart">
					<table>
						<tr>
							<th>선택</th>
							<th>마감일</th>
							<th>센터</th>
							<th>상품코드</th>
							<th>상품명</th>
							<th>단위</th>
							<th>원산지</th>
							<th>보관방법</th>
							<th>면/과세</th>
							<th>단가</th>
							<th>주문수량</th>
							<th>부가세</th>
							<th>합계</th>
							<th>구매처</th>
							<th>인수일자</th>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</article>
	<table
		style="width: calc(100% - 20px); margin: 0 10px; boder: 1px solid #cacaca; padding: 5px; padding-left: 20px; color: white;">
		<tbody style="width: 100%; background: #456786;">
			<tr style="width: 100%">
				<th colspan="3" style="background-color: #456786;"><label
					style="padding-left: 20px">[1]개 선택</label></th>
				<th colspan="2" style="background-color: #456786;"></th>
				<th colspan="3" style="background-color: #456786;"><label
					style="padding-left: 20px;">총 수량</label><input value="20" /></th>
				<th colspan="2" style="background-color: #456786;"></th>
				<th colspan="3" style="background-color: #456786;"><label
					style="padding-left: 20px;">총 금액</label><input value="200000" /></th>
			</tr>
		</tbody>
	</table>
</section>
<!-- 판매처 모달 -->
<div class="modal fade" id="customer_modal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<div style="font-size: 18px; color: #186dbf; font-weight: bold;">
					<a> 고 객 사 입 력</a>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
			<div class="modal-body">
				<div style="background-color: #cacaca; padding: 5px 15px">
					<select style="height: 26px;" id="customer_critieria"
						name="customer_criteria">
						<option value="customer_cd">고객사코드</option>
						<option value="customer_NM">고객사명</option>
					</select> <input id="customer_key" name="customer_key"
						style="height: 26px; width: 70%" /> <span class="material-icons"
						onclick="javascript:customer_search()"
						style="vertical-align: middle"> search</span> <input id="center"
						name="center" type="hidden">
				</div>
				<form action="">
					<div id="customer_result" class="contentbox"
						style="overflow: scroll; height: 500px;">
						<!-- 					검색 결과 넣는 곳 							-->
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>