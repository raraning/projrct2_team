<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- core -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- fmt -->


<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>

<style>
#width_5_left{
	width:5px;
	height:100%;
	float: left; 
}

.all_List_box{
	width:1430px;
	height:60px;
	margin: auto;
	background-color: #ff9999; 
}

.List_box{
	width: 125px;
	height: 60px;
	margin: auto;
	text-align:center;
	line-height:60px;	/*글자 세로 가운데 정렬*/
	font-size:13pt;
	font-weight: bold;
	background-color: #abbfd0;
	float: left; 
	cursor: pointer; /*마우스 손까락*/
}
</style>

<div class="all_List_box">
	<div class="List_box" onclick="location.href='/admin/member/list'">회원목록</div>
	<div id="width_5_left" style="background-color: #ff9999;"></div>
	<div class="List_box" onclick="location.href='/admin/sell/memberok_list'">판매자 신청</div>
	<div id="width_5_left" style="background-color: #ff9999;"></div>
	<div class="List_box" onclick="location.href='/admin/board/gongji_list'">공지사항</div>
	<div id="width_5_left" style="background-color: #ff9999;"></div>
	<div class="List_box">갤러리</div>
	<div id="width_5_left" style="background-color: #ff9999;"></div>
	<div class="List_box">질문&답변</div>
	<div id="width_5_left" style="background-color: #ff9999;"></div>
	<div class="List_box">쇼핑물 리스트</div>
	<div id="width_5_left" style="background-color: #ff9999;"></div>
	<div class="List_box" onclick="location.href='/admin/buy/list'">구메 리스트</div>
	<div id="width_5_left" style="background-color: #ff9999;"></div>
	<div class="List_box" onclick="location.href='/admin/sell/list'">판매 리스트</div>
	<div id="width_5_left" style="background-color: #ff9999;"></div>
	<div class="List_box">평점</div>
	<div id="width_5_left" style="background-color: #ff9999;"></div>
	<div class="List_box">쿠폰</div>
	<div id="width_5_left" style="background-color: #ff9999;"></div>
	<div class="List_box" onclick="location.href='/admin/point/list'">포인트</div>
</div>
