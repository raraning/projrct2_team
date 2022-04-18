<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>
<div style="height:20px;"> </div>
<div class="mypage_main_box">
	<div class="mypage_mid_box">
		<!-- 내 정보 카테고리(왼쪽 테이블) -->
		<%@include file="/member/my/favorites.jsp" %>
		<!-- 내 정보 카테고리 끝-->
		<div class="mypage_right_box">
			<div class="my_main_name">내 정보</div>
			<div class="my_name_big_box">
				<div class="my_name_box1">아이디</div>
				<div class="my_name_box">${member.id }</div>
				<div class="my_name_box1">비밀번호</div>
				<div class="my_name_box">${member.pass }</div>
				<div class="my_name_box1">이름</div>
				<div class="my_name_box">${member.name }</div>
				<div class="my_name_box1">생년월일</div>
				<div class="my_name_box">${member.birth }</div>
				<div class="my_name_box1">성별</div>
				<c:choose>
					<c:when test="${member.gender eq 'F'}">
						<div class="my_name_box">남자</div>
					</c:when>
					<c:otherwise>
						<div class="my_name_box">여자</div>
					</c:otherwise>
				</c:choose>
				<div class="my_name_box1">이메일</div>
				<div class="my_name_box">${member.email }</div>
				<div class="my_name_box1">주소 </div>
				<div class="my_name_box2">${member.zipcode }</div>
				<div class="my_name_box2">${member.zipcode1 },${member.zipcode2 }</div>
				<div class="my_name_box">${member.zipcode3 },${member.zipcode4 }</div>
			</div>
			<div class="my_name_big_box2">
				<c:choose>
					<c:when test="${member.sell_buy eq 'X'}">
						<div class="my_name_box1">내가 구매한 제품</div>
						<div class="my_name_box">내용</div>
					</c:when>
					<c:otherwise>
						<div class="my_name_box1">내가 구매한 제품</div>
						<div class="my_name_box">내용</div>
						<div class="my_name_box1">내가 판매한 제품</div>
						<div class="my_name_box">내용</div>
					</c:otherwise>	
				</c:choose>
				<div class="my_name_box1">내가 찜한 제품</div>
				<div class="my_name_box">내용</div>
				<div class="my_name_box1">내가 등록한 평점</div>
				<div class="my_name_box">내용</div>
				<div class="my_name_box1">내 쿠폰</div>
				<div class="my_name_box">내용</div>
				<div class="my_name_box1">내 포인트</div>
				<div class="my_name_box">내용</div>
				<c:choose>
					<c:when test="${member.sell_buy == 'x' }">
						<div class="my_name_box1">내 상태</div>
						<div class="my_name_box">구메자</div>
					</c:when>
					<c:otherwise>
						<div class="my_name_box1">내 상태</div>
						<div class="my_name_box">판매자</div>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${member.sell_buy == 'Y' }">
						<div class="my_name_box1">제조사 명, 판매업체 명</div>
						<div class="my_name_box">${member.pro_manuname  }, ${member.pro_salname   }</div>
					</c:when>
				</c:choose>
			</div>
			<div class="my_join_up"></div>
		</div>
	</div>
</div>

<%@include file="/include/footer.jsp" %>