package kr.or.ddit.basic;


import java.io.FileInputStream;
import java.io.IOException;

//파일 읽기 예제
public class T05_FileStreamTest {
	public static void main(String[] args) {
		//FileInputStream 객체를 이용한 파일 내용 읽기
		FileInputStream fis = null; //선언
		
		try {
			//방법 1 (파일정보를 문자열로 지정하기)
			fis = new FileInputStream("d:/D_Other/test2.txt");
			
			//방법2 (파일 정보를 File 객체를 이용하여 지정하기)
	//		File file = new File("d:/D_Other/test2.txt");
	//		fis = new FileInputStream(file);
			
			int c; // 읽어온 데이터를 지정할 변수
			
			//읽어온 값이 -1이면 파일을 끝까지 읽었다는 의미이다.
			while((c=fis.read())!=-1) {
				//읽어온 자료 출력하기
				System.out.print((char) c);
			}
			fis.close();//작업 완료 후 스트림 닫기
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
