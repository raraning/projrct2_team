<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>

<%@include file="/admin/index.jsp" %>

<script>
	function sellok(id) {
		if (confirm("승인 하시겠습니까?") == true){
			location.href="/admin/sell/sellok?id="+id;
		}else{
			return false;
		}
	}
	function sellno(id) {
		if (confirm("취소 하시겠습니까?") == true){
			location.href="/admin/sell/sellno?id="+id;
		}else{
			return false;
		}
	}
</script>

<br>
<div class="memsell_max_box">
	<div class="memsell_lest2_box">아이디</div>
	<div class="memsell_lest_box">이름</div>
	<div class="memsell_lest3_box">이메일</div>
	<div class="memsell_lest_box">분류</div>
	<div class="memsell_lest2_box">제조사</div>
	<div class="memsell_lest3_box">판매업체</div>
	<div class="memsell_lest2_box">승인</div>
</div>




<div class="memsell_box">
	<c:forEach var="m" items="${m_list }">
	<div class="memsell_lest2_box">${m.id }</div>
	<div class="memsell_lest_box">${m.name }</div>
	<div class="memsell_lest3_box">${m.email }</div>
	<c:choose>
		<c:when test="${m.sell_buy == 'X'}">
			<div class="memsell_lest_box">구메자</div>
		</c:when>
		<c:otherwise>
			<div class="memsell_lest_box">판매자</div>
		</c:otherwise>
	</c:choose>
	<div class="memsell_lest2_box">${m.pro_manuname }</div>
	<div class="memsell_lest3_box">${m.pro_salname }</div>
	<div class="memsell_lest2_box">
	<c:choose>
		<c:when test="${m.pro_manuname eq '거절'}">
			<div class="memsell_lest2_box">승인 거절</div>
		</c:when>
		<c:when test="${m.pro_salname eq '거절'}">
			<div class="memsell_lest2_box">승인 거절</div>
		</c:when>
		<c:when test="${m.sell_buy == 'X' }">
		<button class="memsell_button" onclick="sellok(${m.id})">승인</button>
		<button class="memsell_button" onclick="sellno(${m.id})">취소</button>
		</c:when>
		<c:otherwise>
			<div class="memsell_lest2_box">승인 완료</div>
		</c:otherwise>
	</c:choose>
	</div>
	</c:forEach>
</div>
<!------ 페이징 처리------ -->
<div class="memsell_page_box">
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
<!------ 페이징 처리 끝------ -->
<form action="" method="get">
<div class="memsell_page_box">
	<select name=field>
		<option value="id" <c:if test="${field == id }">selected</c:if>>아이디</option>
		<option value="name" <c:if test="${field == name }">selected</c:if>>이름</option>
		<option value="email" <c:if test="${field == email }">selected</c:if>>이메일</option>
		<option value="sell_buy" <c:if test="${field == sell_buy }">selected</c:if>>분류</option>
		<option value="pro_manuname" <c:if test="${field == pro_manuname }">selected</c:if>>제조사</option>
		<option value="pro_salname" <c:if test="${field == pro_salnames }">selected</c:if>>판매자업체</option>
	</select>
	<input name="search" value="${search }">
	<button>검색</button>
</div>
</form>
<div class="memsell_max_box2">
	<dib class="memsell_page_left"><a href="/admin/sell/memberok_list">새로고침</a></dib>
	<dib class="memsell_page_right"></dib>
</div>
<table height=300>
</table>