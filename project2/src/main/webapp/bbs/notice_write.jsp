<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<form action="notice_write_insert" method="post">
<table width=700 border=1 align=center>
	<tr>
		<td colspan=2 align=center>[공지사항]</td>
	</tr>
	<tr>
		<td>옵션</td>
		<td>
			<input type="radio" name="gongji" value="1"> 공지 
			<input type="radio" name="gongji" value="2" checked> 일반 
			<input type="radio" name="gongji" value="3"> 비밀 
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input id="subject" name="subject"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea id="comment" name="comment"></textarea></td>
	</tr>
	<tr>
		<td></td>
		<td><button>글쓰기</button></td>
	</tr>
</table>
</form>


<%@ include file="/include/footer.jsp" %>