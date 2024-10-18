package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDTO;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;

@AllArgsConstructor
public class BookCreateAction implements Action {

	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 1.
		BookDTO insertDto = new BookDTO();
		insertDto.setCode(Integer.parseInt(request.getParameter("code")));
		insertDto.setTitle(request.getParameter("title"));
		insertDto.setWriter(request.getParameter("writer"));
		insertDto.setPrice(Integer.parseInt(request.getParameter("price")));
		insertDto.setDescription(request.getParameter("description"));

		// 2. service 호출
		BookService service = new BookServiceImpl();
		boolean insertFlag = service.insert(insertDto);

		// 1 이 리턴되면 상세조회
		// 0 이 리턴되면 수정 페이지
		if (insertFlag) {
			path += "?code=" + insertDto.getCode();
		} else {
			path = "/modigy.do?code=" + insertDto.getCode();
		}


		return new ActionForward(path, true);
	}
}
