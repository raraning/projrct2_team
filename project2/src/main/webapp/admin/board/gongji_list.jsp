<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>

<%@include file="/admin/index.jsp" %>

<br>
<div class="gongji_max_box">
	<div class="gongji_lest_box">공지</div>
	<div class="gongji_lest3_box">제목</div>	
	<div class="gongji_lest2_box">생성날짜</div>
</div>
<div class="gongji_box">
	<c:forEach var="g" items="${list }">
	<div class="gongji_max_box2">
		<div class="gongji_lest_box2"><img src="/img/pppp.png" style="width:50px; height:50px;"></div>
		<div class="gongji_lest_box3"><a href="/admin/board/gongji_view?uid=${g.uid }">&nbsp;&nbsp;${g.subject }</a></div>
		<div class="gongji_lest2_box2">&nbsp;&nbsp;${g.signdate }</div>
	</div>
	</c:forEach>
</div>
<!------ 페이징 처리------ -->
<div class="gon_page_box">
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
<div class="gongji_page_box">
	<select name=field>
		<option value="subject" <c:if test="${field == 'sbhect' }">selected</c:if>>제목</option>	
		<option value="signdate" <c:if test="${field == 'signdate' }">selected</c:if>>날짜</option>	
	</select>
	<input name="search" value="${search }">
	<button>검색</button>
</div>
</form>
<div class="gongji_max_box2">
	<dib class="gongji_page_left"><a href="/admin/board/list">새로고침</a></dib>
	<dib class="gongji_page_right"><a href="/admin/board/write">글쓰기</a></dib>
</div>
<table height=300>
</table>