<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/include/header.jsp" %>

<script type="text/javascript" src="/js/join.js" ></script>

<div class="main_box">
	<div class="login_main_box">
		<div class="login_login_box"><!-- 에러시 확인 style 없음 -->
			<div id="login_left"> </div>		
			<div class="login_mid_box">
				<div style="height:40px"></div>
			<form name="join" action="member_login_ok" method="post" onsubmit="return go()">
				<div class="login_main_name">SHARE MARKET 로그인</div>
				<div style="height:30px"></div>
				<div class="login_name_box"><input type="text" id="id" name="id" maxlength="16" placeholder="아이디를 입력해주세요" class="login_input_box"></div>
				<div style="height:5px;"></div>
				<div class="login_name_box"><input type="password" id="pass" name="pass" maxlength="20" placeholder="비밀번호를 입력해주세요" class="login_input_box"></div>
				<div style="height:20px"></div>
				<br>
				<div><button class="login_button_box1">로그인</button></div>
			</form>
				<div style="height:5px;"> </div>
				<div><button class="login_button_box2" onclick="location.href='/member/member_join'">회원가입</button></div>
				<div id="height_20"></div>
				<div>
					<div class="login_name_box_found">
						<a href="/member/member_id_found">아이디 찾기</a>
					</div>
					<div style="display:inline-block;width:185px;"> </div>
					<div class="login_name_box_found">
						<a href="/member/member_pass_found">비밀번호 찾기</a>
					</div>
				</div>
			</div>
			<div id="login_right"> </div>
		</div>
	</div>
</div>


<%@include file="/include/footer.jsp" %>