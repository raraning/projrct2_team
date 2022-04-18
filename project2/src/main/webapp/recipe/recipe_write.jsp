<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<head>
<style>
.subject{
	display:inline-block;
	width:80px;
}
.quantity{
	display:inline-block;
	width:80px;
}
.cooktime{
	display:inline-block;
	width:80px;
}
.cooklevel{
	display:inline-block;
	width:80px;
}
.ingredient{
	display:inline-block;
	width:80px;
}
.seasoning{
	display:inline-block;
	width:80px;
}
.comment{
	display:inline-block;
	width:80px;
}
.file1{
	display:inline-block;
	width:80px;
}
</style>
</head>

<div>
	<div style="width:500px; display:inline-block;"></div>
	<div style="width:900px; border:1px solid black; display:inline-block;">
		<form action="recipe_insert" method="post" enctype="multipart/form-data">
			<div class="subject">제목</div><div style="display:inline-block;"><input id="subject" name="subject"></div><br>
			<div class="quantity">분량</div><div style="display:inline-block;"><input id="quantity" name="quantity"></div><br>
			<div class="cooktime">조리시간</div><div style="display:inline-block;"><input id="cooktime" name="cooktime"></div><br>
			<div class="cooklevel">조리난이도</div>
				<div style="display:inline-block;">
					<input type="radio" id="cooklevel" name="cooklevel">쉬움
					<input type="radio" id="cooklevel" name="cooklevel">중간
					<input type="radio" id="cooklevel" name="cooklevel">어려움
				</div><br>
			<div class="ingredient">재료</div><div style="display:inline-block;"><input id="ingredient" name="ingredient"></div><br>
			<div class="seasoning">양념</div><div style="display:inline-block;"><input id="seasoning" name="seasoning"></div><br>
			<div class="comment">조리순서</div><div style="display:inline-block;"><textarea id="comment" name="comment" style="width:300px; height:200px;"></textarea></div><br>
			<div class="file1">첨부</div><div style="display:inline-block;"><input type="file" id="file1" name="file1"></div><br>
			<div align="center">
				<div style="display:inline-block;"><img src="/recipe/img/write.png" width=20px><button>글쓰기</button></div><div style="display:inline-block;"><img src="/recipe/img/list.png" width=20px><a href="recipe_list">목록</div>
			</div>
		</form>
	</div>
	<div style="width:500px; display:inline-block;"></div>
</div>