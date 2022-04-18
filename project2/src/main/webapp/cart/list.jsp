<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<script>
function cartdelete(pro_uid){
	if(confirm("삭제 하겠습니까? (оﾟдﾟо)?") == true){
		location.href="/cart/cart_delete?pro_uid="+pro_uid;
	}else{
		return false;
	}
}

function cartalldelete(id){
	if(confirm("전체삭제 하겠습니까? (оﾟдﾟо)?") == true){
		location.href="/cart/cart_all_delete?id="+id;
	}else{
		return false;
	}
}

</script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$('#pro_count').change(function(){
		$('#total_price').val(Number($('#pro_count').val()) * Number($('#pro_price').val()))
		$('#pro_point').val(Math.round((Number($('#total_price').val())) * 0.01 ));
	});
});

$(document).ready(function(){
	$('#pro_count').change(function(){
		var pro_uid = ($('#pro_uid').val());
		var pro_count = ($('#pro_count').val());
		var cart_session = ($('#cart_session').val());
		location.href="/cart/cart_count_change?pro_uid="+pro_uid+"&pro_count="+pro_count"&cart_session="+cart_session;
	});
});

</script>


<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	$("#list_chk_all").click(function() {
		if($("#list_chk_all").is(":checked")) $("input[name=list_chk]").prop("checked", true);
		else $("input[name=list_chk]").prop("checked", false);
	});
	
	$("input[name=list_chk]").click(function() {
		var total = $("input[name=list_chk]").length;
		var checked = $("input[name=list_chk]:checked").length;
		
		if(total != checked) $("#list_chk_all").prop("checked", false);
		else $("#list_chk_all").prop("checked", true); 
	});
});
</script>
<br>

<div class="car_list_all_box">
	<div class="car_list_main_name_box">장바구니 목록</div>
	<div class="car_list_main_name_box2">
		<div class="car_list_check_box"><input type="checkbox" id="list_chk_all" checked></div>
		<div class="car_list1_name_box">상품내용</div>
	</div>
	<c:set var="total_money" value="${0 }"/>
	<c:forEach var="list" items="${c_list}" >
	<input type="hidden" name="pay_ok" value="2">
	<input type="hidden" id="pro_uid" name="pro_uid" value="${list.pro_uid }">
	<input type="hidden" id="cart_session" name="cart_session" value="${list.cart_session }">
		<div class="car_list_name_box">
			<div class="car_list_check_box2"><input type="checkbox" id="list_chk" name="list_chk" checked></div>
			<div class="car_list_img1"><a href="/buyer/buyer_product_view?pro_uid=${list.pro_uid }"><img src="/upload/${list.file1 }" style="width:100%; height:100%"></a></div>
			<div class="car_list_name_box2">
				<div class="car_list_name2_box2">
					<a href="/buyer/buyer_product_view?pro_uid=${list.pro_uid }">&nbsp;&nbsp;${list.pro_name }</a>
					<select id="pro_count" name="pro_count">
							<option value="1" <c:if test="${list.pro_count eq '1'}">selected</c:if>>1</option>
							<option value="2" <c:if test="${list.pro_count eq '2'}">selected</c:if>>2</option>
							<option value="3" <c:if test="${list.pro_count eq '3'}">selected</c:if>>3</option>
							<option value="4" <c:if test="${list.pro_count eq '4'}">selected</c:if>>4</option>
							<option value="5" <c:if test="${list.pro_count eq '5'}">selected</c:if>>5</option>
							<option value="6" <c:if test="${list.pro_count eq '6'}">selected</c:if>>6</option>
							<option value="7" <c:if test="${list.pro_count eq '7'}">selected</c:if>>7</option>
							<option value="8" <c:if test="${list.pro_count eq '8'}">selected</c:if>>8</option>
							<option value="9" <c:if test="${list.pro_count eq '9'}">selected</c:if>>9</option>
							<option value="10" <c:if test="${list.pro_count eq '10'}">selected</c:if>>10</option>		
					</select>
					<input type="hidden" id="pro_price" value="${list.pro_price}" readonly>개&nbsp;
					개당 ${list.pro_price}&nbsp;${Math.round(list.pro_price * 0.01)}마일리지
				</div>
				<div class="car_list_name3_box2">	
					<input id="total_price" name="pro_price" value="${list.pro_price * list.pro_count}" readonly class="car_list_button2">원
					<input id="pro_point" name="pro_point" value="${Math.round(list.pro_price * 0.01) * list.pro_count}" readonly class="car_list_button3">마일리지
				</div>
			</div>
			
			<div class="car_list_name_box3">
			</div>
			<div class="car_list_name_box3">
				<button class="car_list_button" onclick="cartdelete('${list.pro_uid}')">삭제</button>
			</div>
		</div>
	<c:set var="total_money" value="${total_money = total_money + (list.pro_price * list.pro_count) }"/>
	</c:forEach>
</div>
<div class="car_list_all_box">
	<div class="car_list_main_page_box">
		<div>
			총 가격 : ${total_money }원&nbsp;&nbsp;&nbsp;&nbsp;
			총 마일리지 : ${Math.round(total_money * 0.01) }마일리지
		</div>
	</div>
</div>
<div class="car_list_all_box">
	<div class="car_list_button_all_box">
		<button class="car_list_button4" onclick="cartalldelete('')">전체 삭제</button>
		<button class="car_list_button" onclick="location.href='/order/order_list'">구매</button>
	</div>
</div>
















