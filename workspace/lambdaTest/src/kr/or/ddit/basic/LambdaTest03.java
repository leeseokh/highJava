package kr.or.ddit.basic;

public class LambdaTest03 {
	static int stVar = 9;
	private String name = "aaa"; 
	
	public void testMethod(final int temp) {
		int localVar = 50;
		int kor = 100;
		
		/*
		 	람다식 내부에서 사용되는 지역변수는 모두 final 이어야 한다.
		 	보통은 final을 붙이지 않으면 컴파일러가 자동으로 붙여준다.
		 	단, 지역변수의 값을 변경하는 식이 있을 경우에는 자동으로 final을 붙여주지 않는다.
		 */
		
		//temp = 500;
//		localVar = 2000;
//		kor = 400;
		
		//람다식에서 지역변수 사용하기
		LambdaTestInterface1 lt = 
				() -> {
					System.out.println("temp = "+temp); // 200  -> 지역변수 final temp
					System.out.println("localVar = "+localVar); // 50 -> 지역변수 final
					System.out.println("kor = "+kor); // 지역변수는 맞지만 final이 아니라서 컴파일 오류
					System.out.println("stVar = "+stVar); //9 -> 클래스 변수
					System.out.println("name = "+this.name); //오혁 -> 멤버변수
				};
		lt.test(); // 실행

	}
	
	public static void main(String[] args) {
		new LambdaTest03().testMethod(200);
	}
}
