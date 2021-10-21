package kr.or.ddit.basic;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**

 * 은행의 입출금을 스레드로 처리하는 예제

 * (lock 객체를 이용한 동기화 처리)

 * @author PC-18

 *

 */

public class T17_LockAccountTest {

/*
 * 락 기능을 제공하는 클래스
 * ReetrantLock : Read및 Write 구분없이 사용하기 위한 락 클래스로 동기화 처리를 위해 사용된다.
 */

	public static void main(String[] args) {
		// 락 객체 생성
		ReentrantLock lock = new ReentrantLock(true);
		LockAccount lAcc = new LockAccount(lock);
		lAcc.deposit(10000); //입금처리

		BankThread2 bth1 = new BankThread2(lAcc);

		BankThread2 bth2 = new BankThread2(lAcc);

		bth1.start();
		bth2.start();

	}

}

//입출금을 담당하는 클래스

class LockAccount{
	private int balance; //잔액
	//lock 객체 생성 -:>되도록이면 private final로 만든다.

	private final Lock lock;
	public LockAccount(Lock lock) {

		this.lock = lock;

	}
	public int getBalance() {

		return balance;

	}
	public void setBalance(int balance) {

		this.balance = balance;

	}
	public Lock getLock() {

		return lock;

	}
	public void deposit(int money) {

		//Lock 객체의 lock()메서드가 동기화 시작이고, unlock()메서드가 동기화의 끝을 나타낸다
		//lock()메서드로 동기화를 설정한 곳에서는 반드시 unlock()메서드로 해재해 주어야한다.
		lock.lock(); //시작(락을 획득하기 전까지 BLPCKED 됨)
		balance += money; //동기화 처리부분
		lock.unlock(); //해제

	}
	// 출금하는 메서드(출금성공 : true, 출금실패 : false반환)

	public boolean withdraw(int money) {
		lock.lock(); //락 획득
		boolean chk = false ;
		//try catch블럭을 사용할 경우에는 unlock()메서드 호출은 finally 블럭해서 하도록 한다.
		try {
			if(balance >= money) {
				for(int i = 1; i<=1000000000; i++) {}
				balance -= money;

				System.out.println("메서드 안에서 balance = " + getBalance());

				chk = true;
			}
		}catch (Exception e) {
				chk =false ;
		}finally {
			lock.unlock();//락 해제(반납)
		}
		return chk;
	}

}

//은행업무 처리하는 스레드
class BankThread2 extends Thread{
	private LockAccount lAcc;

	public BankThread2(LockAccount lAcc) {
		this.lAcc =lAcc;
	}

	@Override

	public void run() {

		boolean result = lAcc.withdraw(6000);

		System.out.println("스레드 안에서 result = " + result +",balance");

	}

}

 