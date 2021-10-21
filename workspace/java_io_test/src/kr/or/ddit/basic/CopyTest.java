package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class CopyTest {
    
	public static void main(String[] args) {
		// 원본 파일경로
		String origin = "d:/D_Other/Tulips.jpg";
		// 복사될 파일경로
		String copy = "d:/D_Other/Tulipscopy.jpg";

		// 파일객체생성
		File oriFile = new File(origin);
		// 복사파일객체생성
		File copyFile = new File(copy);

		FileInputStream fis = null;
		FileOutputStream fos = null;

//		BufferInputStream bis = null;
//		BufferOutputStream bos = null;
	
		try {
			fis = new FileInputStream(oriFile);   // 읽을파일
			fos = new FileOutputStream(copyFile); // 복사할파일 위치
			
//			bis = new FileInputStream(oriFile);   // 읽을파일
//			bos = new FileOutputStream(copyFile); // 복사할파일 위치

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);		
			}

			fis.close();
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}