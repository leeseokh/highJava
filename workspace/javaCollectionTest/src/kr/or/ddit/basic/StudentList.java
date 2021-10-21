package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentList {

	public static void main(String[] args) {
		// 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
		// 생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
		//
		// 이 Student객체들은 List에 저장하여 관리한다.

		// List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
		// 총점의 역순으로 정렬하는 부분을 프로그램 하시오.
		// (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
		// (학번 정렬기준은 Student클래스 자체에서 제공하도록 하고,
		// 총점 정렬기준은 외부클래스에서 제공하도록 한다.)
		StudentList stdTest = new StudentList();
		List<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("20150981", "이석호", 80, 70, 90));
		studentList.add(new Student("20150381", "김지수", 32, 75, 40));
		studentList.add(new Student("20150181", "홍길동", 80, 70, 90));
		studentList.add(new Student("20150281", "성춘향", 80, 79, 90));
		studentList.add(new Student("20150781", "이몽룡", 24, 70, 90));

		stdTest.setRanking(studentList);

		System.out.println("정렬 전");
		for (Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("-------------------------------------------------");

		// 학번 오름차순 정렬
		Collections.sort(studentList);
		System.out.println("학번 오름차순");
		for (Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("-------------------------------------------------");

		// 총점의 내림차순 정렬
		Collections.sort(studentList, new Decending());
		System.out.println("총점 내림차");
		for (Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("-------------------------------------------------");

	}

	public void setRanking(List<Student> stdList) {
		for (Student std : stdList) {
			int rank = 1;
			for (Student std2 : stdList) {
				if (std.getTotal() < std2.getTotal()) {
					rank++;
				}
			}
			std.setRank(rank);
		}
	}
}

class Student implements Comparable<Student> {
	private String studentId;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int rank;

	public Student(String studentId, String name, int kor, int eng, int math) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = kor + eng + math;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override								
	public int compareTo(Student std) {	
		return studentId.compareTo(std.getStudentId());
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", total=" + total + ", rank=" + rank + "]";
	}

}

class Decending implements Comparator<Student> {

	@Override
	public int compare(Student std1, Student std2) {	
		if (std1.getTotal() == std2.getTotal()) {
			return std1.getStudentId().compareTo(std2.getStudentId()) * -1;
		} else {
			return Integer.compare(std1.getTotal(), std2.getTotal()) * -1;

		}
	}

}
