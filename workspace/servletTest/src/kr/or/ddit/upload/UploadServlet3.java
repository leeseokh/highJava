package kr.or.ddit.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Spliterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.omg.CORBA.PRIVATE_MEMBER;


@WebServlet("/upload3")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 3, maxFileSize = 1024*1024*40, maxRequestSize = 1024*1024*50 )
public class UploadServlet3 extends HttpServlet{
	private static final String UPLOAD_DIRECTORY = "upload_files";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uploadPath = getServletContext().getRealPath("")
							+ File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		try {
			String fileName ="";
			for(Part part : req.getParts()) {
				System.out.println(part.getHeader("content-disposition"));
				
				fileName = getFileName(part);
				if(fileName != null && !fileName.equals("")) {
					part.write(uploadPath + File.separator + fileName); 	//파일 저장
				}
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * part객체 파싱하여 파일이름 추출하기
	 * @param part
	 * @return 파일명 : 파일명이 존재하지 않으면 null값 리턴(폼필드)
	 */
	private String getFileName(Part part) {
	/**
	  	Content-Disposition 헤더에 관하여....
	  	
	  	1. response header에 사용되는 경우 ... ex) 파일 다운로드
	  	
	  	Content-Disposition : inline(default)
	  	Content-Disposition : attachment 	//파일 다운로드
	  	Content-Disposition : attachment; filename = "name.jpg"	// 해당 이름으로 다운로드
	  	
	  	2. multipart body를 위한 헤더정보로 사용되는 경우.... ex) 파일 업로드
	  	Content-Disposition : form-data
	  	Content-Disposition : form-data; name="fieldName"
	  	Content-Disposition : form-data; name="fieldName"; filename="name.jpg"
	  	
	 */
		for(String content : part.getHeader("Content-Disposition").split(";")){
			if(content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=")+1).trim().replace("\"", "");
			}
		}
		
		
		return null;
	}
}
