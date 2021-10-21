package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;




/*
 	와일드 카드 선언 방법
 															제너릭 와일드카드... 
 	<? extends T> : 와일드카드의 상한 제한. T와 그 자손들만 가능
 	<? super T>   : 와일드카드의 하한 제한. T와 그 조상들만 가능
 	<?>			  : 모든 타입이 가능 <? extends Object> 와 동일
 
 */
public class T05_WildCardTest {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<>(); // 과일상자
		FruitBox<Apple> appleBox = new FruitBox<>(); // 사과상자
//		FruitBox<? extends Fruit> fruitBox2 = new FruitBox<Fruit>
		//Fruit 타입만 들어가짐
		fruitBox.add(new Apple()); // 사과 만듦 
		fruitBox.add(new Grape()); // 포도 만듦
		
		//Apple 타입만 들어가짐
		appleBox.add(new Apple());
		appleBox.add(new Apple());
				
//		Juicer.makeJuice(fruitBox);//과일 상자인 경우에는 아무런 문제 없음
		Juicer.makeJuice(appleBox);// 오류가 남 
//		Juicer.<Apple>makeJuice(appleBox);// 오류가 남 
		//makeJuice는 FruitBox<Fruit>만 올수 있음 (사과도 안되고 ..) 
		
	}
}

class Juicer{
//	static void makeJuice(FruitBox<Fruit> box) {//<Fruit>타입의 박스
//	static <T> void makeJuice(FruitBox<T> box) {// 모든 타입이 올수있고
//	static <T extends Fruit> void makeJuice(FruitBox<T> box) {//Fruit도 올수있고 Fruit을 extends한 
															  //Apple,Grape타입 올 수 있음
	static void makeJuice(FruitBox<? extends Fruit > box) {//FruitBox<? => 어떤타입인지 모른다는 의미지만
														   //Fruit을 상속받았다는 것은 알 수 있다	
		String fruitStr=""; //과일목록
		
		int cnt = 0;
		
		for(Fruit f : box.getFruitList()) {
			if(cnt ==0) {
				fruitStr += f;
			}else {
				fruitStr += "," + f;
			}
			cnt++;
		}
		System.out.println(fruitStr +"=> 쥬스완성!!!");
	}
}

/**
 * 과일 
 */
class Fruit{
	private String name; //과일 이름

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일 [name=" + name + "]";
	}
	
}
//사과
class Apple extends Fruit{
	public Apple() {
		super("사과");
	}
	
}
//포도
class Grape extends Fruit{
	public Grape() {
		super("포도");
	}
	
}
/**
 * 과일상자
 * @param <T>
 */
class FruitBox<T>{ // 제너릭 클래스
	private List<T> fruitList;
	
	public FruitBox() {
		fruitList = new ArrayList<>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}

	public void setFruitList(List<T> fruitList) {
		this.fruitList = fruitList;
	}
	
	public void add(T fruit) {
		fruitList.add(fruit);
	}
	
}