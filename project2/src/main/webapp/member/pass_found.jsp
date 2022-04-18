<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/include/header.jsp" %>

<div class="main_box">
	<div class="login_main_box">
		<div class="login_login_box"><!-- 에러시 확인 style 없음 -->
			<div id="w20_left"></div>		
			<div class="login_mid_box">
				<div id="height_80"></div>
			<form action="member_pass_found_ok" method="post" onsubmit="return go()">
				<div class="login_main_name">비밀번호 찾기</div>
				<div id="height_10"></div>
				<div class="login_name_box">아이디</div>
				<div class="login_name_box"><input type="text" id="id" name="id" maxlength="16" class="login_input_box"></div>
				<div id="height_20"></div>
				<div class="login_name_box">이메일</div>	
				<div class="login_name_box"><input type="email" id="email" name="email" maxlength="20" class="login_input_box"></div>
				<div id="height_30"></div>
				<br>
				<div class="login_main_name"><button class="login_button_box">찾기</button></div>
			</form>	
				<div id="height_20"></div>
			</div>
			<div id="w20_left"></div>
		</div>
	</div>
</div>


<%@include file="/include/footer.jsp" %>