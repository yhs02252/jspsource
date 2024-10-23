const actionForm = document.querySelector("#actionForm");
const replyForm = document.querySelector("#replyForm");
const password = replyForm.querySelector("#password");
const title = replyForm.querySelector("#title");
const content = replyForm.querySelector("#content");
const name = replyForm.querySelector("#name");

replyForm.querySelector(".btn-success").addEventListener("click", ()=>{

	if(confirm("목록으로 돌아가시겠습니까?")){
	actionForm.submit();
	}
})

replyForm.addEventListener("submit",(e)=> {
	e.preventDefault();
	
	if(confirm("답변을 작성 하시겠습니까?")){
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