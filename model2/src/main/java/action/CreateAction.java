package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAction implements Action {

	private String path;
	
	public CreateAction(String path) {
		super();
		this.path = path;
	}


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// 1. 가져오기
		int code = Integer.parseInt(request.getParameter("code"));
		
		// 2. Service 호출
		
		// 3. R일 때만(값을 보내야할때)
		
		// 4. ActionForward
		return new ActionForward(path, true);
	}

}
