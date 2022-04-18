function go() {
	if(board.subject.value == ""){
		alert("제목을 입력하세요");
		board.subject.focus();
		return false;
	}
	
	if(board.comment.value == ""){
		alert("내용을 입력하세요");
		board.comment.focus();
		return false;
	}
	document.submit();
}