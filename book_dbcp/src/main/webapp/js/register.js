document.querySelector(".btn-success").addEventListener("click", () => {
	
	// 아이디 가져오기
	const userid = document.querySelector("#userid").value
	
	const form = new FormData();
	form.append("userid",userid);
		
	fetch("/member/checkid_pro.jsp",{method:"post",
//		 headers:{'content-type':'application/x-www-form-urlencoded'}, 실험
		 body:new URLSearchParams(form)
		 })
	.then(response => {
		if (!response.ok) throw new Error("주소를 확인하세요");
			return response.text();
	})
	.then(data => {
		console.log(data);
		
		if(data.trim()=="true"){
			alert("사용할 수 있는 아이디입니다")
		}else{
			alert("중복된 아이디")			
		}
	})
	.catch(error => console.log(error))
	
})