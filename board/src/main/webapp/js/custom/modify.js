const actionForm = document.querySelector("#actionForm")
const readForm = document.querySelector("#readForm")
const password = readForm.querySelector("#password")

document.querySelector("#readForm .btn-success").addEventListener("click", (e)=>{
	e.preventDefault
	
	if(confirm("목록으로 돌아가시겠습니까?")){
	actionForm.querySelector("[name='bno']").remove();
	
	actionForm.action = "/list.do";
	actionForm.submit();	
	}
})

document.querySelector("#readForm").addEventListener("submit", (e)=>{
 
	if(confirm("수정 하시겠습니까?")){
		if(password.value==null){
			alert("비밀번호를 입력해 주세요")
		}
		e.target.submit();
		}
})

// 삭제 클릭 시
// readform action=/delete.do 변경 후 readForm submit

document.querySelector("#readForm .btn-danger").addEventListener("click", (e)=>{
	e.preventDefault;
	
	if(confirm("삭제 하시겠습니까?")){
		if(password.value==""){
			alert("비밀번호를 입력해 주세요")
			return;
		}
		readForm.action = "/delete.do";
		readForm.submit
		}

})