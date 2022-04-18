<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<script>
function fnQnaDelete(uid){
	alert(${sessionScope.id});
	alert(${q.id});
	if(confirm("삭제하시겠습니까?") == true){
		if(${sessionScope.id == q.id}){
			alert("실행");
			location.href="/qna/delete?uid="+uid;
		}else{
			alert("삭제할 권한이 없습니다.");
			return false;
		}
	}else{
		return false;
	}
}

function fnQnaModify(uid){
	if(confirm("수정하시겠습니까?") == true){
		if(${sessionScope.id == q.id}){
			alert("실행");
			location.href="/qna/modify?uid="+uid;
		}else{
			alert("실패");
			alert("글을 수정할 권한이 없습니다.");
		}
	}else{
		return false;
	}
}
</script>

<form action="qna_view" method="post">
<table width=700 border=1 align="center">
	<tr>
		<td colspan=2 align=center>[질문&답변]</td>
	</tr>
	<tr>
		<td width=100>옵션</td>
		<td>${q.gongji }</td>
	</tr>
	<tr>
		<td width=100>제목</td>
		<td>${q.subject }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${q.comment }</td>
	</tr>
	<!-- 한줄 댓글 -->
	
	<!-- 입력 -->
	<form name="" action="qna_comment" method="post">
	<table width=700 border=1 align=center>
		<tr align=center>
			<td colspan="2">
				<input type="text" name="comment" style="">
				<input type="button" style="width:80px" value="댓글작성">
			</td>
		</tr>
	</table>
	</form>
	
	<!-- 리스트 출력 -->
	<table width=700 border=1 align=center>
		<tr>
			<td colspan=2 align=center>
				<a href="list">[목록]</a>
				<span onclick="fnQnaModify('${q.uid}')">[수정]</span>
				<span onclick="fnQnaDelete('${q.uid}')">[삭제]</span>
			</td>
		</tr>
	</table>
</table>
</form>

<%@ include file="/include/footer.jsp" %>
