<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<link href="/css/buyer_product_list.css" rel="stylesheet">
<style>
	.main1{
		display:inline-block;
	}
	.banner1{
		width:875px;
		height:250px;
		border:1px solid black;
		margin-top:15px;
	}
	.main1product{
		width:375px;
		height:62px;
		border:1px solid black;
		margin-top:-1px;
	}
	.m1left{
		width:494px;
	}
	.pro_index{
		font-size:20px;
	}
</style>
<div style="height:30px;"> </div>
<div>
	<div class="main1 m1left"> </div>
	<div class="main1">
	<div class="pro_index">
		<a href="/buyer/buyer_product_list">
			<div><img src="/img/logo2.png"></div>
			<div>▲전체상품 바로가기</div>
		</a>
	</div>
	<div class="pro_index">
		<a href="/buyer/buyer_product_list?pro_class=1">
			<div><img src="/img/fresh.png"></div>
			<div>▲신선식품 바로가기</div>
		</a>
	</div>
	<div class="pro_index">
		<a href="/buyer/buyer_product_list?pro_class=2"><div>▲냉장식품 바로가기</div></a>
	</div>
	<div class="pro_index">
		<a href="/buyer/buyer_product_list?pro_class=3"><div>▲가공식품 바로가기</div></a>
	</div>
	<div class="pro_index">
		<a href="/recipe/recipe_list">요리레시피 바로가기</a>
	</div>
	</div>
	<div class="main1 m1left"> </div>
</div>
<div style="height:30px;"> </div>


<%@ include file="/include/footer.jsp" %>