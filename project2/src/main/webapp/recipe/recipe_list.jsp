<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<head>
<style>
.no{
	display:inline-block;
	width:170px;
	text-align:center;
}
.subject{
	display:inline-block;
	width:170px;
	text-align:center;
}
.name{
	display:inline-block;
	width:170px;
	text-align:center;
}
.date{
	display:inline-block;
	width:170px;
	text-align:center;
}
.ref{
	display:inline-block;
	width:170px;
	text-align:center;
}
.refresh{
	display:inline-block;
}
.write{
	display:inline-block;
}
.today_recipe{
	font-size:30px;
	font-weight:bold;
}
</style>
</head>

<div>
	<div style="width:500px; display:inline-block;"></div>
	<div style="width:900px; border:1px solid black; display:inline-block;">
		<div class="today_recipe">오늘의 레시피</div>
		<form action="recipe_insert" method="post" enctype="multipart/form-data">
		<div style="width:900px; border:1px solid black; display:inline-block;">
			<div class="no">no</div>
			<div class="subject">subject</div>
			<div class="name">name</div>
			<div class="date">date</div>
			<div class="ref">ref</div>
		</div>
		
		<c:set var="number" value="${number }"/>
		<c:forEach var="list" items="${v }">
		<div style="width:900px; border:1px solid black; display:inline-block;">
			<div width=175px style="display:inline-block;">${number }</div>
			<div width=175px style="display:inline-block;"><a href="recipe_view?uid=${list.uid }">${list.subject }</div>
			<div width=175px style="display:inline-block;">${list.name }</div>
			<div width=175px style="display:inline-block;">${list.signdate }</div>
			<div width=175px style="display:inline-block;">${ref }</div>
		</div>
		<c:set var="number" value="${number -1 }"/>
		</c:forEach>
	
		<!-- 페이징 처리 -->
		<div style="width:900px; border:0px solid black; display:inline-block">
			<div>
				<div align=center>
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
				</div>
			</div>
		</div>
	
		<form name="" action="" method="get">
		<div style="width:900px; display:inline-block" align=center>
			<div>
				<div align=center>
					<select name="field">
						<option value="subject" <c:if test="${field == 'subject'}"> selected</c:if>>제목</option>
						<option value="comment" <c:if test="${field == 'comment'}"> selected</c:if>>내용</option>
						<option value="name" <c:if test="${field == 'name'}"> selected</c:if>>이름</option>
					</select>
					<input name="search" value="">
					<button>검색</button>
				</div>
			</div>
		</div>
		</form>
	
		<div style="width:900px; border:1px solid black; display:inline-block;" align=center>
				<div class="refresh"><a href=""><img src="/recipe/img/list.png" width=20px>새로고침</a></div>
				<div class="write"><a href="/recipe/recipe_write"><img src="/recipe/img/write.png" width=20px>글쓰기</a></div>
		</div>
	
		</div>
		</form>
	<div style="width:500px; display:inline-block;"></div>
</div>