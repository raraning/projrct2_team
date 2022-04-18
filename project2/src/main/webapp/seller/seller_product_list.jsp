<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<link href="/css/seller_product_list.css" rel="stylesheet">

<style>

.table-cell {
	 display: inline-block;
     padding: 0px 30px;
     height: 20px;
}
</style>

<script>
function fnDelete(pro_uid){
	alert("제품번호 : "+pro_uid);
	if(confirm("삭제하겠습니까?") == true){
		location.href="/seller/seller_product_delete?pro_uid="+pro_uid;
	}else{
		return false;
	}
}
</script>
<div style="height:30px;"> </div>
<div>
	<div class="pro_listempty"> </div>
	<div class="pro_listtop"><a href="seller_product_list">상품 리스트가기</a></div>
	<div class="pro_listempty2"> </div>
	<div class="pro_listtop"><a href="seller_product_register">상품 등록하기</a></div>
	<div class="pro_listempty"> </div>
</div>
<div style="height:20px;"> </div>
<form action="" method="get">
	<div width=800 height=43px align=center>
		<div>
			<div align=center>
				<select name="field" class="field">
					<option value="" selected disabled hidden>선택하세요</option>
					<option value="pro_name" <c:if test="${field eq 'pro_name'}"> selected</c:if>>상품명</option>
					<option value="pro_class" <c:if test="${field eq 'pro_class'}"> selected</c:if>>상품분류</option>
					<option value="pro_category" <c:if test="${field eq 'pro_category'}"> selected</c:if>>상품카테고리</option>
				</select>
				<input id="search" name="search" value="${search }" placeholder="등록한 상품을 검색해보세요!"><button class="pro_listbutton"><div style="vertical-align:middle;"><img src="/img/search2.png" class="pro_searchimg"></div></button>
			</div>
		</div>
	</div>
</form>
<div style="height:20px;"> </div>
<div>
	<div class="pro_listmid plleft"> </div>
	<div class="pro_listmid plmid">
		총 ${count } 개의 상품이 등록되어있습니다.
		<div style="height:10px;"> </div>
		<c:set var="number" value="${number }"/>
		<c:forEach var="list" items="${v }">
			<div class="productlist">
				<div style="height:15px;"> </div>
				<div class="pro_listcontent" style="width:35px;"> </div>
				<div class="pro_listcontent"><img src="/upload/${list.file1_s }" width=170 height=170></div>
				<div class="pro_listcontent" style="width:25px;"> </div>
				<div class="pro_listcontent2">
					<div class="pro_listproduct">
						<div style="height:5px;"> </div>
						<div>No.${number }</div>
						<div style="height:3px;"> </div>
						<div>제품번호 : ${list.pro_uid }</div>
						<div>상품명 : ${list.pro_name }</div>
						<div>상품 분류 : ${list.pro_class }</div>
						<div>카테고리 : ${list.pro_category }</div>
						<div>재고수량 : ${list.pro_available }</div>
						<div>상품가격 : ${list.pro_price }</div>
						<div>입고날짜 : ${list.pro_indate }</div>
						<div>마일리지 : ${list.pro_point }</div>
					</div>
					<div class="pro_listmode">
						<div style="height:5px;"> </div>
						<div class="pro_listmodebutton"><a href="seller_product_modify?pro_uid=${list.pro_uid }">상품 수정 하기</a></div>
						<div style="height:5px;"> </div>
						<div class="pro_listmodebutton"><span onclick="fnDelete('${list.pro_uid}')" />상품 삭제 하기</span></div>
					</div>
				</div>
			</div>
			<div style="height:5px;"> </div>
		<c:set var="number" value="${number -1 }"/>
		</c:forEach>
	</div>
	<div class="pro_listmid plright"> </div>
</div>
	<!-- 페이징 처리 -->
<div style="height:25px;"> </div>
<div>
	<div style="width:500px; display:inline-block"> </div>
	<div style="width:900px; display:inline-block">
		<div>
			<div class="paging">
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
						<a href="seller_product_list?pageNum=${startPage - pageBlock }"><div class="pagingbutton3">이전</div></a>
					</c:if>
					<!-- 페이징 링크 -->
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<c:choose>
							<c:when test="${pageNum == i }">
								<a href="seller_product_list?pageNum=${i }"><div class="pagingbutton1">${i }</div></a>
							</c:when>
							<c:otherwise>
								<a href="seller_product_list?pageNum=${i }"><div class="pagingbutton2">${i }</div></a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<!-- 다음 링크 -->
					<c:if test="${endPage < pageCount }">
						<a href="seller_product_list?pageNum=${startPage + pageBlock }"><div class="pagingbutton3">다음</div></a>
					</c:if>
				</c:if>
			</div>
		</div>
	</div>
	<div style="width:400px; display:inline-block"> </div>
</div>
<div style="height:25px;"> </div>
