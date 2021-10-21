package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T05_StudentTest {
	
	public static void main(String[] args) {
		T05_StudentTest stdTest = new T05_StudentTest();
		
		List<Student> stdList = new ArrayList<Student>();
		
		stdList.add(new Student("00000001", "이효리", 70, 60, 70));
		stdList.add(new Student("00000040", "유재석", 60, 90, 100));
		stdList.add(new Student("00000017", "황광희", 70, 60, 60));
		stdList.add(new Student("00000025", "조세호", 40, 60, 30));
		stdList.add(new Student("00000050", "하동훈", 90, 60, 50));
		stdList.add(new Student("00000039", "송지효", 50, 70, 80));
		stdList.add(new Student("00000046", "김종국", 30, 50, 100));

		stdTest.setRanking(stdList); // 등수를 구하는 메서드 호출
		
		System.out.println("정렬전...");
		for(Student std : stdList){
			System.out.println(std);
		}
		System.out.println("==================================================");
		
		// 학번의 오름차순으로 정렬하기
		Collections.sort(stdList);
		System.out.println("학번의 오름차순으로 정렬 후...");
		for(Student std : stdList){
			System.out.println(std);
		}
		System.out.println("==================================================");
		
		// 총점의 내림차순으로 정렬하기
		Collections.sort(stdList, new ss());
		System.out.println("총점의 내림차순으로 정렬 후...");
		for(Student std : stdList){
			System.out.println(std);
		}
		System.out.println("==================================================");
	}
	
	
	/**
	 * 등수를 처리하는 메서드
	 * @param stdList
	 */
	public void setRanking(List<Student> stdList){
		for(Student std : stdList){  // 등수를 구할 자료(기준 자료)
			int rank = 1;
			for(Student std2 : stdList){ // 비교할 자료
				if(std.getTotal() < std2.getTotal() ){
					rank++;
				}
			}
			std.setRank(rank);
		}
	}
}

/**
 * 학생정보를 저장할 VO
 * @author macween
 */
class Student implements Comparable<Student>{
	private String num;	  	// 학번
	private String name;	// 이름
	private int kor;		// 국어점수
	private int eng;		// 영어점수
	private int mat;		// 수학점수
	private int total;		// 총점
	private int rank;		// 순위
	
	public Student(String num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = kor + eng + mat;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = kor + eng + mat;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	/**
	 * 학번을 기준으로 오름차순이 되도록 설정하기
	 */
	@Override
	public int compareTo(Student std) {
		return num.compareTo(std.getNum());
	}
	
	/**
	 * 화면에 학생정보 출력 포맷을 정의함.
	 */
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor
				+ ", eng=" + eng + ", mat=" + mat + ", total=" + total
				+ ", rank=" + rank + "]";
	}
}

/**
 * 총점의 역순으로 정렬하는데 총점이 같으면 학번의 내림차순으로 정렬되도록 한다.
 */
class ss implements Comparator<Student>{
	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getTotal() == std2.getTotal()){
			return std1.getNum().compareTo(std2.getNum()) * -1;
		}else{
			return Integer.compare(std1.getTotal(), std2.getTotal()) * -1;
		}
		
	}
}