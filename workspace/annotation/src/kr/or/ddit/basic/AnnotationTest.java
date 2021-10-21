package kr.or.ddit.basic;

import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args) {
		
		System.out.println(PrintAnnotation.id);
		
		Method[] declareMethods = Service.class.getDeclaredMethods();
		
		for(Method m : declareMethods) {
			System.out.println(m.getName());
			
			PrintAnnotation printAnnotation = m.getDeclaredAnnotation(PrintAnnotation.class);
			
			for(int i=0; i < printAnnotation.count(); i++) {
				System.out.println();
			}
			System.out.println();
		}
		
	}

}
