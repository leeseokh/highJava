package kr.or.ddit.basic;

class Util {

	/**
	 * 제너릭 메서드<T, R> R method(T t) => 파라미터 타입과 리턴 타입으로 타입 파라미터를 가지는 메서드 선언방법 : 리턴타입
	 * 앞에 <> 기호를 추가하고 타입파라미터를 기술 후 사용한다.
	 * 
	 * @param p1
	 * @param p2
	 * @return
	 */

	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {

		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valuecCompare = p1.getKey().equals(p2.getValue());
		// 값이 동일한지 확인.
		return keyCompare && valuecCompare;
		// 동일하면 리턴
	}
}

class Pair<K, V> {
	private K key;
	private V value;

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	//키와 값을 출력하기
	public<K, V> void displayAll(K key, V val) { //이것은 지역변수 독립적임 위에거랑 다름.
		System.out.println(key.toString() + ":" + val.toString());
	}
}

public class T03_GenericMethodTest {
	public static void main(String[] args) {
		
	

	Pair<Integer, String> p1 = new Pair<Integer, String>(1, "홍길동");
	Pair<Integer, String> p2 = new Pair<Integer, String>(1, "홍길동");

	// 구체적 타입을 명시적으로 지정(생략가능)
	boolean result1 = Util.<Integer, String>compare(p1, p2);	
	
	if(result1)
	{
		System.out.println("논리적(의미)으로 동일한 객체임.");
	}else
	{
		System.out.println("논리적(의미)으로 동일한 객체아님.");
	}

	Pair<String, String> p3 = new Pair<String, String>("001", "홍길동");
	Pair<String, String> p4 = new Pair<String, String>("001", "홍길동");

	boolean result2 = Util.compare(p3, p4);			//제너릭 생략

	if(result2)
	{

		System.out.println("논리적(의미)으로 동일한 객체임.");
	}else
	{
		System.out.println("논리적(의미)으로 동일한 객체아님.");
		}
	//제너릭 메서드 테스트
	p1.<String, Integer>displayAll("키", 180);	// 일반 메서드는 오류가 남.(K, V)!
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}
}