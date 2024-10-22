<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 클라이언트가 요청한 파일명 가져오기(다운로드 할 파일명)
	String fileName = request.getParameter("fileName");

	// 서버의 업로드 폴더에 가서 클라이언트가 요청한 파일 읽은 후 보내기
	// c:\\upload\\38ba49d1-93be-49a2-a08a-4ba9ce831066_starFavicon.png
	String saveDir = "c:\\upload";
	String downPath = saveDir + File.separator + fileName;
	
	// 파일읽기
	FileInputStream fis = new FileInputStream(downPath);
	
	// 읽은 파일(이미지,텍스트,동영상...) 브라우저 헤더에 붙여서 보내기
	response.setContentType("application/octet-stream");
	fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1"); // 공백 또한 인코딩이 일어남
	
	// c:\\upload\\38ba49d1-93be-49a2-a08a-4ba9ce831066_starFavicon.png 찾기
	int start = fileName.lastIndexOf("_");
	String oriName = fileName.substring(start + 1); // 잘라내기
													// starFavicon.png
	
	// 38ba49d1-93be-49a2-a08a-4ba9ce831066_starFavicon.png or starFavicon.png
	response.setHeader("content-disposition", "attachment; filename=" + oriName);
	
	out.clear();
	out=pageContext.pushBody();
	
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	
	int numRead = 0;
	byte b[]=new byte[4096];
	while((numRead = fis.read(b))!= -1){
		bos.write(b);
	}
	
	bos.flush();
	bos.close();
	fis.close();
%>