<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<%
//현재 시간
Date nowTime3 = new Date();
SimpleDateFormat sf3 = new SimpleDateFormat("yyyy-MM-dd");
String today3 = sf3.format(nowTime3);
%>
<link href="/css/product_register.css" rel="stylesheet">
<resources mapping="/ckeditor/**" location="/ckeditor/" />
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="/ckeditor/ckeditor.js"></script>

<script type="text/javascript">
	//글쓰기 유효성 alert
	function pro_write(){
		if(pro_name.value == ""){
			alert("상품명을 입력해주세요");
			pro_name.focus();
			return false;
		}
		
		if(pro_category.value == ""){
			alert("카테고리를 선택해주세요");
			return false;
		}
		
		if(pro_available.value == ""){
			alert("재고 수량을 입력해주세요");
			pro_available.focus();
			return false;
		}
		
		if(pro_price.value == ""){
			alert("상품 가격을 입력해주세요");
			pro_price.focus();
			return false;
		}
		
		if(pro_detailing.value == ""){
			alert("상품 상세정보를 적어주세요");
			pro_detailing.focus();
			return false;
		}
		
		document.submit();
	}

	//카테고리 선택 jquery
	$(document).ready(function(){
		var pro_class = "${list.pro_class}"; //디비에서 읽어온 상품 카테고리 값
		if(pro_class == "1"){
			$("#fresh_category").show();
			$("#freeze_category").hide();
			$("#process_category").hide();
		}else if(pro_class == "2"){
			$("#fresh_category").hide();
			$("#freeze_category").show();
			$("#process_category").hide();
		}else if(pro_class == "3"){
			$("#fresh_category").hide();
			$("#freeze_category").hide();
			$("#process_category").show();
		}
		
		$("input[name='pro_class']:radio").change(function(){
			var pro_class = this.value;
			
			if(pro_class == "1"){
				$("#fresh_category").show();
				$("#freeze_category").hide();
				$("#process_category").hide();
			}else if(pro_class == "2"){
				$("#fresh_category").hide();
				$("#freeze_category").show();
				$("#process_category").hide();
			}else if(pro_class == "3"){
				$("#fresh_category").hide();
				$("#freeze_category").hide();
				$("#process_category").show();
			}
		});
	});

	//판매상품등록 게시판에디터
	window.onload = function(){
	       ck = CKEDITOR.replace("pro_detailing");
	};
	
	//마일리지 자동계산
	$(document).ready(function(){
		$('#pro_price').change(function() {
		    $('#pro_point').val( Math.round(Number($('#pro_price').val()) * 0.01 ))
		});
	});
	
	//이미지업로드 미리보기
	$(document).ready(function(){
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#file1img').attr('src', e.target.result); 
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
	
		$(":input[name='file1']").change(function() {
			if( $(":input[name='file1']").val() == '' ) {
				$('#file1img').attr('src' , '');  
			}
			$('.input_file_button').css({ 'display' : '' });
			readURL(this);
		});
	});
	
	$(document).ready(function(){
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#file2img').attr('src', e.target.result); 
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
	
		$(":input[name='file2']").change(function() {
			if( $(":input[name='file2']").val() == '' ) {
				$('#file2img').attr('src' , '');  
			}
			$('.input_file_button').css({ 'display' : '' });
			readURL(this);
		});
	});
	
	$(document).ready(function(){
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#file3img').attr('src', e.target.result); 
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
	
		$(":input[name='file3']").change(function() {
			if( $(":input[name='file3']").val() == '' ) {
				$('#file3img').attr('src' , '');  
			}
			$('.input_file_button').css({ 'display' : '' });
			readURL(this);
		});
	});
	
	
</script>
<div style="height:30px;"> </div>
<div>
	<div class="pro_listempty"> </div>
	<div class="pro_listtop"><a href="seller_product_list">상품 리스트가기</a></div>
	<div class="pro_listempty2"> </div>
	<div class="pro_listtop"><a href="seller_product_register">상품 등록하기</a></div>
	<div class="pro_listempty"> </div>
</div>
<div style="height:30px;"> </div>
<div style="width:1750px;">
	<div style="width:500px; display:inline-block;"></div>
	<div style="width:900px; display:inline-block;">
		<div class="pro_title">SHARE MARKET 판매 상품 수정하기</div>
		<div style="height:20px;"> </div>
	<form action="product_modify_insert" method="post" enctype="multipart/form-data" onsubmit="return pro_write();">
		<input type="hidden" id="pro_uid" name="pro_uid" value="${list.pro_uid}">
		<input type="hidden" id="pro_id" name="pro_id" value="${member.id }">
		<div class="pro_info">
			<div class="pro_name1 pnright1"><img src="/img/store.png" width=33 height=33></div><div class="pro_name1 pnright2">판매자정보</div>
			<div class="pro_name1" style="width:50px;"> </div>
			<div class="pro_name1 pnleft"><font color="#4b3c8e"><b>제조사명</b></font> <img src="/img/right.png" width=13 height=13> <input id="pro_manuname" name="pro_manuname" value="${list.pro_manuname }" readonly></div>
			<div class="pro_name1" style="width:50px;"> </div>
			<div class="pro_name1 pnleft"><font color="#4b3c8e"><b>판매업체명</b></font> <img src="/img/right.png" width=13 height=13> <input id="pro_salname" name="pro_salname" value="${list.pro_salname }" readonly></div>
		</div>
		<div style="height:10px;"> </div>	
		<div class="pro_name2">&nbsp;&nbsp;<input id="pro_name" name="pro_name" value="${list.pro_name }" placeholder="상품명을 입력해주세요"></div>
		<div style="height:10px;"> </div>
		<!-- 카테고리 및 수량 입고날짜 시작 -->
		<div>
			<div class="pro_mid">
				<div class="pmleft1">
					<div class="pro_class">상품 분류</div><div style="display:inline-block;width:40px;"> </div>
					<c:choose>
						<c:when test="${list.pro_class eq '1'}">
							<input type="radio" id="pro_class" name="pro_class" value="1" checked> 신선식품 
							<input type="radio" id="pro_class" name="pro_class" value="2"> 냉장식품
							<input type="radio" id="pro_class" name="pro_class" value="3"> 가공식품
						</c:when>
						<c:when test="${list.pro_class eq '2'}">
							<input type="radio" id="pro_class" name="pro_class" value="1"> 신선식품 
							<input type="radio" id="pro_class" name="pro_class" value="2" checked> 냉장식품
							<input type="radio" id="pro_class" name="pro_class" value="3"> 가공식품
						</c:when>
						<c:otherwise>
							<input type="radio" id="pro_class" name="pro_class" value="1"> 신선식품 
							<input type="radio" id="pro_class" name="pro_class" value="2"> 냉장식품
							<input type="radio" id="pro_class" name="pro_class" value="3" checked> 가공식품
						</c:otherwise>
					</c:choose>
				</div>
				<div class="pmleft2">
					<div class="pro_category">상품 카테고리</div>
					<span id="fresh_category">
						<select id="pro_category" name="pro_category">
							<option value="" selected disabled hidden>선택하세요</option>
							<option value="과일" <c:if test="${list.pro_category eq '과일'}">selected</c:if>>과일</option>
							<option value="채소/쌀/잡곡" <c:if test="${list.pro_category eq '채소/쌀/잡곡'}">selected</c:if>>채소/쌀/잡곡</option>
							<option value="축산/계란" <c:if test="${list.pro_category eq '축산/계란'}">selected</c:if>>축산/계란</option>
						</select>
					</span>
					<span id="freeze_category" style="display:none;">
						<select id="pro_category" name="pro_category">
							<option value="" selected disabled hidden>선택하세요</option>
							<option value="냉장/냉동/간편요리" <c:if test="${list.pro_category eq '냉장/냉동/간편요리'}">selected</c:if>>냉장/냉동/간편요리</option>
							<option value="수산물/냉동육류" <c:if test="${list.pro_category eq '수산물/냉동육류'}">selected</c:if>>수산물/냉동육류</option>
							<option value="생수/음료" <c:if test="${list.pro_category eq '생수/음료'}">selected</c:if>>생수/음료</option>
						</select>
					</span>
					<span id="process_category" style="display:none;">
						<select id="pro_category" name="pro_category">
							<option value="" selected disabled hidden>선택하세요</option>
							<option value="유제품/아이스크림" <c:if test="${list.pro_category eq '유제품/아이스크림'}">selected</c:if>>유제품/아이스크림</option>
							<option value="장/소스/드레싱/식초" <c:if test="${list.pro_category eq '장/소스/드레싱/식초'}">selected</c:if>>장/소스/드레싱/식초</option>
							<option value="과자/초콜릿/시리얼" <c:if test="${list.pro_category eq '과자/초콜릿/시리얼'}">selected</c:if>>과자/초콜릿/시리얼</option>
						</select>
					</span>
				</div>
			</div><div class="pro_mid pmright">
						<div class="pmright1">
							<div class="pro_available">재고 수량</div>
							<input id="pro_available" name="pro_available" value="${list.pro_available }" placeholder="수량을 입력하세요">
						</div>
						<div class="pmright2">
							<div class="pro_indate">입고 날짜</div>
							  Today <input id="pro_indate" name="pro_indate" value="<%=today3%>" readonly>
						</div>
					</div>
		</div>
		<!-- 카테고리 및 수량 입고날짜 끝 -->
		<!-- 가격과 마일리지 시작 -->
		<div class="pmleft3">
			<div class="pro_price">상품 가격</div>
				<div class="pp1"><input id="pro_price" name="pro_price" onkeyup="inputNumberFormat(this)" value="${list.pro_price }" placeholder="가격을 입력하세요">원</div>
			<div class="pro_point">&nbsp;마일리지 금액(1%자동 적립) : </div>
				<input id="pro_point" name="pro_point" value="${list.pro_point }" readonly>원
		</div>
		<!-- 가격과 마일리지 끝 -->
		<!-- 대표사진(사진첨부) 시작 -->
		<div style="height:10px;"> </div>
		<div class="pro_bottom">
			<div class="pro_file pfleft">대표 사진<br>선택하기</div>
			<div class="pfempty" style="width:200px;"></div>
			<div class="pro_file">
				<div style="height:15px;"> </div>
				<div><label class="input_file_button" for="file1"><img id="file1img" src="/upload/${list.file1_s }" width=70 height=70 title="클릭하여 파일선택"></label><input type="file" name="file1" id="file1" accept="image/*" style="display:none;"></div>
				<div>상품 대표 사진</div>
			</div>
			<div class="pfempty"></div>
			<div class="pro_file">
				<div style="height:10px;"> </div>
				<div><label class="input_file_button" for="file2"><img id="file2img" <c:choose><c:when test="${list.file2_s eq ''}">src="/img/camera.png"</c:when><c:otherwise>src="/upload/${list.file2_s}"</c:otherwise></c:choose> width=70 height=70 title="클릭하여 파일선택"></label><input type="file" name="file2" id="file2" accept="image/*" style="display:none;"></div>
				<div>&nbsp;&nbsp;추가 사진1</div>
			</div>
			<div class="pfempty"></div>
			<div class="pro_file">
				<div style="height:10px;"> </div>
				<div><label class="input_file_button" for="file3"><img id="file3img" <c:choose><c:when test="${list.file3_s eq ''}">src="/img/camera.png"</c:when><c:otherwise>src="/upload/${list.file3_s}"</c:otherwise></c:choose> width=70 height=70 title="클릭하여 파일선택"></label><input type="file" name="file3" id="file3" accept="image/*" style="display:none;"></div>
				<div>&nbsp;&nbsp;추가 사진2</div>
			</div>
		</div>
		<!-- 대표사진(사진첨부) 끝 -->
		<div style="height:10px;"> </div>
		<div class="detail_title">상품 상세정보 글쓰기 ▼</div>
		<div style="height:5px;"> </div>
		<div>
			<textarea name="pro_detailing" id="pro_detailing">${list.pro_detailing }</textarea>
		</div>
		<div style="height:5px;"> </div>
		<div>
			<div class="pro_button pb1"><a href="seller_product_list">등록상품 리스트</a></div>
			<div class="pro_button pb2"></div>
			<div class="pro_button pb3"><button>수정하기</button></div>
		</div>
		</form>
	</div>
	<div style="width:700px; border:0px solid black; display:inline-block;"></div>
</div>
