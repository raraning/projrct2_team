<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- core -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- fmt -->

<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>


<!-- 내 정보 카테고리 -->
<div class="mypage_left_box">
	<div class="mypage_category_box" onclick="location.href='/member/my/mypage'">내정보</div>
	<c:choose>
		<c:when test="${member.sell_buy == 'X'}"><!-- x 구메자 -->
			<div class="mypage_category_box" onclick="location.href='/member/my/join_up_delete'">회원 수정 및 탈퇴</div>
		</c:when>
		<c:otherwise><!-- Y 판매자 -->
			<div class="mypage_category_box" onclick="location.href='/member/my/join_sellerup_delete'">회원 수정 및 탈퇴</div>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${member.sell_buy == 'X'}"><!-- x 구메자 -->
			<div class="mypage_category_box" onclick="location.href='/member/my/my_buy_pro'">내가 구매한 제품</div>
		</c:when>
		<c:otherwise><!-- Y 판매자 -->
			<div class="mypage_category_box" onclick="location.href='/member/my/my_buy_pro'">내가 구매한 제품</div>
			<div class="mypage_category_box" onclick="location.href='/seller/seller_product_list'">내가 판매한 제품</div>
		</c:otherwise>
	</c:choose>
	<div class="mypage_category_box" onclick="location.href='/member/my/my_save'">내가 찜한 제품</div>
	<div class="mypage_category_box">내 관심 제품</div>
	<div class="mypage_category_box">내가 등록한 평점</div>
	<div class="mypage_category_box">내 쿠폰</div>
	<div class="mypage_category_box">내 포인트</div>
</div>
<!-- 내 정보 카테고리 끝-->

