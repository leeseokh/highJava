package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class T02_PropertiesTest {
	//외부의 properties 파일을 읽어와 properties 객체로 처리하기
	//자료 뽑는 이유 : 텍스트파일로 고치면 자바소스 안건드려도 되고 유지보수에 좋다.
	
	public static void main(String[] args) {
		//읽어온 정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();
		
		//읽어올 파일명을 이용한 File 객체 생성
	 File file = new File("res/db.properties");
	
	try {
		//파일 읽기를 수행할 파인풋 생성
		FileInputStream fis = new FileInputStream(file);
		
		//Properties 객체로 파일 내용 읽기
		prop.load(fis); //파일 내용을 읽어와 키와 밸류 값으로 분류한 후 프라퍼티스 객체에 담아준다.  로드가 내부적으로 읽어줘
		
		//읽어온 자료 출력하기
		
		//key값만 읽어와 Enumeration객체로 변환하기
		Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();
		
		//key값 개수만큼 반복해서 값 출력하기
		
		//key.hasMoreElements() => 다음 포인터 위치에 자료가 있으면 true,  그렇지 않으면 false
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = prop.getProperty(key);
			System.out.println(key + "=>" + value);
		}
		System.out.println("출력 끝...");
	}catch(IOException ex) {
		
	}
  }
}
