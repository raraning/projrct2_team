<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="/css/buyer_product_list.css" rel="stylesheet">

<div style="height:30px;"> </div>
<div style="width:1720px">
	<div style="width:450px;display:inline-block;"> </div>
	<div style="width:1060px;display: inline-block;">
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
		<div style="height:30px;"> </div>
		<div class="list_array">
			<div class="list_sun">인기순</div>
			<div class="list_sun ls1"><a href="/buyer/buyer_product_lowprice?pro_class=${pro_cate}&category=${category}">낮은가격순</a></div>
			<div class="list_sun ls1"><a href="/buyer/buyer_product_highprice?pro_class=${pro_cate}&category=${category}">높은가격순</a></div>
			<div class="list_sun">판매량순</div>
			<div class="list_sun"><a href="/buyer/buyer_product_list?pro_class=${pro_cate}&category=${category}">최신순</a></div>
		</div>
		<div style="height:10px;"> </div>
			<div id="img_wrap">
				<c:set var="number" value="${number }"/>
				<c:forEach var="list" items="${v }">
				<div class="products">
					<div style="height:20px;"> </div>
					<div class="productimg"><a href="buyer_product_view?pro_uid=${list.pro_uid }&pro_class=${list.pro_class}&category=${list.pro_category}"><img src="/upload/${list.file1_s }"></a></div>
					<div style="height:10px;"> </div>
					<div class="productname"><a href="buyer_product_view?pro_uid=${list.pro_uid }&pro_class=${list.pro_class}&category=${list.pro_category}">${list.pro_name }</a></div>
					<div class="productprice"><b><fmt:formatNumber value="${list.pro_price}" pattern="#,###"/></b>원</div>
					<div style="height:5px;"> </div>
					<div class="productpoint"><img src="/img/coin.png" width=13 height=13>마일리지 ${list.pro_point}원 적립</div>
					<div style="height:30px;"> </div>
				</div>
				<c:if test="${number % 5 == 1 }"></div><div class="productline"></div><div style=" display:inline-block;"></c:if>
				<c:set var="number" value="${number -1}"/>
				</c:forEach>
			</div>
		<div style="height:30px;"> </div>
		<!-- 페이징 처리 -->
		<div align=center>
			<div class="row">
				<div class="cell" align=center>
					<c:if test="${count>0 }">
						<c:set var="pageCount" value="${count / pageSize + (count % pageSize == 0 ? 0 : 1) }" />
						<fmt:parseNumber var="pageCount" value="${pageCount }" integerOnly="true" />			
						<!-- 2개의 변수 초기화 -->
						<c:set var="startPage" value="${1 }" />
						<c:set var="pageBlock" value="${5 }" />				
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
							<a href="buyer_product_list?pageNum=${startPage - pageBlock }"><div class="pagingbutton3">이전</div></a>
						</c:if>
						<!-- 페이징 링크 -->
						<c:forEach var="i" begin="${startPage }" end="${endPage }">
							<c:choose>
								<c:when test="${pageNum == i }">
									<a href="buyer_product_list?pageNum=${i }"><div class="pagingbutton1">${i }</div></a>
								</c:when>
								<c:otherwise>
									<a href="buyer_product_list?pageNum=${i }"><div class="pagingbutton2">${i }</div></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<!-- 다음 링크 -->
						<c:if test="${endPage < pageCount }">
							<a href="buyer_product_list?pageNum=${startPage + pageBlock }"><div class="pagingbutton3">다음</div></a>
						</c:if>
					</c:if>
				</div>
			</div>
		</div>
	</div>
<div style="width:200px;display:inline-block;"> </div>
</div>
<div style="height:30px;"> </div>