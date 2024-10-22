package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardDeleteAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDTO dto = new BoardDTO();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setPassword(request.getParameter("password"));
		
		BoardService service = new BoardServiceImpl();
		boolean deleteFalg = service.delete(dto);

		if (deleteFalg) {
			path += "?bno=" + dto.getBno();
		} else {
			path = "modify.do?bno="+dto.getBno();
		}
		
		return new ActionForward(path, true);
	}

}
