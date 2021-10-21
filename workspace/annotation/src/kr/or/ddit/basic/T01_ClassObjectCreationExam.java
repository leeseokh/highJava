package kr.or.ddit.basic;

/*
 	java Reflection에 대하여...
 	1) Reflection은 클래스, 또는 멤버변수, 메서드, 생성자에 대한 정보를 가져오거나 수정할 수 있고 새로운 객체를 생성하거나, 메서드를 실행할 수 있다.
	2) Reflection API는 java.lang.reflection 패키지와 java.lang.Class를 통해서 제공된다.
	3) java.lang.Class의 주요메서드 : getName(), getSuperClass(), getInterface(), getModifiers()
	4) java.lang.reflect 패키지의 주요 클래스 : Field, Method, Constructor, Modifier등.
 */
/*
 	Class 오브젝트(오브젝트 내부의 세부정보를 담고 있는)를 생성하기
 */

public class T01_ClassObjectCreationExam {
	public static void main(String[] args) throws ClassNotFoundException {
		
	
	// 첫번째 방법 : Class.forName() 메서드 이용
	Class<?> klass = Class.forName("kr.or.ddit.reflection.T01_ClassObjectCreationExam");
	
	// 두번째 방법 : getClass() 메서드 이용
	T01_ClassObjectCreationExam obj = new T01_ClassObjectCreationExam();
	obj.getClass();
	
	//세번째 방법 : .class 이용
	klass = T01_ClassObjectCreationExam.class;
	
	
	
	
	
	
	}
}



























