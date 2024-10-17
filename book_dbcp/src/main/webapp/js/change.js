document.querySelector("#pass").addEventListener("submit", (e)=>{
	e.preventDefault();
	
	if (confirm("비밀번호를 변경 하시겠습니까?")){
		e.target.submit();
	} else {
		return;
	}
});

document.querySelector(".btn-primary").addEventListener("click", () => {
	if(confirm("목록으로 돌아가시겠습니까?")){		
	location.href = "/book/list_pro.jsp";
	}
});