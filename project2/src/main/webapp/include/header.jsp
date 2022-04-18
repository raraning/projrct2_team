<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Share Market</title>
<link href="/include/basic.css" rel="stylesheet" type="text/css">
<link href="/css/join.css" rel="stylesheet">
<link href="/css/login.css" rel="stylesheet">
<link href="/css/mypage.css" rel="stylesheet">
<link href="/css/admin_member.css" rel="stylesheet">
<link href="/css/width_height.css" rel="stylesheet">
<link href="/css/admin_mem_sellok.css" rel="stylesheet">
<link href="/css/admin_point.css" rel="stylesheet">
<link href="/css/admin_gongji.css" rel="stylesheet">
<link href="/css/cart.css" rel="stylesheet">
<link rel="shortcut icon" type="image⁄x-icon" href="/img/titlelogo2.png">

<%
String session_name = (String)session.getAttribute("name");
String session_id = (String)session.getAttribute("id");
String session_level = (String)session.getAttribute("level");

//현재 시간
Date nowTime = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdhhmmss");
String today = sf.format(nowTime);

if(session.getAttribute("cart") == null){
	session.setAttribute("cart",today);
}

String session_cart = (String)session.getAttribute("cart");;
%>
<style>
</style>
</head>
<body>
<c:if test="${sessionScope.level eq '10' }">
   관리자 : <a href="/admin/member/list">관리자</a><br>
   <hr>
</c:if>
<div class="headtop">
	<div class="htmenu htmempty"> </div>
	<div class="htmenu htm1">
		<c:choose>
			<c:when test="${sessionScope.name != null}">
				<a href="/member/sellerjoin">입점신청</a>
			</c:when>
		<c:otherwise>
			<a href="javascript:alert('로그인 후 신청가능합니다.\n로그인 후 신청해주세요.');">입점신청</a>
		</c:otherwise>
		</c:choose>
		</div>
	<div class="htmenu" style="width:670px;"> </div>
	<c:choose>
		<c:when test="${sessionScope.name != null}">
			<div class="htmenu htm2"><a href=""><b>${sessionScope.name}</b>님</a></div>
			<div class="htmenu htm3"><a href="/member/logout">로그아웃</a></div>
		</c:when>
	<c:otherwise>
		<div class="htmenu htm2"><a href="/member/login">로그인</a></div>
		<div class="htmenu htm3"><a href="/member/member_join">회원가입</a></div>
	</c:otherwise>
	</c:choose>
	<div class="htmenu htm4"><a href="">고객센터</a></div>
	<div class="htmenu htmempty"> </div>
</div>
<div class="topmenu">
	<div class="htmenu htmempty"> </div>
	<div class="htmenu category">
		<div style="line-height:15px;"><img src="/img/menu.png" width=30 height=30 style="padding-top:10px;"><br><b>카테고리</b></div>
		<div style="width:300px;">
			<div class="categorymenu1">
				<div class="pro_menu"><a href="/buyer/buyer_product_list">신상품</a></div>
				<div class="pro_menu"><a href="/buyer/buyer_product_list">추천상품</a></div>
				<div class="pro_menu"><a href="/buyer/buyer_product_list">전체상품</a></div>
				<div class="pro_menu"><a href="/buyer/buyer_product_list?pro_class=1">신선식품</a></div>
				<div class="pro_menu"><a href="/buyer/buyer_product_list?pro_class=2">냉장식품</a></div>
				<div class="pro_menu"><a href="/buyer/buyer_product_list?pro_class=3">가공식품</a></div>
			</div>
		</div>
	</div>
	<div class="htmenu"><a href="/"><img src="/img/logo2.png" width=170 height=70></a></div>
	<div class="htmenu search1">
		<input class="search2">
		<div class="htmenu sbutton"><img src="/img/search2.png" class="sbuttonimg"></div>
	</div>
	<div class="htmenu" style="width:30px;"> </div>
	<div class="htmenu" style="line-height:12px;">
		<a href="/member/my/mypage">
			<div><img src="/img/identified.png" width=35 height=35></div>
			<div>마이페이지</div>
		</a>
	</div>
	<div class="htmenu" style="width:5px;"> </div>
	<div class="htmenu" style="line-height:12px;">
		<a href="/cart/list">
			<div><img src="/img/trolley.png" width=35 height=35></div>
			<div>장바구니</div>
		</a>
	</div>
	<div class="htmenu htmempty"> </div>
</div>