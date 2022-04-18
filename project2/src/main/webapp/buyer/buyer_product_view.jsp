<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<link href="/css/buyer_product_view.css" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script>
function fnAddCart(pro_uid){
	if(confirm("해당 상품을 장바구니에 추가하겠습니까?")){
		location.href="/buyer/buyer_cart_list?pro_uid="+pro_uid;	
	}else{
		return false;
	}
}
</script>
<script>

$(document).ready(function(){
	$('#pro_count').change(function(){
		$('#total_price').val((Number($('#pro_count').val()) * ${list.pro_price }).toLocaleString("ko-KR"));
		const total_price = ($('#total_price').val()).replace(/,/g,"");
		$('#pro_point').val((Math.round(Number(total_price* 0.01))).toLocaleString("ko-KR"));
	});
});

function pro_save(pro_uid) {
	if(confirm("찜 하시겠습니까?") == true){
		location.href="/buyer/buyersave?pro_uid="+pro_uid;
	}else{
		return false;
	}
	
}

function cart_insert(aaa){
	cart.pro_type.value = aaa;
	
	if(cart.pro_count.value == ""){
		alert("수량을 선택하세요.");
		cart.pro_count.focus();
		return;
	}	
	
	document.cart.submit();
}

//상품상세, 상품평, 상품문의 버튼 jquery
$(document).ready(function(){
	$('.view_middle3').click(function(){
		$('.view_middle3').css('background','#ef9696');
		$('.view_middle1').css('background','#f0f0f0');
		$('.view_middle2').css('background','#f0f0f0');
		$('#view_qna_box').show();
		$('#view_detailing_box').hide();
		$('#view_review_box').hide();
	});
	
	$('.view_middle2').click(function(){
		$('.view_middle2').css('background','#ef9696');
		$('.view_middle1').css('background','#f0f0f0');
		$('.view_middle3').css('background','#f0f0f0');
		$('#view_review_box').show();
		$('#view_qna_box').hide();
		$('#view_detailing_box').hide();
	});
	
	$('.view_middle1').click(function(){
		$('.view_middle1').css('background','#ef9696');
		$('.view_middle3').css('background','#f0f0f0');
		$('.view_middle2').css('background','#f0f0f0');
		$('#view_detailing_box').show();
		$('#view_qna_box').hide();
		$('#view_review_box').hide();
	});
});

function qna_go(pro_uid,pro_name,pro_salname) {
	window.open("buyer_product_qna.jsp?pro_uid="+pro_uid+"&pro_name="+pro_name+"&pro_salname="+pro_salname+"", "pro_question", "width=485, height=360");
}

</script>
<div style="height:30px;"> </div>
<div style="width:1720px;">
	<div style="width:450px; display:inline-block;"></div>
		<div style="width:900px; display:inline-block;">
			<c:choose>
			<c:when test="${pro_cate eq '1'}">
				<div style="font-size:30px;" align=center>SHARE MARKET 신선 식품</div>
			</c:when>
			<c:when test="${pro_cate eq '2'}">
				<div style="font-size:30px;" align=center>SHARE MARKET 냉장 식품</div>
			</c:when>
			<c:when test="${pro_cate eq '3'}">
				<div style="font-size:30px;" align=center>SHARE MARKET 가공 식품</div>
			</c:when>
			<c:otherwise>
				<div style="font-size:30px;" align=center>SHARE MARKET 전체 상품</div>
			</c:otherwise>
		</c:choose>
		<div style="height:30px;"> </div>
		<div>
			<div class="cate_array1">카테고리 선택  ▶</div>
			<c:if test="${not empty pro_cate}"><div class="cate_array"><a href="/buyer/buyer_product_list">전체 상품 가기</a></div></c:if>
			<div class="cate_array"><a href="/buyer/buyer_product_list?pro_class=1">신선 식품</a></div>
			<div class="cate_array"><a href="/buyer/buyer_product_list?pro_class=2">냉장 식품</a></div>
			<div class="cate_array"><a href="/buyer/buyer_product_list?pro_class=3">가공 식품</a></div>
		</div>
		<div style="height:5px;"> </div>
		<c:if test="${not empty pro_cate}">
		<div>
		<div class="cate_array1">세부 카테고리 선택 ▷</div>
		<c:choose>
			<c:when test="${pro_cate eq '1'}">
				<div class="cate_array"><a href="/buyer/buyer_product_list?category=과일">과일</a></div>
				<div class="cate_array"><a href="/buyer/buyer_product_list?category=채소/쌀/잡곡">채소 / 쌀 / 잡곡</a></div>
				<div class="cate_array"><a href="/buyer/buyer_product_list?category=축산/계란">축산 / 계란</a></div>
			</c:when>
			<c:when test="${pro_cate eq '2'}">
				<div class="cate_array"><a href="/buyer/buyer_product_list?category=냉장/냉동/간편요리">냉장 / 냉동 / 간편요리</a></div>
				<div class="cate_array"><a href="/buyer/buyer_product_list?category=수산물/냉동육류">수산물 / 냉동육류</a></div>
				<div class="cate_array"><a href="/buyer/buyer_product_list?category=생수/음료">생수 / 음료</a></div>
			</c:when>
			<c:otherwise>
				<div class="cate_array"><a href="/buyer/buyer_product_list?category=유제품/아이스크림">유제품 / 아이스크림</a></div>
				<div class="cate_array"><a href="/buyer/buyer_product_list?category=장/소스/드레싱/식초">장 / 소스 / 드레싱 / 식초</a></div>
				<div class="cate_array"><a href="/buyer/buyer_product_list?category=과자/초콜릿/시리얼">과자 / 초콜릿 / 시리얼</a></div>
			</c:otherwise>
		</c:choose>
		</div>
		</c:if>
		<div style="height:20px;"> </div>
		<div class="list_line"></div>
		<div style="height:20px;"> </div>
			<form name="cart" action="cart_insert" method="post">
			<input type="hidden" name="pro_type" value="c">
			<input type="hidden" name="pro_uid" value="${list.pro_uid }">
			<input type="hidden" name="pro_id" value="${list.pro_id }">
			<input type="hidden" name="pro_name" value="${list.pro_name }">
			<input type="hidden" name="id" value="${sessionScope.id }">
			<input type="hidden" name="pro_point" value="${list.pro_point }">
			<input type="hidden" name="cart_session" value="${sessionScope.cart }">
			<input type="hidden" name="pay_ok" value="3">
			<div>
				<div style="display:inline-block;">
					<div class="viewimg1">
						<div class="viewimg1_1"><img src="/upload/${list.file1 }" width=100></div>
						<div class="viewimg1_2"><img src="/upload/${list.file2 }" width=100></div>
						<div class="viewimg1_3"><img src="/upload/${list.file3 }" width=100></div>
					</div>
					<div class="viewimg2"><img src="/upload/${list.file1 }" width=300></div>
				</div>
				<div style="display:inline-block;width:10px"></div>
				<div class="viewright">
					<div style="height:20px;"> </div>
					<div class="view_name">${list.pro_name }</div>
					<div style="height:10px;"> </div>
					<div>제조사명 : ${list.pro_manuname }</div>
					<div>판매사명 : ${list.pro_salname }</div>
					<div style="height:10px;"> </div>
					<div>
						<div class="view_price"><input type="hidden" name="pro_price" id="pro_price" value="${list.pro_price }" readonly><fmt:formatNumber value="${list.pro_price}" pattern="#,###"/>원</div>
						<div style="display:inline-block;width:5px;"> </div>
						<div class="productpoint"><img src="/img/coin.png" width=13 height=13>마일리지 ${list.pro_point}원 적립</div>
					</div>
					<div style="height:15px;"> </div>
					<div class="paybox">
						<div style="height:7px;"> </div>
						<div style="display:inline-block;width:15px;"></div>
						<div style="display:inline-block;">
							<div style="display:inline-block;"><label>수량 선택 ▷</label></div>
							<div style="display:inline-block;width:5px;"> </div>
							<div style="display:inline-block;">
								<select name="pro_count" id="pro_count">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>		
								</select>
							</div>
							<div style="height:3px;"> </div>
							<div>총 가격    <input id='total_price' name='total_price' onkeyup='inputNumberFormat(this)' readonly>원</div>
							<div style="height:3px;"> </div>
							<div>총 마일리지    <input id="pro_point" name="pro_point" style="width:50px;" readonly>원 적립</div>
						</div>
						<div style="display:inline-block;width:15px;"></div>
					</div>
					<div style="height:15px;"> </div>
					<div>
						<div class="view_button" onclick="cart_insert('z')">
							<div style="display:inline-block;vertical-align:middle;margin-top:5px;"><img src="/img/heart.png" width=20 height=20></div>
							<div style="display:inline-block;">찜하기</div>
						</div>
						<div class="view_button" onclick="cart_insert('c')">장바구니</div>
						<div class="view_button_order">바로 구매</div>
					</div>
				</div>
			</div>
			</form>
			<div style="height:20px;"> </div>
			<div class="list_line"></div>
			<div style="height:20px;"> </div>
		<!-- 리뷰 및 상세정보 시작 -->
			<div>
				<div class="view_middle1">상품상세</div>
				<div class="view_middle2">상품평</div>
				<div class="view_middle3">상품문의</div>
			</div>
			<div id="view_detailing_box">
				<div style="height:20px;"> </div>
				<div><img src="/upload/${list.file2 }" width=300></div>
				<div class="view_detailing">${list.pro_detailing }</div>
				<div style="height:20px;"> </div>
			</div>
			<div id="view_review_box">
				<div>상품평</div>
			</div>
			<div id="view_qna_box">
				<div style="height:15px;"> </div>
				<div class="view_qna">
					<div style="height:30px;"> </div>
					<div>
						<div style="width:45px;display: inline-block;"> </div>
						<div style="display: inline-block;">
							<div class="view_qna_top">
								<div style="display: inline-block;">상품문의</div>
								<c:choose>
									<c:when test="${not empty sessionScope.name}">
										<div class="view_qna_button" onclick="qna_go('${list.pro_uid}','${list.pro_name}','${list.pro_salname}')">문의하기</div>		
									</c:when>
									<c:otherwise>
										<div class="view_qna_button" onclick="javascript:alert('로그인 후 작성가능합니다.\n로그인 후 작성해주세요.');">문의하기</div>
									</c:otherwise>
								</c:choose>
							</div>
							<div style="height:10px;"> </div>
							<div>· 구매한 상품의 <b>취소/반품은 마이페이지 구매내역에서 신청</b> 가능합니다.</div>
							<div>· 상품문의 및 후기게시판을 통해 취소나 환불, 반품 등은 처리되지 않습니다.</div>
							<div>· <b>가격, 판매자, 교환/환불 및 배송 등 해당 상품 자체와 관련 없는 문의는 고객센터 내 1:1 문의하기</b>를 이용해주세요.</div>
							<div>· <b>"해당 상품 자체"와 관계없는 글, 양도, 광고성, 욕설, 비방, 도배 등의 글은 예고 없이 이동, 노출제한, 삭제 등의 조치가 취해질 수 있습니다.</b></div>
							<div>· 공개 게시판이므로 전화번호, 메일 주소 등 고객님의 소중한 개인정보는 절대 남기지 말아주세요.</div>
							<div style="height:20px;"> </div>
							<div class="view_qna_top_line"></div>
							<div class="view_qna_question">
								<div style="height:10px;"> </div>
								<div style="display: inline-block;height:60px">
									<div style="height:20px">질문</div>
									<div style="height:10px"> </div>
								</div>
								<div style="display: inline-block;width:10px"></div>
								<div style="display: inline-block;">
									<div>
										<div style="display: inline-block;">구매자아이디</div>
										<div style="display: inline-block;width:565px;"> </div>
										<div style="display: inline-block;">2022-04-15 15:55:15</div>
									</div>
									<div>
										<div style="display: inline-block;">상품명</div>
										<div style="display: inline-block;">판매자명</div>
									</div>
									<div>질문내용</div>
								</div>
								<div style="height:10px;"> </div>
							</div>
						</div>
						<div style="width:30px;display: inline-block;"> </div>
					</div>
					<div style="height:30px;"> </div>
				</div>
			</div>
		</div>
	<div style="width:200px;display: inline-block;"></div>
</div>



