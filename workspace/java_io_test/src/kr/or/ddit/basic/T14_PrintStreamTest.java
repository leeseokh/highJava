package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class T14_PrintStreamTest {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		FileOutputStream fos = new FileOutputStream("d:/D_Other/print.txt");
		/*
		 	PrintStream은 모든 자료형을 출력할 수 있는 기능을 제공하는 OutputStream의 서브 클래스이다.
		 	PrintStream은 IOException을 발생시키지 않는다.
		 	println및 print등 메서드 호출시마다 autoflush기능 제공됨.
		 */
		//콘솔 출력 스트림으로 사용됨.
		PrintStream out = new PrintStream(System.out);
		
		out.print("안녕하세요. printStream입니다.\n");
		out.println("안녕하세요. printStream입니다.2");
		out.println("안녕하세요. printStream입니다.3");
		out.println(out); //객체 출력.
		out.print(3.14);
		
		out.close();
		
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/print.txt");
		
		//printStream은 데이터를 문자로 출력하는 기능을 수행함.
		//향상된 기능의 printWriter가 추가 되었지만 계속 사용됨.
		
		//printWriter가 printStream보다 다양한 언어의 문자를 처리하는데 적합하다.
		
		PrintWriter pw =  new  PrintWriter(new OutputStreamWriter(fos2, "UTF-8"));
		
		pw.print("안녕하세요. printWriter 입니다.\n");
		pw.println("안녕하세요. printWriter 입니다2.\n");
		pw.println("안녕하세요. printWriter 입니다3.\n");
		
		pw.close();
	}

}
