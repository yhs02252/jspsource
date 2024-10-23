package action;


import java.io.File;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dto.BoardDTO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardReplyAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDTO replyDto = new BoardDTO();
		replyDto.setTitle(request.getParameter("title"));
		replyDto.setContent(request.getParameter("content"));
		replyDto.setName(request.getParameter("name"));
		replyDto.setPassword(request.getParameter("password"));
		
		// hidden 부모 정보
		replyDto.setReRef(Integer.parseInt(request.getParameter("re_ref")));
		replyDto.setReLev(Integer.parseInt(request.getParameter("re_lev")));
		replyDto.setReSeq(Integer.parseInt(request.getParameter("re_seq")));
		replyDto.setBno(Integer.parseInt(request.getParameter("bno")));
		
		BoardService service = new BoardServiceImpl();
		boolean replyFlag = service.reply(replyDto);

		if (replyFlag) {
//			path += "?bno=" + replyDto.getBno();
//		} else {
			path = "reply.do?bno="+replyDto.getBno();
		}
		
		return new ActionForward(path, true);
	}
	
	private String getFileName(Part part) {
		// content-disposition : attachment; filename=file.jpg등등
		String header = part.getHeader("content-disposition"); // content-disposition 헤더에서
		String[] arr = header.split(";"); // 세미콜론기준으로 나뉘어보면
		for (int i = 0; i < arr.length; i++) {
			String temp = arr[i];
			if (temp.trim().startsWith("filename")) { // filename 만 뽑아본것
				return temp.substring(temp.indexOf("=")+2, temp.length()-1);
			}
		}
		return "";
	}

}
