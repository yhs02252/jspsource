
document.querySelector(".btn-primary").addEventListener("click", () => {
	if(confirm("목록으로 돌아가시겠습니까?")){		
	location.href = "list_pro.jsp";
	}
})

document.querySelector(".btn-danger").addEventListener("click", () => {
	
	if(confirm("삭제하시겠습니까?")){
	location.href = "delete_pro.jsp?code="+code;
	}
})

// 수정 클릭 시 price 의 값이 숫자가 들어있는지 확인

document.querySelector("body div:nth-child(3) form").addEventListener("submit", (e) => {
	e.preventDefault();
	
	const price = document.querySelector("#price");	
	
	
	// 1(1) ~ 100000000(10)
	// * : 0 ~ 무한대
	const regEx = /^[0-9]{3,10}$/;
	
if(confirm("수정 하시겠습니까?")){
	if(!regEx.test(price.value)){		
		alert("가격을 입력해주세요");
//		price.focus();
		price.select(); // focus + 입력값 존재 시 블럭으로 반환
		return;
	}
	
	e.target.submit();
}
	
})