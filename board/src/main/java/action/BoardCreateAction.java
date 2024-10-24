package action;


import java.io.File;
import java.net.URLEncoder;
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
public class BoardCreateAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setName(request.getParameter("name"));
		dto.setPassword(request.getParameter("password"));
		
		// 페이지 나누기
		int page = Integer.parseInt(request.getParameter("page"));
		int amount = Integer.parseInt(request.getParameter("amount"));		
		
		// 검색 추가
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		
		// 첨부파일 가져오기
		Part part = request.getPart("attach");
		String filename = getFileName(part);
		
		System.out.println(filename);
		
		// 서버로 전송된 파일 저장(서버 특정 폴더)
		String saveDir = "c:\\upload";
		if (!filename.isEmpty()) {
			// 고유의 키값_파일명
			UUID uuid = UUID.randomUUID();
			
			// File.separator => \ or / (운영체제에 맞게 넣어줌)
			// c:\\upload\\1.jpg
			File f = new File(saveDir + File.separator + uuid + "_" + filename);
			part.write(f.toString()); // c:\\upload\\38ba49d1-93be-49a2-a08a-4ba9ce831066_starFavicon.png<- 경로 이름이 전부 필요함
			dto.setAttach(f.getName()); // 38ba49d1-93be-49a2-a08a-4ba9ce831066_starFavicon.png <- 뒷부분만 필요함
		}
		
		BoardService service = new BoardServiceImpl();
		Boolean insertFlag = service.create(dto);

		if (insertFlag) {
			path += "?page=" + page + "&amount=" + amount + "&criteria=" + criteria + "&keyword=" + keyword;
		} else {
			path = "/board/create.jsp";
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
