<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>


<form name="board" action="admin_gongji_write" method="post" onsubmit="return go()">
<div class="gon_foll_button_box" style="text-align: center;"><h1>글쓰기</h1></div>

<input type="hidden" name="pro_uid" value="1">
<input type="hidden" name="id" value="${sessionScope.id }">
<input type="hidden" name="name" value="${sessionScope.name }">
<div class="gon_main_box">
	<div class="gon_foll_name_box">
		<div class="gon_name_box">제목</div>
		<div class="gon_name_box2"><input type="text" id="subject" name="subject" placeholder="제목 6자 이상" class="gon_name_input"></div>
	</div>
	<div class="gon_foll_comment_box">
		<div class="gon_comment_box">내용</div>
		<div class="gon_comment_box2"><textarea type="text" id="comment" name="comment" class="gon_name_input"></textarea></div>
	</div>
	<div class="gon_foll_button_box">
		<div id="height_10"></div>
		<div class="gon_button_box"><button class="gon_button_box">글쓰기</button></div>
	</div>
</div>
</form>

















