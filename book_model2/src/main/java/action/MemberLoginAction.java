package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberLoginAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberDTO dto = new MemberDTO();
		dto.setUserid(request.getParameter("userid"));
		dto.setPassword(request.getParameter("password"));
		
		// 2. service 호출
		MemberService service = new MemberServiceImpl();
		MemberDTO loginDto =  service.login(dto);		
		
		if(loginDto!=null){
			HttpSession session = request.getSession();
			session.setAttribute("loginDto", loginDto);
			path += "?keyword=";
		}else{
			path = "/member/login.jsp";
		}
		
		return new ActionForward(path, true) ;
	}

}
