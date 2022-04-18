<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<form action="qna_update" method="post">
<input name="uid" value="${qna.uid }">
<table width=700 border=1 align=center>
	<tr>
		<td colspan=2 align=center>[질문&답변]</td>
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
		<td><input id="subject" name="subject" value="${qna.subject }"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea id="comment" name="comment">${qna.comment }</textarea></td>
	</tr>
	<tr>
		<td></td>
		<td><button>수정하기</button></td>
	</tr>
</table>
</form>

<%@ include file="/include/footer.jsp" %>