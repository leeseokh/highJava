package kr.or.ddit.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

	/*
		 	Annotation에 대하여...
		 	
		 	프로그램 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함 시킨것
		 	(JDK1.5부터 지원함.)
		 */
		/*
		 	annotation의 종류!
			1) 표준(내장) 어노테이션
			: 주로 컴파일러에게 유용한 정보를 제공하기 위한 어노테이션
			: 메타 어노테이션을 제외한 일반적인 어노테이션
			
			: @Override, @SuppressWarnings, @Deprecated
			  @Repeatable(1.7) @FunctionalInterface(1.7)등
			
			2) 메타어노테이션
			: 어노테이션을 위한 어노테이션, 즉 어노테이션을 정의할 때 사용함.
			: @Documented, @Target, @Retention, @Inherited 등
	
			어노테이션 정의
			@interface 어노테이션이름{
        	int id = 100; // 상수 선언 가능
        	타입요소이름(); // 반환값이 있고 매개변수는 없는 추상메서드 형태
        	...
        }
        	어노테이션 요소의 규칙!
	        1) 요소의 타입은 기본형, String, enum, annotation, class만 허용된다.
			2) ()안에 매개변수를 선언할 수 없다.
			3) 예외를 선언할 수 없다.
			4) 요소의 타입에 타입 매개변수(제너릭타입문자)를 사용할 수 없다.
					=>메타 어노테이션 (ex) PrintAnntation
	 */

@Target(ElementType.METHOD) //annotation이 적용 가능한 대상을 지정함.
@Retention(RetentionPolicy.RUNTIME) //유지기간 지정함. (기본값 :CLASS) 제일 길다 유지기간이
public @interface PrintAnnotation {
	int id =100; //상수 선언 가능. static final int id = 100;
	String value() default "-";
	int count() default 20;
	
}





























