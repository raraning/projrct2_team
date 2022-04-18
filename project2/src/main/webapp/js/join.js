function go(){
	
	if(join.id.value == ""){
		alert("아이디를 입력하세요.");
		join.id.focus();
		return false;
	}
	
	if(join.id.value.length < 6){
		alert("아이디를 6자 이상 입력하세요.");
		join.id.focus();
		return false;
	}
	
	if(join.pass.value == ""){
		alert("비밀번호를 입력하세요.");
		join.pass.focus();
		return false;
	}
	
	if(join.pass.value.length < 8){
		alert("비밀번호를 8자 이상 입력하세요.");
		join.pass.focus();
		return false;
	}
	
	if(join.passok.value == ""){
		alert("비밀번호 확인을 입력하세요.");
		join.passok.focus();
		return false;
	}
	
	if(join.passok.value != join.pass.value){
		alert("비밀번호 똑같이 입력하세요.");
		join.passok.focus();
		return false;
	}
	
	if(join.name.value == ""){
		alert("이름을 입력하세요.");
		join.name.focus();
		return false;
	}
	
	if(join.name.value.length < 2){
		alert("이름을 2자 이상 입력하세요.");
		join.name.focus();
		return false;
	}
	
	if(join.email.value == ""){
		alert("이메일을 입력하세요.");
		join.email.focus();
		return false;
	}
	
	if(join.phone.value == ""){
		alert("전화번호를 입력하세요.");
		join.phone.focus();
		return false;
	}
	
	if(join.phone.value.length < 10){
		alert("전화번호를 10자 이상 입력하세요.");
		join.phone.focus();
		return false;
	}
	
	if(join.phone.value.includes("-")){
		alert("전화번호에 -을 빼고 입력해주세요.");
		join.phone.focus();
		return false;
	}
	
	if(join.sample4_postcode.value == ""){
		alert("우편번호를 입력하세요.");
		join.sample4_postcode.focus();
		return false;
	}
	
	var agreement_ok = document.join.agreement.checked;
	if(agreement_ok == false){
		alert("개인정보 수집·이용 동의를 해주세요.");
		join.agreement.focus();
		return false;
	}
	
	
	document.submit();
}

