// 제목 클릭시
// actionForm action ="list.do" 수정 후 submit

const actionForm = document.querySelector("#actionForm")
const readForm = document.querySelector("#readForm")
const password = readForm.querySelector("#password")
const title = readForm.querySelector("#title")
const content = readForm.querySelector("#content")

	
document.querySelector("#readForm .btn-success").addEventListener("click", (e)=>{

	if(confirm("목록으로 돌아가시겠습니까?")){
		//actionForm bno 요소 제거
	actionForm.querySelector("[name='bno']").remove();
	
	actionForm.action = "/list.do";
	actionForm.submit();	
	}
})

document.querySelector("#readForm .btn-primary").addEventListener("click",()=>{
	actionForm.action = "/modify.do";
	actionForm.submit();
});


// modify.jsp 에서 수정 클릭 시 (submit) => submit 중지
// readForm password, title, content 값이 있는 지 확인하고
// 없다면 msg 띄우고, 있으면 submit

document.querySelector("#readForm").addEventListener("submit", (e)=>{
	e.preventDefault();
	
	console.log("제목 => ("+title.value+")")
	console.log("내용 => ("+content.value+")")
	console.log("비밀번호 => ("+password.value+")")
	
	if(confirm("수정 하시겠습니까?")){
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
		}
		e.target.submit();
		}
})

// 삭제 클릭 시
// readform action=/delete.do 변경 후 readForm submit

document.querySelector("#readForm .btn-danger").addEventListener("click", (e)=>{
	e.preventDefault();
	
	if(confirm("삭제 하시겠습니까?")){
		if(password.value==""){
			alert("비밀번호를 입력해 주세요")
			password.focus();
			return;
		}
		readForm.action = "/delete.do";
		readForm.submit
		}

})