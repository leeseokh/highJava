package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LOTTO {

	public static void main(String[] args) {
		/*
		  로또를 구매하는 프로그램 작성하기 사용자는 로또를 구매할 때 구매할 금액을 입력하고 입력한 금액에 맞게 로또번호를 출력한다.
		  (단, 로또 한장의 금액은 1000원이고 거스름돈도 계산하여 출력한다.)

	==========================
         Lotto 프로그램
	--------------------------
	 1. Lotto 구입
	  2. 프로그램 종료
	==========================		 
	메뉴선택 : 1  <-- 입력
			
	 Lotto 구입 시작
		 
	(1000원에 로또번호 하나입니다.)
	금액 입력 : 2500  <-- 입력
			
	행운의 로또번호는 아래와 같습니다.
	로또번호1 : 2,3,4,5,6,7
	로또번호2 : 20,21,22,23,24,25
			
	받은 금액은 2500원이고 거스름돈은 500원입니다.
			
   	 ==========================
         Lotto 프로그램
	--------------------------
	  1. Lotto 구입
	  
	  2. 프로그램 종료
	==========================		 
	메뉴선택 : 2  <-- 입력
		
	감사합니다
		 
		 */
		


		Scanner sc = new Scanner(System.in);

		System.out.println("=================");
		System.out.println("Lotto 프로그램");
		System.out.println("-----------------");
		System.out.println("1.Lotto 구입");
		System.out.println("2.프로그램 종료");
		System.out.println("=================");
		System.out.println("메뉴 선택 >>");
		int select = sc.nextInt();

		switch (select) {

		case 1:
			lottoBuy();
			break;

		case 2:
			System.out.println("감사합니다. 종료됐습니다.");
			System.exit(0);
			break;
		}
	}

	public static void lottoBuy() {
		Scanner sc = new Scanner(System.in);

		System.out.println("로또 한장은 1000원 입니다.");

		System.out.println("금액입력: ");
		int input = sc.nextInt();
		int output = input % 1000;
		int count = input / 1000;

		if (input > 1000) {
			for (int i = 0; i < count; i++) {

				Set lotto = new HashSet();
				while (lotto.size() < 6) {
					int Lottery = (int) (Math.random() * 45) + 1;
					lotto.add(Lottery);
				}
				System.out.println("행운의 로또 번호는 아래와 같습니다.");
				System.out.println("로또번호"+ (i+1) + lotto);
			}

			System.out.println("받은 금액은 " + input + "원 거스름돈은 "  + output + "원 입니다.");
			System.out.println("구매하신 복권은" + count + "장입니다.");

		}
		
	

	}
}
