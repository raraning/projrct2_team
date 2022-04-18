<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>

<%@include file="/admin/index.jsp" %>

<script>
	function join_id_use(id) {
		if (confirm("사용처리 하시겠습니까?") == true){
			location.href="/admin/member/joinuse?id="+id;
		}else{
			return false;
		}
	}
	function join_id_out(id) {
		if (confirm("휴먼처리 하시겠습니까?") == true){
			location.href="/admin/member/joinout?id="+id;
		}else{
			return false;
		}
	}
	function join_id_delete(id) {
		if (confirm("탈퇴처리 하시겠습니까?") == true){
			location.href="/admin/member/joindelete?id="+id;
		}else{
			return false;
		}
	}
</script>

<br>
<div class="mem_max_box">
	<div class="mem_lest_box">생성날짜</div>
	<div class="mem_lest_box">아이디</div>
	<div class="mem_lest_box">비밀번호</div>
	<div class="mem_lest_box">이름</div>
	<div class="mem_lest_box">셍년월일</div>
	<div class="mem_lest_box">성별</div>
	<div class="mem_lest2_box">이메일</div>
	<div class="mem_lest_box">상태</div>
	<div class="mem_lest_box">분류</div>
	<div class="mem_lest_box">제조사</div>
	<div class="mem_lest_box">판매업체</div>
	<div class="mem_lest_box">계정상태</div>
	<div class="mem_lest3_box">사용,휴먼,탈퇴</div>
</div>
<div class="mem_box">
	<c:forEach var="m" items="${m_list }">
	<div class="mem_max_box2">
		<div class="mem_lest_box2">${m.date.substring(0,10) }</div>
		<div class="mem_lest_box2"><a href="/admin/member/join_up?id=${m.id }">${m.id }</a></div>
		<div class="mem_lest_box2">${m.pass }</div>
		<div class="mem_lest_box2">${m.name }</div>
		<div class="mem_lest_box2">${m.birth }</div>
		<c:choose>
			<c:when test="${m.gender eq 'M'}">
				<div class="mem_lest_box2">남자</div>
			</c:when>
			<c:otherwise>
				<div class="mem_lest_box2">여자</div>
			</c:otherwise>
		</c:choose>
		<div class="mem_lest2_box2">${m.email }</div>
		<c:choose>
			<c:when test="${m.level eq '1'}">
				<div class="mem_lest_box2">회원</div>
			</c:when>
			<c:otherwise>
				<div class="mem_lest_box2">관리자</div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${m.sell_buy eq 'X'}">
				<div class="mem_lest_box2">구메자</div>
			</c:when>
			<c:otherwise>
				<div class="mem_lest_box2">판매자</div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${m.pro_manuname eq ''}">
				<div class="mem_lest_box2">없음</div>
			</c:when>
			<c:otherwise>
				<div class="mem_lest_box2">${m.pro_manuname }</div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${m.pro_salname eq ''}">
				<div class="mem_lest_box2">없음</div>
			</c:when>
			<c:otherwise>
				<div class="mem_lest_box2">${m.pro_salname }</div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${m.none eq '1'}">
				<div class="mem_lest_box2">사용중</div>
			</c:when>
			<c:when test="${m.none eq '2'}">
				<div class="mem_lest_box2">휴먼</div>
			</c:when>
			<c:otherwise>
				<div class="mem_lest_box2">탈퇴</div>
			</c:otherwise>
		</c:choose>
		<div class="mem_lest_box3">
		<c:choose>
			<c:when test="${m.none eq '1' }">
				<button onclick="join_id_out('${m.id }')" class="mem_button">휴먼</button>
				<button onclick="join_id_delete('${m.id }')" class="mem_button">탈퇴</button>
			</c:when>
			<c:when test="${m.none eq '2' }">
				<button onclick="join_id_use('${m.id }')" class="mem_button">사용</button>
				<button onclick="join_id_delete('${m.id }')" class="mem_button">탈퇴</button>
			</c:when>
			<c:otherwise>
				<button onclick="join_id_use('${m.id }')" class="mem_button">사용</button>
				<button onclick="join_id_out('${m.id }')" class="mem_button">휴먼</button>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
	</c:forEach>
</div>
<!------ 페이징 처리------ -->
<div class="mem_page_box">
	<div style="margin: auto;">
		<c:if test="${count>0 }">
			<c:set var="pageCount" value="${count / pageSize + (count % pageSize == 0 ? 0 : 1) }" />
			<fmt:parseNumber var="pageCount" value="${pageCount }" integerOnly="true" />
		
			<!-- 2개의 변수 초기화 -->
			<c:set var="startPage" value="${1 }" />
			<c:set var="pageBlock" value="${3 }" />	
		
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
<!------ 페이징 처리 끝------ -->
<form action="" method="get">
<div class="mem_page_box">
	<select name=field>
		<option value="id" <c:if test="${field eq 'id' }">selected</c:if>>아이디</option>
		<option value="name" <c:if test="${field eq 'name' }">selected</c:if>>이름</option>
		<option value="email" <c:if test="${field eq 'email' }">selected</c:if>>이메일</option>
		<option value="level" <c:if test="${field eq 'level' }">selected</c:if>>레벨</option>
		<option value="pro_manuname" <c:if test="${field eq 'pro_manuname' }">selected</c:if>>제조회사</option>
		<option value="pro_salname" <c:if test="${field eq 'pro_salname' }">selected</c:if>>판매자 명</option>
		<option value="none" <c:if test="${field eq 'none' }">selected</c:if>>계정상태</option>
	</select>
	<input name="search" value="${search }">
	<button>검색</button>
</div>
</form>
<div class="mem_max_box2">
	<dib class="mem_page_left"><a href="/admin/member/list">새로고침</a></dib>
	<dib class="mem_page_right"><a href="/admin/member/join">회원가입</a></dib>
</div>
<table height=300>
</table>