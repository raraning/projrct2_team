<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/include/header.jsp" %>

<script>
function id_select(id){
	$.ajax({
		url:"idok",
		type: "post",
		dataType: "text",
		data: "id="+id,
		error:function(){
			alert("실패");
		},
		success:function(text){
			$("#id_result").html(text);
		}
	});
}
function join_go() {
	window.open("join_go.jsp", "idwin", "width=900, height=660");
}
</script>
<div style="height:10px"> </div>
<form name="join" action="seller_join_insert" method="post" onsubmit="return go()">
<input type="hidden" name="level" value="1">
<input type="hidden" name="none" value="1">
<div class="main_box">
	<div class="join_main_box">
		<div class="join_join_box"><!-- 에러시 확인 style 없음 -->
			<div id="w20_left"></div>
			<div class="join_mid_box">
				<div style="height:20px"></div>
				<div class="join_main_name">판매자등록(입점) 신청</div>
				<br>
				<div id="height_10"></div>
				<div class="join_name_box">아이디</div>
				<div class="join_name_box">
					<div class="join_id_box"><input type="text" id="id" name="id" value="" placeholder="<%=session_id%>" maxlength="16" class="join_id_input_box" style="width:450px;" readonly></div>
				</div>
				<div style="height:10px"> </div>
				<div class="join_name_box">이름</div>
				<div class="join_name_box"><input type="text" id="name2" name="name" value="" placeholder="<%=session_name%>" maxlength="10" class="join_input_box" readonly></div>
				<div style="height:10px"> </div>
				<div class="join_name_box">제조사명</div>
				<div class="join_name_box"><input type="text" id="birth" name="birth" value="" placeholder="" maxlength="8" class="join_input_box"></div>
				<div style="height:10px"> </div>
				<div class="join_name_box">판매업체명</div>
				<div class="join_name_box"><input type="email" id="email" name="email" value="" placeholder="" maxlength="25" class="join_input_box"></div>
				<div style="height:10px"> </div>
				<br>
				<div class="join_main_name"><button class="join_button_box">입점신청</button></div>
			</div>
			<div id="w20_left"></div>
		</div>
	</div>
</div>
</form>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
</script> -->
<%@include file="/include/footer.jsp" %>