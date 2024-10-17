package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberService;
import service.MemberServiceImpl;

public class RegisterAction implements Action {

	private String path;
	
	public RegisterAction(String path) {
		super();
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// 1. 가져오기
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		// 2. Service 호출
		MemberService service = new MemberServiceImpl();
		MemberDTO 
		
		// 3. R일 때만(결과값을 공유)
		
		// 4. ActionForward
		return new ActionForward(path, true);
	}

}
