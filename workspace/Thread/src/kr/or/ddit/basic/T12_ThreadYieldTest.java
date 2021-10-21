package kr.or.ddit.basic;

public class T12_ThreadYieldTest {
/*
 	yield() 메서드에 대하여...
 	
 	1. 현재 실행 대기중인 동등한 우선순위 이상의 다른 스레드에게 실행 기회를 제공한다.(양보)
 	2. 현재 실행중인 스레드의 상태를 Runnable 상태로 바꾼다.(Waiting이나 Blocked 상태로 바뀌지 않는다.)
 	3. yield()메서드를 실행한다고 해서 현재 실행중인 스레드가 곧바로 runnable 상태로 전이된다고 확신할 수 없다.
 	
 */
	public static void main(String[] args) {
		  Thread th1 = new YieldThreadEx1();
		  Thread th2 = new YieldThreadEx2();
		
		  th2.start();
		  th1.start();
		 
		
	}
}
class YieldThreadEx1 extends Thread{
	  @Override
	  public void run() {
	    for(int i = 1; i<5; i++) {
	      System.out.println("YieldTestEx1 : " + i);
	      yield(); // 양보하기 
	    }
	  }
	}
	
	//양보 기능이 없는 쓰레드 클래스
	class YieldThreadEx2 extends Thread{
	  @Override
	  public void run() {
	    for(int i = 1; i<5; i++) {
	      System.out.println("YieldTestEx2 : " + i);
	    }
	  }
	}
