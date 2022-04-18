<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@include file="/include/header.jsp" %>
<link href="/css/width_height.css" rel="stylesheet">
<link href="/css/my_save.css" rel="stylesheet">

<script>
function mydelete(pro_uid) {
	if(confirm("삭제 하시겠습니까 (оﾟдﾟо)?") == true){
		location.href="/member/my/mydelete?pro_uid="+pro_uid;
	}else{
		return false;
	}
}

function cartinset(pro_uid) {
	if(confirm("장바구니에 담겠습니까 (одо)?") == true){
		location.href="/member/my/cartinset?pro_uid="+pro_uid;
	}else{
		return false;
	}
}


</script>


<div class="mypage_main_box">
	<div class="mypage_mid_box">
		<!-- 내 정보 카테고리(왼쪽 테이블) -->
		<%@include file="/member/my/favorites.jsp" %>
		<!-- 내 정보 카테고리 끝-->
		<div class="mypage_right_box">
			<div class="my_main_name">내가 찜한 제품</div>
		<!------ 구메 재품 박스 ------->
			<div class="my_save_list_name_all_box">
				<c:forEach var="list" items="${m_list}">
				<!-- <form action="cartinset" method="get"> -->
				<input type="hidden" name="pro_uid" value="${list.pro_uid }">
				<input type="hidden" name="pro_id" value="${list.pro_id }">
				<input type="hidden" name="pro_name" value="${list.pro_name }">
				<input type="hidden" name="id" value="${sessionScope.id }">
				<input type="hidden" name="pro_point" value="${list.pro_point }">
				<input type="hidden" name="cart_session" value="${sessionScope.cart }">
				<input type="hidden" name="pay_ok" value="3">
				<input type="hidden" name="pro_count" value="${list.pro_count }">
				<input type="hidden" name="pro_price" value="${list.pro_price }">
				<div class="my_save_list_name_box">
					<div class="my_save_list_img1"><a href="/buyer/buyer_product_view?pro_uid=${list.pro_uid }"><img src="/upload/${list.file1 }" style="width:100%; height:100%"></a></div>
					<div class="my_save_list_name_box2">
						<div class="my_save_list_name2_box2"><a href="/buyer/buyer_product_view?pro_uid=${list.pro_uid }">&nbsp;&nbsp;${list.pro_name }</a></div>
						<div class="my_save_list_name3_box2">&nbsp;
							${list.pro_price}원&nbsp;
							${Math.round(list.pro_price * 0.01)}마일리지
						</div>
					</div>
					<div class="my_save_list_name_box3">
						<button class="my_save_list_button1" onclick="cartinset('${list.pro_uid}')">장바구니 담기</button>
					</div>
				<!-- </form> -->
					<div class="my_save_list_name_box4">
						<button class="my_save_list_button2" onclick="mydelete('${list.pro_uid}')">삭제</button>
					</div>
				</div>
				</c:forEach>
			</div>
		<!------ 구메 재품 박스 끝------->
		<!----- 한 페이지 최대 3개-------->
			<div class="my_save_list_all_box">
				<div class="my_save_list_main_page_box">
					<div style="margin: auto;">
						<c:if test="${count>0 }">
							<c:set var="pageCount" value="${count / pageSize + (count % pageSize == 0 ? 0 : 1) }" />
							<fmt:parseNumber var="pageCount" value="${pageCount }" integerOnly="true" />
						
							<!-- 2개의 변수 초기화 -->
							<c:set var="startPage" value="${1 }" />
							<c:set var="pageBlock" value="${3 }" />	
						
							<!-- 다음 페이지 블럭이 존재 할 경우 startPage 값 변경 부분-->
							<c:if test="${pageNum > pageBlock }">
								<!-- 결과를 정수형으로 리턴 받아야 하기 대문에 fmt -->
								<fmt:parseNumber var="result" value="${pageNum / pageBlock - (pageNum % pageBlock == 0 ? 1:0) }" integerOnly="true"/>
								<c:set var="startPage" value="${result * pageBlock + 1 }" />
							</c:if>	
						
							<!-- endPage 값 설정 부분 -->
							<c:set var="endPage" value="${startPage + pageBlock - 1 }" />
							<c:if test="${endPage > pageCount }">
								<c:set var="endPage" value="${pageCount }" />
							</c:if>
						
							<!-- 이전 링크 -->
							<c:if test="${startPage > pageBlock }">
								<a href="list?pageNum=${startPage - pageBlock }">[이전] </a>
							</c:if>
						
							<!-- 페이징 링크 -->
							<c:forEach var="i" begin="${startPage }" end="${endPage }">
								<c:choose>
									<c:when test="${pageNum == i }">
										<a href="list?pageNum=${i }"><span style="padding:0px 4px;"><font color=red><b>[${i }]</b></font></span></a>
									</c:when>
									<c:otherwise>
										<a href="list?pageNum=${i }"><span style="padding:0px 4px;">[${i }]</span></a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						
							<!-- 다음 링크 -->
							<c:if test="${endPage < pageCount }">
								<a href="list?pageNum=${startPage + pageBlock }">[다음] </a>
							</c:if>
						</c:if>
					</div>
				</div>
			</div>
		<!-- -----페이지 끝------------->
		</div>
	</div>
</div>

<%@include file="/include/footer.jsp" %>