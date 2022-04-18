<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<script>
function fnDelete(uid){
	alert(uid);
	if(confirm("삭제하겠습니까?") == true){
		location.href="/bbs/notice_delete?uid="+uid;
	}else{
		return false;
	}
}
</script>

<form action="notice_view" method="post">
<table width=700 border=1 align="center">
	<tr>
		<td colspan=2 align=center>[공지사항]</td>
	</tr>
	<tr>
		<td width=100>옵션</td>
		<td>${list.gongji }</td>
	</tr>
	<tr>
		<td width=100>제목</td>
		<td>${list.subject }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${list.comment }</td>
	</tr>
	<!-- 한줄 댓글 -->
	
	<!-- 입력 -->
	<form name="" action="notice_comment" method="post">
	<table width=700 border=1 align=center>
		<tr align=center>
			<td colspan="2">
				<input type="text" name="comment" style="width:600">
				<button>댓글 작성</button>
			</td>
		</tr>
	</table>
	</form>
	
	<!-- 리스트 출력 -->
	<table width=700 border=1 align=center>
		<tr>
			<td align=center>
				<a href="list">[목록]</a>
				<a href="notice_modify?uid=${list.uid}">[수정]</a>
				<span onclick="fnDelete('${list.uid}')" />[삭제]</span>
			</td>
		</tr>
	</table>
</table>
</form>

<%@ include file="/include/footer.jsp" %>