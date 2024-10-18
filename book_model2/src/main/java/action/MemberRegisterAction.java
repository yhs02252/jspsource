package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberRegisterAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberDTO dto = new MemberDTO();
		dto.setUserid(request.getParameter("userid"));
		dto.setName(request.getParameter("name"));
		dto.setPassword(request.getParameter("password"));
		
		// 2. service 호출
		MemberService service = new MemberServiceImpl();
		boolean dtoReg = service.join(dto);		
		
		if(!dtoReg){
			path = "/member/register.jsp";
		}
		
		return new ActionForward(path, true) ;
	}

}
