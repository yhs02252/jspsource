// 제목 클릭시 a 태그 기능 중지
// href 에 있는 번호 가져오기 후 actionform 안 bno value 삽입

const actionForm = document.querySelector("#actionForm")
	
// 제목의 a태그가 여러개 있는 경우
// 개별로 처리
//const allA = document.querySelector(".table a")
//allA.forEach("a", ()=>{
//	a.addEventListener("click",(e)=>{
//		e.preventDefault();
//		
//		//href 값 가져오기
//	})
//})

// 부모에게 전달되는 이벤트 버블링
document.querySelector("tbody").addEventListener("click", (e)=>{
	// a 태그 기능 중지
	e.preventDefault();
	
	console.log(e.target)
	console.log(e.target.href) // http://localhost:8080/~~
	console.log(e.target.getAttribute("href"))
	
	const bno = e.target.getAttribute("href");
	
	actionForm.querySelector("[name='bno']").value = bno;
	
	console.log(actionForm.innerHTML);
	
	// actionForm submit
	// action: /read.do
	actionForm.action="/cntUp.do";
	actionForm.submit();	
})

// 검색 기능
// criteria or keyword 입력이 안된 경우 form submit 중지
// 적절한 메세지 띄우기
const searchForm = document.querySelector("#searchForm");
const formSelect = searchForm.querySelector(".form-select");
const keyword = searchForm.querySelector("#keyword");

searchForm.querySelector(".btn-warning").addEventListener("click", (e)=>{
	e.preventDefault();
	
	if(formSelect.value=="n"){
		alert("항목을 지정해 주세요");
		return;
	}else if(keyword.value==""){
		alert("검색어를 입력해 주세요");
		return;
	}else{
		searchForm.submit();
	}
})


// 하단의 페이지 나누기 기능
// 1 2 3 숫자 누를 때 actionForm submit
// href 값 가져와서 actionForm submit
const pagination = document.querySelector(".pagination")
pagination.addEventListener("click", (e)=>{
	e.preventDefault();
	
	actionForm.querySelector("[name='bno']").remove;
	actionForm.querySelector("[name='page']").value = e.target.getAttribute("href");
	actionForm.action = "/list.do";
	actionForm.submit();
})