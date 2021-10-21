package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T13_DataIOStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			//"d:/D_Other/test.dat" 파일을 출력하는 객체를 생성
//			fos = new FileOutputStream("d:/D_Other/test.dat");
			//"StreamFile.out" 파일에 각 기본형 데이터를 출력한다
			fos = new FileOutputStream("StreamFile.out");
			
			//DataOutputStream Filter를 적용
			//DataOutputStream은 출력용 데이터를 자료형에 맞게 출력해 준다.
			dos = new DataOutputStream(fos);
			
			dos.writeUTF("홍길동"); // 문자열 데이터 출력(UTF-8)
			dos.writeInt(17);     // 정수형으로 데이터 출력
			dos.writeFloat(3.14f);// 실수형(Float)으로 출력
			dos.writeDouble(3.14);// 실수형(Double)으로 출력
			dos.writeBoolean(true);//논리형으로 출력
			System.out.println("출력 완료...");
			
			dos.close();//종료
			//================================================================
			//출력한 자료 읽어오기
			
//			FileInputStream fis = new FileInputStream("d:/D_Other/test.dat");
			fis = new FileInputStream("StreamFile.out");
			dis = new DataInputStream(fis);
			
			//(OutputStream)저장된 순서대로 읽어야한다
			System.out.println("문자열 자료 : "+ dis.readUTF());
			System.out.println("정수형 자료 : "+ dis.readInt());
			System.out.println("실수형(Float) 자료 : "+ dis.readFloat());
			System.out.println("실수형(Double) 자료 : "+ dis.readDouble());
			System.out.println("논리형 자료 : "+ dis.readBoolean());
			
			dis.close();//종료
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
