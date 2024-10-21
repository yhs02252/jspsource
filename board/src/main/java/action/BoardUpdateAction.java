package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardUpdateAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setPassword(request.getParameter("password"));
		
		BoardService service = new BoardServiceImpl();
		Boolean updateFlag = service.update(dto);

		if (updateFlag) {
			path += "?bno=" + dto.getBno();
		} else {
			path = "modify.do?bno="+dto.getBno();
		}
		
		return new ActionForward(path, true);
	}

}
