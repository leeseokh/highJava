package kr.or.ddit.basic;
public class Service {
	
	@PrintAnnotation
	public void method1() {	//디폴트값 
		System.out.println("메서드 1에서 출력되었습니다.");
	}
	@PrintAnnotation(value="%") // value만 있을때 value 생략가능   ==> ("%")
	public void method2() {
		System.out.println("메서드 2에서 출력되었습니다.");
	}
	@PrintAnnotation(value="%", count=30)
	public void method3() {
		System.out.println("메서드 3에서 출력되었습니다.");
	}
}
