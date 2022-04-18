<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
    <div style="width:500px; display:inline-block;"></div>
    <form action="recipe_insert" method="post">
    <div style="width:900px; border:1px solid black; display:inline-block;">
        <div>
            <div>no</div>
            <div>subject</div>
            <div>name</div>
            <div>date</div>
            <div>ref</div>
        </div>
        
        <c:set var="number" value="${number }"/>
		<c:forEach var="list" items="${v }">
        <div>
            <div>${number }</div>
            <div>${subjct }</div>
            <div>${name }</div>
            <div>${date }</div>
            <div>${ref }</div>
        </div>
        <c:set var="number" value="${number -1 }"/>
		</c:forEach>
    </div>
    </form>
    
<!-- 페이징 처리 -->
<div style="width:900px; border:1px solid black; text-align:center;">
	<div>
		<div style="text-align:center">
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
    <div style="width:500px; display:inline-block;"></div>
</body>