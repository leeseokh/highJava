package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class T01_arrayListTest {

	public static void main(String[] args) {
		//Default Capacity = 10
		List list1 = new ArrayList();
		
		//add()메서드를 사용해서 데이터를 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111); //new Integer(111); 	autoboxing ?? 내부적으로 이렇게 넣어도 다 객체화 되서 들어간다.
		list1.add('k'); //new Character('k');
		list1.add(true);
		list1.add(12.34);
	
		
		//size() -> 데이터 개수
		System.out.println("size =>" + list1.size());
		System.out.println("list=>" +list1);
		
		//get으로 데이터 꺼내오기
		System.out.println("1번째 데이터 자료:"
				+ list1.get(1));
		
		//데이터 끼워 넣기도 같다.
		list1.add(0, "zzz");
		System.out.println("list1=>" + list1);
		
		//데이터 변경하기(set 메서드)
		String temp = (String) list1.set(0, "YYY");
		System.out.println("temp = >" + temp);
		System.out.println("list1 => "+list1);
		
		//삭제하기도 같다.
		list1.remove(0);
		System.out.println("삭제후:" + list1);
		
		list1.remove("bbb");
		System.out.println("bbb 삭제후: " + list1);
		list1.remove(new Integer (111)); // 객체화 해서 삭제해야함
		// list1.remove(111) 에러 인덱스의 111번째를 지운다는 뜻.
		System.out.println("---------------------------------------");
		
		//제너릭을 지정하여 삽입할수 있다.
		List<String> list2 = new ArrayList<>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		
		for(int i =0; i<list2.size(); i++) {
			System.out.println(i + ":" + list2.get(i));
		}
		System.out.println();
		
		for(String s : list2) {
			System.out.println(s);
		}
		System.out.println("---------------------------------------");
		
		//contains(비교객체); => 리스트에 '비교객체'가 있으면 true, 없으면 false가 리턴됨.
		System.out.println(list2.contains("DDD"));
		System.out.println(list2.contains("ZZZ"));
		
		//indexOf(비교객체)
		// - > 리스트에서 '비교객체'를 찾아 '비교객체'가 있는 index값을 반환한다. 없으면 -1 반환함.
		System.out.println("DDD의 index값: " + list2.indexOf("DDD"));
		System.out.println("ZZZ의 index값: " + list2.indexOf("ZZZ"));
		System.out.println("---------------------------------------");
				
		//toArray() => 리스트 안의 데이터들을 배열로 변환하여 반환한다. 기본적으로Object배열 반환함.
		Object[]strArr = list2.toArray();
		System.out.println("배열의 개수:" + strArr.length);
		
		// 리스트의 제너릭 타입에 맞는 자료형의 배열로 변환하는 방법
		// 제너릭타입의 0개짜리 배열을 생성해서 매개변수로 넣어준다.
		// => 배열의 크기가 리스트 크기보다 작으면 리스트의 크기에 맞는 배열을 생성한다.
		String[] strArr2 = list2.toArray(new String[3]);	//[String[1] 숫잔 상관없음.
		System.out.println("strArr2의 개수:" + strArr2.length);
		
		
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		for(int i=0; i<list2.size(); i++) {
			list2.remove(i); // 거꾸로부터 지워야한다. 다 지우려면.
		}
		System.out.println(list2.size());
		
		for(int i = list2.size()-1; i >= 0; i--) {
			list2.remove(i);	
		}
		System.out.println(list2.size());
	}
	

}
