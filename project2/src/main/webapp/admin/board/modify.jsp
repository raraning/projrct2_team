<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>

<%@include file="/admin/index.jsp" %>

<br>
<form name="board" action="gongji_modify" method="post" onsubmit="return go()">
<input type="hidden" name="uid" value="${l.uid }" value="1">
<input type="hidden" name="pro_uid" value="${l.pro_uid }" value="1">
<input type="hidden" name="id" value="${l.id }" value="1">
<input type="hidden" name="name" value="${l.name }" value="1">

<div class="gon_view_all_box">
	<div class="gon_view_name_box">공지사항</div>
	<div class="gon_view_name_box2">
		<div class="gon_view_subject_box">제목</div>
		<div class="gon_view_subject_box4"><input type="text" id="subject" name="subject" value="${l.subject }" placeholder="제목 6자 이상" class="gon_name_input"></div>
	</div>
	<div class="gon_view_name_box3">
		<div class="gon_view_comment_box">내용</div>
		<div class="gon_view_comment_box2"><textarea type="text" id="comment" name="comment" class="gon_name_input">${l.comment }</textarea></div>
	</div>
</div>
<div class="gon_view_name_box">
	<div><button class="gon_button_box">수정하기</button></div>
</div>
</form>
<br><br><br><br><br><br><br><br><br>