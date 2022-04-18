<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<script>
function fnNoticeWrite(uid){
	if(${sessionScope.level != '10'}){
		alert('글을 작성할 권한이 없습니다.');
		return false;
	}else{
		alert("실행");
		location.href="/bbs/notice_write";
	}
}
</script>

<table width=700 border=1 align=center>
	<tr><td colspan="5">Total : ${count } </td></tr>
	<tr><td colspan="5" width=100% height=1 border=1></td></tr>
	<tr>
		<td width=50>No</td>
		<td width=350>제목</td>
		<td width=100>글쓴이</td>
		<td width=150>작성일</td>
		<td width=50>조회수</td>
	</tr>
	
	<c:set var="number" value="${number }"/>
	<c:forEach var="list" items="${v }">
	<tr>
		<td>${number }</td>
		<td><a href="notice_view?uid=${list.uid }">${list.subject }</a></td>
		<td>${list.name }</td>
		<td>${list.signdate }</td>
		<td>${list.ref }</td>
	</tr>
	<c:set var="number" value="${number -1 }"/>
	</c:forEach>
</table>

<!-- 페이징 처리 -->
<table width=700 border=1 align=center>
	<tr>
		<td align=center>
			<c:if test="${count>0 }">
				<c:set var="pageCount" value="${count / pageSize + (count % pageSize == 0 ? 0 : 1) }" />
				<fmt:parseNumber var="pageCount" value="${pageCount }" integerOnly="true" />			
				<!-- 2개의 변수 초기화 -->
				<c:set var="startPage" value="${1 }" />
				<c:set var="pageBlock" value="${5 }" />				
				<!-- 다음 페이지 블럭이 존재 할 경우 startPage 값 변경 부분-->
				<c:if test="${pageNum > pageBlock }">
					<!-- 결과를 정수형으로 리턴 받아야 하기 대문에 fmt -->
					<fmt:parseNumber var="result" value="${pageNum / pageBlock - (pageNum % pageBlock == 0 ? 1:0) }" integerOnly="true"/>
					<c:set var="startPage" value="${result * pageBlock + 1 }" />
				</c:if>			
				<!-- endPage 값 설정 부분 -->
				<c:set var="endPage" value="${startPage + pageBlock - 1 }" />
				<c:if test="${endPage > pageCount }">
					<c:set var="endPage" value="${pageCount }" />
				</c:if>		
				<!-- 이전 링크 -->
				<c:if test="${startPage > pageBlock }">
					<a href="list?pageNum=${startPage - pageBlock }">[이전] </a>
				</c:if>
				<!-- 페이징 링크 -->
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<c:choose>
						<c:when test="${pageNum == i }">
							<a href="list?pageNum=${i }"><span style="padding:0px 4px;"><font color=red><b>[${i }]</b></font></span></a>
						</c:when>
						<c:otherwise>
							<a href="list?pageNum=${i }"><span style="padding:0px 4px;">[${i }]</span></a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<!-- 다음 링크 -->
				<c:if test="${endPage < pageCount }">
					<a href="list?pageNum=${startPage + pageBlock }">[다음] </a>
				</c:if>
			</c:if>
		</td>
	</tr>
</table>

<form name="" action="" method="get">
<table width=700 align=center>
	<tr>
		<td align=center>
			<select name="field">
				<option value="subject" <c:if test="${field == 'subject'}">selected</c:if>>제목</option>
				<option value="comment" <c:if test="${field == 'comment'}">selected</c:if>>내용</option>
				<option value="name" <c:if test="${field == 'name'}">selected</c:if>>이름</option>
			</select>
			<input name="search" value="${search }">
			<button>검색</button>
		</td>
	</tr>
</table>

<form>
<table width=700 align=center>
	<tr>
		<td><a href="list">[새로고침]</a></td>
		<td align=right><span onclick="fnNoticeWrite('${list.uid}')">[글쓰기]</span></td>
	</tr>
</table>
</form>