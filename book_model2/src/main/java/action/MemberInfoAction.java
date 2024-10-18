package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ChangeDTO;
import dto.MemberDTO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberInfoAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ChangeDTO dto = new ChangeDTO();
		dto.setCurrentPassword(request.getParameter("current_password"));
		dto.setUserid(request.getParameter("userid"));
		dto.setChangePassword(request.getParameter("change_password"));
		
		// 2. service 호출
		MemberService service = new MemberServiceImpl();
		boolean changeFlag = service.changePassword(dto);
		
		if(changeFlag){
			HttpSession session = request.getSession();
			session.invalidate();
		}else{
			path = "/member/info.jsp";
		}
		
		return new ActionForward(path, true) ;
	}

}
