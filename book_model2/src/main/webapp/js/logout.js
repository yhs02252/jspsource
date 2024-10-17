document.querySelector("#logout").addEventListener("click", (e)=> {
	e.preventDefault
	
	if(confirm("로그아웃 하시겠습니까?")){
		location.href="/member/logout.do";
	} else {	
		return;
	};

});
