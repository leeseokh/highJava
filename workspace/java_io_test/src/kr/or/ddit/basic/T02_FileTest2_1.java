package kr.or.ddit.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T02_FileTest2_1 {
	public static void main(String[] args) {
    		File f4 = new File("D:/A_TeachingMaterial");

		displayfilelist(f4);

	}
	private static void displayfilelist(File dir) {
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리의 내용");

		// 디렉토리 안의 모든 파일 목록을 가져온다.
		File[] files = dir.listFiles();//리턴을 배열로 받음

		// 하위 디렉토리 정보를 저장한 ArrayList 생성(File배열의 인덱스 저장)
		List<Integer> subDirList = new ArrayList<Integer>();

		// 날짜를 출력하기 위한 형식 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");

		for (int i = 0; i < files.length; i++) {
			String attr = "";// 파일의 속성(읽기, 쓰기, 히든, 디렉토리 구분)
			String size = "";// 파일크기

			if (files[i].isDirectory()) {//만약 디렉토리면
				attr = "<DIR>"; // attr 셋팅
				subDirList.add(i); //저장
			} else {
				size = files[i].length() + ""; //사이즈
				attr += files[i].canRead() ? "R" : " ";
				attr += files[i].canWrite() ? "W" : " ";
				attr += files[i].isHidden() ? "H" : " ";

			}
			 //%5s : 5자리로 끊어줌(우측정렬), %12s:12자리(우측정렬)	  
			System.out.printf("%s %5s %12s %s\n"
					, sdf.format(new Date(files[i].lastModified()))
					, attr, size, files[i].getName());
		}

		int dirCount = subDirList.size(); // 폴더안의 하위폴더 개수 구하기
		int fileCount = files.length - dirCount;// 폴더안의 파일 개수 구하기

		System.out.println(fileCount + "개의 파일, " + dirCount + "개의 디렉토리");

		System.out.println();

		for (int i = 0; i < subDirList.size(); i++) {
			// 하위 폴더의 내용들도 출력하기 위해 현재 메서드를 재귀호출하여 처리한다.
			displayfilelist(files[subDirList.get(i)]);
		}
	}
}