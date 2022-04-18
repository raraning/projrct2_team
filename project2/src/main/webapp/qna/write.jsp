<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<form action="write_insert" method="post">
<table width=700 border=1 align=center>
	<tr>
		<td colspan=2 align=center>[질문&답변]</td>
	</tr>
	<tr>
		<td>옵션</td>
		<td><input id="gongji" name="gongji" value="2"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input id="subject" name="subject"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input id="comment" name="comment"></td>
	</tr>
	<tr>
		<td></td>
		<td><button>글쓰기</button></td>
	</tr>
</table>

<!-- 리스트 출력 -->
<table width=700 border=1 align=center>
	<tr>
		<td colspan=2 align=center>
			<a href="list">[목록]</a>
			<a href="modify?uid=${list.uid }">[수정]</a>
			<a href="delete?uid=${list.uid }">[삭제]</a>
		</td>
	</tr>
</table>

</form>
