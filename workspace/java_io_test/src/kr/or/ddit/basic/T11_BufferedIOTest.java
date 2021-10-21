package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T11_BufferedIOTest {
	public static void main(String[] args) {
		//입출력의 성능 향상을 위해서 버퍼를 이용하는 보조 스트림
		//파일에 데이터를 쓸때 '문자 단위'스트림으로 처리해주는 스트림
		FileOutputStream fos = null; //기반스트림
		BufferedOutputStream bos = null; //(바이트기반)보조스트림
		
		try {
			fos = new FileOutputStream("d:/D_Other/bufferTest.txt");
			
			//버퍼의 크기를 지정하지 않으면 기본적으로 버퍼의 크기가 8192(8kb)로 설정됨.
			
			//버퍼의 크기가 5인 스트림 객체 생성 (버퍼사이즈 5byte)
			bos = new BufferedOutputStream(fos, 5);
			
			for (int i='1'; i <='9'; i++) {//숫자 자체를 문자로 지정하기 위해 ''사용함.
				bos.write(i); //버퍼에 (5byte니까?) 2번 돌았다 
			}
			bos.flush();//작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력시킨다.
			              //(close시 자동으로 호출됨.) 12345, 6789(10) 버퍼가 아직 차지 않음 -> 강제write()
			bos.close();
			System.out.println("작업 끝...");
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
		try {
			bos.close();
		}catch (IOException e) {
			e.printStackTrace();
			}
		}	
	}
}
