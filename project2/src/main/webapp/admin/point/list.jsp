<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>

<%@include file="/admin/index.jsp" %>

<br>
<div class="admin_point_max_box">포인트 목록</div>
<div class="admin_point_box">
	<div class="admin_point_max_box2">
		<div class="admin_point_subject">아이디</div>
		<div class="admin_point_subject">이름</div>
		<div class="admin_point_subject">보유 포인트</div>
		<div class="admin_point_subject">총 사용 포인트</div>
	</div>
</div>
<!------ 페이징 처리------ -->
<div class="admin_point_max_box2">
	
</div>
<!------ 페이징 처리 끝------ -->
<form action="" method="get">
<div class="admin_point_page_box">
	<select name=field>
		<option value="subject" <c:if test="${field == 'sbhect' }">selected</c:if>>제목</option>	
		<option value="signdate" <c:if test="${field == 'signdate' }">selected</c:if>>날짜</option>	
	</select>
	<input name="search" value="${search }">
	<button>검색</button>
</div>
</form>
<div class="admin_point_max_box2">
	<dib class="admin_point_page"><a href="/admin/point/list">새로고침</a></dib>
</div>
<table height=300>
</table>