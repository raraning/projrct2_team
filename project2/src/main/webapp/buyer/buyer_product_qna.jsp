<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
String pro_uid = request.getParameter("pro_uid");
String pro_name = request.getParameter("pro_name");
String pro_salname = request.getParameter("pro_salname");
%>
<title>SHARE MARKET 상품문의</title>
<link rel="shortcut icon" type="image⁄x-icon" href="/img/titlelogo2.png">
<style>
	.qna_title{
		background:#f0f0f0;
		height:45px;
		font-weight:bold;
		line-height:43px;
	}
	
	.qna_title2{
		height:40px;
		border-top:2px solid black;
		line-height:43px;
		font-size:12px;
	}
	
	.qna_pro_name{
		display:inline-block;
		border-right:1px solid #ccc;
		width:80px;
		font-weight:bold;
	}
	
	.qna_title3{
		height:40px;
		border-top:1px solid #ccc;
		line-height:43px;
		font-size:12px;
	}
	
	.qna_title4{
		height:100px;
		border-top:1px solid #ccc;
		border-bottom:1px solid #ccc;
		font-size:12px;
	}
	
	.qna_pro_comment{
		display:inline-block;
		border-right:1px solid #ccc;
		width:80px;
		height:73px;
		font-weight:bold;
		padding-top:27px;
		vertical-align:top;
	}
	
	textarea{
		width:370px;
		height:90px;
		resize:none;
	}
	
	button {
	  -webkit-appearance: none;
	  -moz-appearance: none;
	  appearance: none;
	}
	
	.qna_button_ok{
		width:90px;
		height:30px;
		background:#ef9696;
		border:1px solid #f0f0f0;
		cursor:pointer;
	}
	
	.qna_button_no{
		width:90px;
		height:30px;
		background:white;
		border:1px solid #f0f0f0;
		font-size:13px;
		cursor:pointer;
		text-align:center;
		display:inline-block;
		line-height:32px;
	}
</style>
<script>
	function qna_ok(){
		if(comment.value == ""){
			alert("문의내용을 입력해주세요");
			return false;
		}
		
		document.submit();
	}
</script>
<div>
	<div class="qna_title"> 상품 문의</div>
	<div style="height:15px"> </div>
	<form action="/productqna/buyer_product_qna" method="post" onsubmit="return qna_ok()">
	<input type="hidden" id="pro_uid" name="pro_uid" value="${param.pro_uid}">
	<input type="hidden" id="qna" name="qna" value="1">
	<div class="qna_title2">
		<div class="qna_pro_name">상품명</div>
		<div style="display:inline-block;">${param.pro_name}</div>
	</div>
	<div class="qna_title3">
		<div class="qna_pro_name">판매자명</div>
		<div style="display:inline-block;">${param.pro_salname}</div>
	</div>
	<div class="qna_title4">
		<div class="qna_pro_comment">문의내용</div>
		<div align=center style="display:inline-block;">
			<div style="height:5px"> </div>
			<div><textarea id="comment" name="comment"></textarea></div>
		</div>
	</div>
	<div style="height:13px"> </div>
	<div style="font-size:11px;">* 개인정보(주민번호, 연락처, 주소, 계좌번호, 카드번호 등)가 포함되지 않도록 유의해주세요.</div>
	<div style="height:13px"> </div>
	<div>
		<div style="display:inline-block;width:140px;"> </div>
		<div style="display:inline-block;"><button class="qna_button_ok">확인</button></div>
		<div style="display:inline-block;"><span class="qna_button_no">취소</span></div>
		<div style="display:inline-block;width:150px;"> </div>
	</div>
	</form>
</div>