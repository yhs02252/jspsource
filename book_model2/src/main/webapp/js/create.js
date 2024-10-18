document.querySelector(".btn-primary").addEventListener("click", () => {
	if(confirm("목록으로 돌아가시겠습니까?")){		
	location.href = "/list.do?keyword=";
	}
})
// 추가 클릭시 form submit 이 일어나면 
// description 요소를 제외한 모든 요소에 값이 있는지 확인
// code = 4자리, 숫자
// price = 3 ~ 10자리, 숫자

document.querySelector("body div:nth-child(3) form").addEventListener("submit", (e) => {
	e.preventDefault();

	const form = e.target;

	const code = form.querySelector("#code");
	const title = form.querySelector("#title");
	const writer = form.querySelector("#writer");
	const price = form.querySelector("#price");

	const regCode = /^\d{4}$/;
	const regText = /[\w가-힣].+/
	const regPrice = /^\d{3,10}$/;

if(confirm("도서를 추가 하시겠습니까?")){
	if (!regCode.test(code.value)) {
		alert("코드는 4자리 숫자로 입력해야 합니다");
		code.select();
		return;
	} else if (!regText.test(title.value)) {
		alert("제목을 입력해주세요");
		title.select();
		return;
	} else if (!regText.test(writer.value)) {
		alert("저자를 입력해주세요");
		writer.select();
		return;
	} else if (!regPrice.test(price.value)) {
		alert("가격은 10자리까지 입력가능합니다");
		price.select();
		return;
	}
	
	form.submit();
}

})


