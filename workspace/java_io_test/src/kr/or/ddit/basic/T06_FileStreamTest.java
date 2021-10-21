package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//파일 출력 예제
public class T06_FileStreamTest {
	public static void main(String[] args) {
		//1>>파일에 출력하기
				FileOutputStream fos = null;
				
				//2>> write()
				try {
					//출력용 OutputStream 객체 생성
					fos = new FileOutputStream("d:/D_Other/out2.txt");
					for(char ch='a'; ch<='z'; ch++) { //byte기반으로 char write 가능 -> 형변환 필요없어서
						fos.write(ch);
					}
					System.out.println("파일에 쓰기 작업 완료...");
					
					//쓰기 작업 후 스트림 닫기
					 fos.close();
					 
					 //==============================
					 //저장된 파일의 내용을 읽어와 화면에 출력하기
					 FileInputStream fis = new FileInputStream("d:/D_Other/out2.txt");
					 
					 int c;
					 while((c=fis.read())!=-1) {
						 System.out.println((char) c);
					 }
					 System.out.println();
					 System.out.println("출력 끝...");
					 
					 fis.close();
				
				}catch(IOException ex) {
					
				}

	}
}
