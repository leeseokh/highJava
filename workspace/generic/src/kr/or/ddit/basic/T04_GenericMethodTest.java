package kr.or.ddit.basic;

class Util2 {
	public static<T extends Number> int compare(T t1, T t2) { //Number를 상속한 타입과 Number만 가능
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);	//Number 타입 하위타입 두객체를 받아서 비교해주는 명령.(오름차순 정렬)
	}
}

/*
 * 제한된 타입 파라미터(Bounded Parameter) 예제
 */
public class T04_GenericMethodTest {
	public static void main(String[] args) {
		int result1 =Util2.compare(10, 20); //Util2.<Integer>compare 생략가능.
		System.out.println(result1);
		
		int result2 = Util2.<Number>compare(3.14, 3);
		System.out.println(result2);
		
//		Util2.compare("자바", "홍길동"); Integer계열만...
	}
}
