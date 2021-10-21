package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

public class T01_FileTest {
	public static void main(String[] args) throws IOException {
		//File객체 만들기 연습
		
		//1. new File(String 파일 또는 경로명)
		// = > 디렉토리와 디렉토리사이 또는 디렉토리와 파일명 사이의 구분 문자는'\'를 사용하거나 '/'를 사용 할 수 있다.
		File file = new File("d:\\D_Other\\test.txt");
		System.out.println("파일명:" + file.getName());
		System.out.println("파일 여부:" + file.isFile());
		System.out.println("디렉토리(폴더) 여부:" + file.isDirectory());
		System.out.println("---------------------------------------");
		
		File file2 = new File("d:\\D_Other");
		System.out.print(file2.getName() + "은");
		if(file2.isFile()) {
			  System.out.print("파일");
			} else if(file2.isDirectory()){
			  System.out.println("디렉토리(폴더)");
			}
			System.out.println("----------------------------");
			
			//2. new File(File parent, String child)		//오버로드의 생성자
			//=> 'parent' 디렉토리 안에 있는 'child' 파일 또는 디렉토리를 갖는다.
			
		File file3 = new File(file2, "test.txt"); // file2 = d:/D_Other
		System.out.println(file3.getName() + "의 용량 크기 : " + file3.length() + "bytes");
		
		//3. new File(String parent, String child)			
		File file4 = new File("d:/D_Other", "test.txt");
		System.out.println("절대 경로: " + file4.getAbsolutePath());
		System.out.println("경로 : " + file4.getPath());
		System.out.println("표준 경로 : " + file4.getCanonicalPath());
		
		/*
		 	디렉토리(폴더) 만들기
		 	mkdir() => file 객체의 경로중 마지막 위치의 디렉토리를 만든다. 중간의 경로가 모두 미리 만들어져 있어야한다.
		 	
		 	2.mkdirs() => 중간의 경로가 없으면 중간의 경로도 새롭게 만든 후 마지막 위치의 디렉토리를 만들어 준다.
		 	=>mkdir(), mkdirs() 모두, 만들기를 성공하면 true, 실패하면 false를 반환	
		 */
		File file5 = new File("d:/D_Other/연습용");
		// d:/D_Other 폴더가 미리 있어야 생성 가능
		// 없다면 중간 경로도 생성해주는 mkdirs()를 이용해서 만들어야 함
		if(file5.mkdir()) { // 생성결과에 따라 t/f반환
		  System.out.println(file5.getName() + " 만들기 성공!" );
		}else {
		  System.out.println(file5.getName() + " 만들기 실패!!!");
		}
		
		System.out.println();
		
		File file6 = new File("d:/D_Other/test/java/src");
		if(file6.mkdirs()) {
		  System.out.println(file6.getName() + " 만들기 성공!" );
		}else {
		  System.out.println(file6.getName() + " 만들기 실패!!!");
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
