// 제목 클릭시
// actionForm action ="list.do" 수정 후 submit

const actionForm = document.querySelector("#actionForm")
const readForm = document.querySelector("#readForm")
const password = readForm.querySelector("#password")
const title = readForm.querySelector("#title")
const content = readForm.querySelector("#content")

// read.jsp 수정, 목록 버튼
document.querySelector("#readForm .btn-success").addEventListener("click", ()=>{

	if(confirm("목록으로 돌아가시겠습니까?")){
		//actionForm bno 요소 제거
	actionForm.querySelector("[name='bno']").remove();
	
	actionForm.action = "/list.do";
	actionForm.submit();	
	}
})

const infoBtn = document.querySelector("#readForm .btn-info");
if(infoBtn){
	infoBtn.addEventListener("click",()=>{
		
		actionForm.action = "/modify.do";
		actionForm.submit();
	});
}


// 답변 클릭시 actionform action="/replyview.do" 수정 후 submit
const replyBtn = readForm.querySelector(".btn-secondary");
if(replyBtn){
	replyBtn.addEventListener("click", ()=>{
		actionForm.action = "/replyView.do";
		actionForm.submit();
	})
	
}


// 삭제 클릭 시
// readform action=/delete.do 변경 후 readForm submit
const deleteBtn = document.querySelector("#readForm .btn-danger")
if(deleteBtn){
	deleteBtn.addEventListener("click", ()=>{
		
// 		readForm.action = "/delete.do"; 
//			↑   먼저 실행되도록 하면 action이 바뀐 상태가 되어,  ↑
//	따로 action을 지정 하지 않은 submit은 수정된 action을 그대로 실행해 버린다.
		
		if(confirm("삭제 하시겠습니까?")){
			if(password.value==""){
				alert("비밀번호를 입력해 주세요")
				password.focus();
				return;
			}
			readForm.action = "/delete.do";
			readForm.submit();
		}
		
	})
	
}
	

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

