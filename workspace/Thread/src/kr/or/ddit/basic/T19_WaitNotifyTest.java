package kr.or.ddit.basic;

public class T19_WaitNotifyTest {
/*
 	wait()메서드: 동기화 영역에서 락을 풀고 Wait-Set영역(공유객체별 존재)으로 이동시킨다

	notify() 또는 notifyAll() 메서드: Wait-Set영역에 있는 쓰레드를 깨워서 실행 될수 있도록 한다.run()
	(notify()는 하나, notifyAll()은 Wait-Set에 있는 전부를 깨운다)
	=>wait()과 notify(), notifyAll 메서드는 동기화 영역에서만 실행 할 수 있고, Object 클래스에서 제공하는 메서드이다
 */
	public static void main(String[] args) {
		// 4.공유객체
		WorkObject workObj = new WorkObject();

		// 5.쓰레드 호출
		Thread tha = new ThreadA(workObj);
		Thread thb = new ThreadB(workObj);

		// A작업 중 -> wait() -> 대기실 아무도 없음 -> WaitSet(Lock해제하고)
		// B작업 시작 -> notify() -> waitSet속에 A깨움 -> run()

		tha.start();
		thb.start();
	}
}

//공유 객체

class WorkObject {
	public synchronized void methodA() {
		System.out.println("methodA()에서 작업 중...");

		notify();

		try {
			wait(); // lock을 풀고 wait-set영역으로 이동
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public synchronized void methodB() {
		System.out.println("methodB()에서 작업 중...");

		notify();

		try {
			wait(); // lock을 풀고 wait-set영역으로 이동
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}

// WorkObject의 methodA()메서드만 호출하는 스레드
class ThreadA extends Thread {
	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			workObj.methodA();
		}
		System.out.println("ThreadA 종료");
	}// run
}// class

class ThreadB extends Thread {
	private WorkObject workObj;

	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			workObj.methodB();
		}
		System.out.println("ThreadB 종료");
	}// run
}// class