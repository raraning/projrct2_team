<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<link href="/css/Order.css" rel="stylesheet">
<script>
function cartdelete(pro_uid){
	if(confirm("삭제하겠습니까?") == true){
		location.href="/cart/cart_delete?pro_uid="+pro_uid;
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
<script>
function member_ok() {
	order.get_name.value = order.name.value;
	order.get_phone.value = order.phone.value;
	order.get_zipcode.value = order.zipcode.value;
	order.get_zipcode1.value = order.zipcode1.value;
	order.get_zipcode2.value = order.zipcode2.value;
	order.get_zipcode3.value = order.zipcode3.value;
	order.get_zipcode4.value = order.zipcode4.value;
}
function member_no() {
	order.get_name.value = "";
	order.get_phone.value = "";
	order.get_zipcode.value = "";
	order.get_zipcode1.value = "";
	order.get_zipcode2.value = "";
	order.get_zipcode3.value = "";
	order.get_zipcode4.value = "";
}
</script>

<form name="order" action="order_go" method="post" onsubmit="return go()">
<div class="car_list_all_box">
	<div class="car_list_main_name_box">구매 목록</div>
	<div class="car_list_main_name_box2">
		<div class="car_list_check_box"><input type="checkbox" id="list_chk_all" checked></div>
		<div class="car_list1_name_box">상품내용</div>
	</div>
	<c:set var="total_money" value="${0 }"/>
	<c:forEach var="list" items="${c_list}">
	<input type="hidden" name="cart_session" value="${sessionScope.cart }">
	<input type="hidden" name="pay_ok" value="2">
	<input type="hidden" name="id" value="${member.id }">
	<input type="hidden" name="pro_uid" value="${list.pro_uid }">	
	<input type="hidden" name="pro_count" value="${list.pro_count }">
		<div class="car_list_name_box">
			<div class="car_list_check_box2"><input type="checkbox" id="list_chk"></div>
			<div class="car_list_img1"><img src="/upload/${list.file1 }" style="width:100%; height:100%"></div>
			<div class="car_list_name_box2">
				<div class="car_list_name2_box2">
					<a href="/buyer/buyer_product_view?pro_uid=${list.pro_uid }">&nbsp;&nbsp;${list.pro_name }</a>
					${list.pro_count}개&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					개당 ${list.pro_price}원
					<input class="or_list_input_box3" type="hidden" id="pro_price" value="${list.pro_price}" readonly >
				</div>
				<div class="car_list_name3_box2">	
				<input class="or_list_input_box2" id="total_price" value="${list.pro_price * list.pro_count}" readonly class="car_list_button2">원
				<input class="or_list_input_box3" id="pro_point" value="${Math.round(list.pro_price * 0.01) * list.pro_count}" readonly class="car_list_button3">마일리지
				</div>
			</div>
			<div class="car_list_name_box4">
			</div>
		</div>
		<c:set var="total_money" value="${total_money = total_money + (list.pro_price * list.pro_count) }"/>
	</c:forEach>
</div>
<div class="car_list_all_box">
	<div class="car_list_main_page_box">
		<div>
			총 가격 : ${total_money }원&nbsp;&nbsp;&nbsp;&nbsp;
			총 마일리지 : ${Math.round(total_money * 0.01) }
		</div>
	</div>
</div>
<!-- 보내는 사람 -->
<div id="height_50"></div>
<div class="or_list_all_box">
	<div class="or_list_main_name_box">&nbsp;&nbsp;&nbsp;주문하시는 분</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;이름</div>
		<div class="or_list_name_box3"><input type="text" id="name" name="name" value="${member.name }" class="or_list_input_box1"></div>
	</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;전화번호</div>
		<div class="or_list_name_box3"><input id="phone" name="phone" value="${member.phone }" class="or_list_input_box1"></div>
	</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;주소</div>
		<div class="or_list_name_box3">
			<input type="text" id="sample4_postcode" name="zipcode" value="${member.zipcode }" placeholder="우편번호" readonly class="or_list_input_box1">
			<input type="button" onclick="sample4_execDaumPostcode()" value="주소 찾기" class="or_list_input_box1">
			<span id="guide" style="color:#999;display:none"></span>
		</div>
	</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2"></div>
		<div class="or_list_name_box3">
			<input type="text" id="sample4_roadAddress" name="zipcode1" value="${member.zipcode1 }" placeholder="도로명주소" readonly class="or_list_input_box1">
			<input type="text" id="sample4_jibunAddress" name="zipcode2" value="${member.zipcode2 }" placeholder="지번주소(선택)" class="or_list_input_box1">
		</div>
	</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2"></div>
		<div class="or_list_name_box3">
			<input type="text" id="sample4_detailAddress" name="zipcode3" value="${member.zipcode3 }" placeholder="상세주소(선택)" class="or_list_input_box1">
			<input type="text" id="sample4_extraAddress" name="zipcode4" value="${member.zipcode4 }" placeholder="참고항목(선택)" class="or_list_input_box1">
		</div>
	</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;이메일</div>
		<div class="or_list_name_box3"><input type="email" id="email" name="email" value="${member.email }" class="or_list_input_box1"></div>
	</div>
</div>
<div id="height_50"></div>
<!-- 받는사람 -->
<div class="or_list_all_box">
	<div class="or_list_main_name_box">&nbsp;&nbsp;&nbsp;받으시는 분</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;</div>
		<div class="or_list_name_box3">
			<input type="radio" id="" name="" value="" onclick="member_ok()">보내는사람 동일
			<input type="radio" id="" name="" value="" onclick="member_no()"checked>동일 아님
		</div>
	</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;이름</div>
		<div class="or_list_name_box3"><input type="text" id="get_name" name="get_name" value="" class="or_list_input_box1"></div>
	</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;전화번호</div>
		<div class="or_list_name_box3"><input id="get_phone" name="get_phone" value="" class="or_list_input_box1"></div>
	</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;주소</div>
		<div class="or_list_name_box3">
			<input type="text" id="sample4_postcode1" name="get_zipcode" placeholder="우편번호" readonly class="or_list_input_box1">
			<input type="button" onclick="sample4_execDaumPostcode()" value="주소 찾기" class="or_list_input_box1">
			<span id="guide1" style="color:#999;display:none"></span>
		</div>
	</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2"></div>
		<div class="or_list_name_box3">
			<input type="text" id="sample4_roadAddress1" name="get_zipcode1" placeholder="도로명주소" readonly class="or_list_input_box1">
			<input type="text" id="sample4_jibunAddress1" name="get_zipcode2" placeholder="지번주소(선택)" class="or_list_input_box1">
		</div>
	</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2"></div>
		<div class="or_list_name_box3">
			<input type="text" id="sample4_detailAddress1" name="get_zipcode3" placeholder="상세주소(선택)" class="or_list_input_box1">
			<input type="text" id="sample4_extraAddress1" name="get_zipcode4" placeholder="참고항목(선택)" class="or_list_input_box1">
		</div>
	</div>
	<div class="or_list_text_box1">
		<div class="or_list_text_box2">&nbsp;&nbsp;&nbsp;전하실 말씀</div>
		<div class="or_list_text_box3">
			<textarea type="text" id="message" name="message" class="or_list_text"></textarea>
		</div>
	</div>
</div>
<div id="height_20"></div>
<div class="or_list_all_box">
	<div class="or_list_main_name_box">&nbsp;&nbsp;&nbsp;무통장입금</div>
	<input type="hidden" name="howpay" value="무통장">
	<div class="or_list_name_box1">
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;은행</div>
		<div class="or_list_name_box4"><input type="text" id="bank1" name="bank1" class="or_list_input_box1">은행</div>
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;계좌번호</div>
		<div class="or_list_name_box4"><input type="text" id="howpay_num" name="howpay_num" class="or_list_input_box1"></div>
	</div>
	<div class="or_list_name_box1">
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;예금주 명</div>
		<div class="or_list_name_box4"><input type="text" id="bank1_get_name" name="bank1_get_name" class="or_list_input_box1"></div>
		<div class="or_list_name_box2">&nbsp;&nbsp;&nbsp;입금자 명</div>
		<div class="or_list_name_box4"><input type="text" id="bank1_give_name" name="bank1_give_name" class="or_list_input_box1"></div>
	</div>
</div>
<div id="height_20"></div>
<div class="car_list_all_box">
	<div class="car_list_button_all_box">
		<button class="or_button_box1" onclick="cartdelete('')">취소</button>
		<button class="or_button_box1" onclick="location.href='/order/order_list'">주문하기</button>
	</div>
</div>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode1').value = data.zonecode;
                document.getElementById("sample4_roadAddress1").value = roadAddr;
                document.getElementById("sample4_jibunAddress1").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress1").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress1").value = '';
                }

                var guideTextBox = document.getElementById("guide1");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
</form>
<div id="height_100"></div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<%@ include file="/include/footer.jsp" %>














