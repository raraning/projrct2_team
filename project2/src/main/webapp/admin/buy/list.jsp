<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>

<%@include file="/admin/index.jsp" %>

<br>
<div class="gongji_max_box">
	
</div>
<div class="gongji_box">
</div>
<!------ 페이징 처리------ -->
<div class="gon_page_box">

</div>
<!------ 페이징 처리 끝------ -->
<form action="" method="get">
<div class="gongji_page_box">
	<select name=field>
		<option value="subject" <c:if test="">selected</c:if>>제목</option>	
		<option value="signdate" <c:if test="">selected</c:if>>날짜</option>	
	</select>
	<input name="search" value="">
	<button>검색</button>
</div>
</form>
<div class="gongji_max_box2">
	<dib class="gongji_page_left"><a href="/admin/board/list">새로고침</a></dib>
</div>
<table height=300>
</table>