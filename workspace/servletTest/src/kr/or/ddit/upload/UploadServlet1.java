package kr.or.ddit.upload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
/**
 * oreilly의 MultipartRequest를 이용한 파일 업로드 예제
 * (생성자 호출과 동시에 파일이 생성되기 때문에 선택적인 파일 생성 처리 불가)
 * @author PC-18
 *
 */
@WebServlet("/upload1")
public class UploadServlet1 extends HttpServlet{
	
	// 파일 업로드는 많은정보를 담아야하는데 그걸 URL에 모두 적을 수 없기 때문에 GET방식은 쓸 수 없다.
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// MultipartRequest(request, 저장경로,[최대허용크기, 인코딩캐릭터셋, 동일한 파일명보호여부])
		
		String encoding = "UTF-8";
		int maxFileSize = 5 * 1024 * 1024 ;
		
		//name.zip, name2.zip, name3.zip  // 내부적으로 같은파일이 들어오면 이런식으로 저장되게 하는게 [DefaultFileRenamePolicy] 이다.
		MultipartRequest mr = new MultipartRequest(req, "d:/D_Other/", maxFileSize, encoding, new DefaultFileRenamePolicy());
		
		resp.setContentType("text/html");
		
		resp.getWriter().print("업로드 완료 : " + mr.getFile("fname"));		
	}
}
