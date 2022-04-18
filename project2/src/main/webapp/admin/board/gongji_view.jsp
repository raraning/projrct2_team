<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>

<%@include file="/admin/index.jsp" %>

<br>
<input type="hidden" name="uid" value="${l.uid }">
<div class="gon_view_all_box">
	<div class="gon_view_name_box">공지사항</div>
	<div class="gon_view_name_box2">
		<div class="gon_view_subject_box">제목</div>
		<div class="gon_view_subject_box2">&nbsp;${l.subject }</div>
		<div class="gon_view_subject_box">작성날짜</div>
		<div class="gon_view_subject_box3">${l.signdate }</div>
	</div>
	<div class="gon_view_name_box3">
		<div class="gon_view_comment_box">내용</div>
		<div class="gon_view_comment_box2">&nbsp;${l.comment }</div>
	</div>
</div>
<div class="gon_view_name_box2">
	<div class="gon_view_listgo"><a href="/admin/board/gongji_list">&nbsp;목록</a></div>
	<div class="gon_view_modify_deletes">
		<a href="/admin/board/modify?uid=${l.uid }">수정</a>
		<a href="/admin/board/delete?uid=${l.uid }">삭제&nbsp;</a>
	</div>
</div>

<br><br><br><br><br><br><br><br><br>