<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<head>
<style>
.file1{
	border:1px solid black;
	width:500px;
	height:300px;
}
.subject{
	font-size:30px;
}
.quantity{
	width:295px;
	display:inline-block;
	font-weight:bold;
	text-align:center;
	font-size:20px;
	color:#bdbdbd;
}
.cooktime{
	width:295px;
	display:inline-block;
	font-weight:bold;
	text-align:center;
	font-size:20px;
	color:#bdbdbd;
}
.cooklevel{
	width:295px;
	display:inline-block;
	font-weight:bold;
	text-align:center;
	font-size:20px;
	color:#bdbdbd;
}
.ingredient{
	font-size:15px;
}
.seasoning{
	font-size:15px;
}
.comment{
	font-size:15px;
}
.mem_comment{
	display:inline-block;
}
</style>
</head>

<div>
	<div style="width:500px; display:inline-block;"></div>
	<div style="width:900px; display:inline-block; border:1px solid black;">
		<div>
			<div class="file1">${list.file1 }</div>
			<div class="subject">${list.subject }</div>
			<div style="width:295px; display:inline-block; text-align:center;"><img src="/recipe/img/quantity.png" width=20px></div>
			<div style="width:295px; display:inline-block; text-align:center;"><img src="/recipe/img/clock.png" width=20px></div>
			<div style="width:295px; display:inline-block; text-align:center;"><img src="/recipe/img/level.png" width=20px></div><br>
			<div class="quantity">${list.quantity }</div>
			<div class="cooktime">${list.cooktime }</div>
			<div class="cooklevel">${list.cooklevel }</div>
			<div style="display:inline-block; font-style:bold; font-size:15px;">재료 <p style="display:inline-block; font-style:italic; font-size:15px; color:#bdbdbd;">Ingredient</p></div><div class="ingredient">${list.ingredient }</div>
			<div class="seasoning">${list.seasoning }</div>
			<div class="comment">${list.comment }</div>
		</div>
		<div style="width:900px; display:inline-block; border:1px solid black;">
		<form action="recipe_comment_insert" method="post">
			<div class="mem_comment"><input type="text" width=400px></div><div style="display:inline-block;"><button>댓글쓰기</button></div>
		</form>
		</div>
		<div style="text-align:center;">
			<div style="display:inline-block;"><img src="/recipe/img/list.png" width=20px><a href="recipe_list">목록</a></div>
			<div style="display:inline-block;"><img src="/recipe/img/modify.png" width=20px><a href="recipe_modify">수정</a></div>
			<div style="display:inline-block;"><img src="/recipe/img/delete.png" width=20px>삭제</div>
		</div>
	</div>
	<div style="width:500px; display:inline-block;"></div>
</div>