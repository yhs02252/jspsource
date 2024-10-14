/**
 * 
 */

// 회원탈퇴 클릭 시 form submit 중지
// confirm[정말로 탈퇴 하시겠습니니까?]

document.querySelector("form").addEventListener("submit", (e) => {
	e.preventDefault();

	if(confirm("정말로 탈퇴 하시겠습니까?")){
		e.target.submit();
	} 
});