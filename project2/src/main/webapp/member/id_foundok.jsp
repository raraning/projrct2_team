<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/include/header.jsp" %>

<div class="main_box">
	<div class="login_main_box">
		<div class="login_login_box"><!-- 에러시 확인 style 없음 -->
			<div id="w20_left"></div>		
			<div class="login_mid_box">
				<div id="height_80"></div>
				<div class="login_main_name">회원님의 아이디는</div>
				<div id="height_10"></div>
				<div class="login_name_box" style="text-align: center;">${found }입니다.</div>
				<div class="login_name_box"></div>
				<div id="height_20"></div>
				<div class="login_name_box" style="text-align: center;"><a href="/member/login">로그인 페이지로 이동</a></div>	
				<div class="login_name_box"></div>
				<div id="height_30"></div>
				<br>
				<div class="login_main_name"></div>	
				<div id="height_20"></div>
			</div>
			<div id="w20_left"></div>
		</div>
	</div>
</div>


<%@include file="/include/footer.jsp" %>