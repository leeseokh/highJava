package kr.or.ddit.basic;

public class T13_ThreadStopTest {		//
/*
 	Thread의 stop()메서드를 호출하면 쓰레드가 바로 멈춘다.
	이 때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어서 나중에 실행되는 프로그램에 영향을 줄 수 있다.
	그래서 현재는 stop()메서드는 비추천(deprecated) 되어있다.
 */
	
	
	public static void main(String[] args) {
		ThreadStopEx1 th = new ThreadStopEx1();
		th.start();
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		//th.stop();
		th.setStop(true);
	}
	
}
//방법 1
class ThreadStopEx1 extends Thread {
	  private boolean stop; // 멤버변수 자동 초기화됨. 초기화값: false

	  public void setStop(boolean stop) {	
	    this.stop = stop;
	  }

	  @Override
	  public void run() {
	    while(!stop) {
	      System.out.println("쓰레드 처리중...");
	    }
	    System.out.println("자원 정리중...");
	    System.out.println("실행 종료.");
	  }
	}

// interrupt()메서드를 이용하여 스레드를 멈추는 방법
/*
	방법 2 => sleep()메서드나 join()메서드 등을 사용했을 때
			interrupt() 메서드를 호출하면 interruptException이 	발생한다.
*/
class ThreadStopEx2 extends Thread{
	@Override
	public void run(){

		try {
			while(true) {
				System.out.println("쓰레드 처리중...");
				Thread.sleep(1);
			}
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		System.out.println("자원 정리 중...");
		System.out.println("실행종료.");
		}
	}
}
