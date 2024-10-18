package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class MemberDupAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userid = request.getParameter("userid");
		
		// 2. service 호출
		MemberService service = new MemberServiceImpl();
		boolean dtoFlag = service.duplicatedId(userid);	
		
		if(dtoFlag){
			request.setAttribute("dup", "true");
		}else{
			request.setAttribute("dup", "false");
		}
		
		return new ActionForward(path, false) ;
	}

}
