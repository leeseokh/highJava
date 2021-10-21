package kr.or.ddit.basic;

import java.util.Arrays;

public class T06_wildCardTest {

	/**
	 * 모든 과정 등록
	 */
	public static void listCourseInfo(Course<?> course) {
		System.out.println(course.getName() + "수강생 :" + Arrays.toString(course.getStudent()));
	}

	/**
	 * 학생 과정 등록 파라미터에 올 수 있는 것이 제한되어있다. Student, (Student 상속 받은) HighStudent타입 올 수
	 * 있음.
	 */

	public static void listCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + "수강생 :" + Arrays.toString(course.getStudent()));
	}

	/**
	 * 직장인 과정
	 * 
	 * @param course
	 */
	public static void listCourseWorker(Course<? super Worker> course) {// 하한 제한=> Worker와worker의 부모(Person) Type까지 가능
		System.out.println(course.getName() + "수강생 :" + Arrays.toString(course.getStudent()));
	}

	public static void main(String[] args) {

		Course<Person> personCourse = new Course<>("일반인과정", 5);
		personCourse.add(new Person("일반인1"));
		personCourse.add(new Person("직장인1"));
		personCourse.add(new Person("학생1"));
		personCourse.add(new Person("고등학생1"));

		Course<Worker> workerCourse = new Course<>("직장인과정", 5);
		workerCourse.add(new Worker("직장인1"));

		Course<Student> studentCourse = new Course<>("학생과정", 5);
		studentCourse.add(new Student("학생1"));
		studentCourse.add(new HighStudent("고등학생1"));

		Course<HighStudent> highstudentCourse = new Course<>("고등학생과정", 5);
		new Course("고등학생과정", 5);
		highstudentCourse.add(new HighStudent("고등학생1"));

		// 일반과정 (모두 다)
		listCourseInfo(personCourse);
		listCourseInfo(workerCourse);
		listCourseInfo(studentCourse);
		listCourseInfo(highstudentCourse);
		System.out.println("--------------------------------------------------");

		// 학생 과정 (Student와 그 자손 Highstudent)
		// registorCourseStudent(personCourse); // 오류
		// listCourseStudent(workerCourse); // 오류
		listCourseStudent(studentCourse);
		listCourseStudent(highstudentCourse);
		System.out.println("--------------------------------------------------");

		// 직장인 과정 (Worker와 그 부모 Person)
		listCourseWorker(personCourse);
		listCourseWorker(workerCourse);
		// listCourseWorker(studentCourse); //오류
		// listCourseWorker(highstudentcourse); //오류
		System.out.println("--------------------------------------------------");

	}
}

class Person {
	String name; // 이름

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "이름:" + name;
	}
}

class Worker extends Person {

	public Worker(String name) {
		super(name);
	}
}

class Student extends Person {

	public Student(String name) {
		super(name);
	}
}

class HighStudent extends Student {

	public HighStudent(String name) {
		super(name);

	}
}

class Course<T> {
	private String name; // 과정명
	private T[] student; // 수강생(제너릭 배열)

	public Course(String name, int capacity) {
		this.name = name;
		// 타입 파라미터로 배열을 생성시 오브젝트 배열을 생성 후, 타입 파라미터 배열로 캐스팅 처리 해야함.

		// 제너릭 배열 생성 실패(new 연산자는 생성할 객체의 타입이 정확히 정의되어야 가능)
		// student = new T[capacity];
		student = (T[]) (new Object[capacity]); // capacity : 몇명까지 받는지... T타입의 배열을 초기화할때

	}

	public String getName() {
		return name;
	}

	public T[] getStudent() {
		return student;
	}

	// 수강생 등록
	public void add(T t) {
		for (int i = 0; i < student.length; i++) {
			if (student[i] == null) { // 아직 등록되지 않은 (빈)자리인지 확인
				student[i] = t;
				break;
			}
		}
	}
}