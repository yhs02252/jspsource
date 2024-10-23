const createForm = document.querySelector("#createForm");
const password = createForm.querySelector("#password");
const title = createForm.querySelector("#title");
const content = createForm.querySelector("#content");
const name = createForm.querySelector("#name");

document.querySelector("#createForm .btn-success").addEventListener("click", ()=>{

	if(confirm("목록으로 돌아가시겠습니까?")){
		//actionForm bno 요소 제거
	actionForm.querySelector("[name='bno']").remove();
	
	actionForm.action = "/list.do";
	actionForm.submit();	
	}
})

createForm.addEventListener("submit", (e)=>{
	e.preventDefault();
	
	if(confirm("글을 작성 하시겠습니까?")){
		if(password.value==""){
			alert("비밀번호를 입력해 주세요")
			password.focus();
			return;
		} else if(title.value==""){
			alert("제목을 입력해 주세요")
			title.focus();
			return;
		} else if(content.value==""){
			alert("내용을 입력해 주세요")	
			content.focus();
			return;
		} else if(name.value==""){
			alert("작성자를 입력해 주세요")	
			name.focus();
			return;
		}
		e.target.submit();
	}
	
})
