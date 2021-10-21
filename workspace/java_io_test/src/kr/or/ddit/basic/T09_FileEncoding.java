package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class T09_FileEncoding {

/*
 	인코딩 방식
 	
 	한글 인코딩 방식은 크게 UTF-8과 EUC-KR 방식 두가지로 나뉜다.
 	원래 한 글 윈도우는 CP949방식을 사용했는데, 윈도우를 개발한 마이크로 소프트에서 EUC-KR 방식에서 확장하였기 때문에 MS949라고도 부른다.
 	한글 Windows의 메모장에서 이야기하는 ANSI 인코딩이란, CP949(Code Page 949)를 말한다.
 	
 	-MS949 => 윈도우의 기본 한글 인코딩 방식( ANSI 계열)
 	-UTF-8 => 유니코드 UTF-8 인코딩방식
 			(영문자 및 숫자: 1BYTE, 한글: 3BYTES) => 가변적
 	-US-ASCII => 영문 전용 인코딩 방식
 	
 	유니코드: 서로 다른 문자 인코딩을 사용하는 컴퓨터간의 문서 교환에 어려움을 겪고 이런 문제점을 해결하기 위해 전 세계의 모든 문자를 하나의 통일된 문자집합으로 함.
 */

	public static void main(String[] args) {
		//파일 인코딩을 이용하여 읽어오기
		FileInputStream fis = null;
		InputStreamReader isr=null;
		
		try {
		/*
		 FileInputStream 객체를 생성한 후 이 객체를 매개변수로 받는
		 InputStreamReader객체를 생성한다.
		 */
			fis = new FileInputStream("d:/D_Other/test_ansi.txt");
			
			isr = new InputStreamReader(fis, "CP949"); //보조 스트림
			
			int c;
			while((c=isr.read()) !=-1) {
				System.out.println((char)c);
			}
			System.out.println();
			System.out.println("출력 끝...");
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				isr.close();//보조스트림만 닫아도 된다.
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
