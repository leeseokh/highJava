package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
//hash set 중복 허용 x
//숫자 섞어주기...

public class Baseball {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count =0;
		Set baseball = new HashSet(); 
		while(baseball.size() < 3) {
		
			baseball.add((int)(Math.random()*(9)+1));
		}
			List<Integer> num = new ArrayList<Integer>(baseball);
			System.out.println("랜덤수:" + baseball);
//			Collections.shuffle(baseball);
		System.out.println("숫자야구");
		
		int strike =0;
		int ball =0;
		int out =0;
		do {
			List<Integer> num1 = new ArrayList<Integer>();
			System.out.println("첫번째 숫자입력");
			num1.add(Integer.parseInt(sc.nextLine()));
			System.out.println("두번째 숫자입력");
			num1.add(Integer.parseInt(sc.nextLine()));
			System.out.println("세번째 숫자입력");
			num1.add(Integer.parseInt(sc.nextLine()));
			
			if(num1.get(0) == num.get(0)) {
				strike ++; 
				}
			else if(num1.get(0) == num.get(1)|| num1.get(0) == num.get(2)) {
				ball ++; 
				}
			else {
				out++;
			}
			if(num1.get(1) == num.get(1)) {
				strike ++; 
				}
			else if(num1.get(1) == num.get(2)&& num1.get(1) == num.get(0)) {
				ball ++; 
				}
			else {
				out++;
				}
			if(num1.get(2) == num.get(2)) {
				strike ++; 
				}
			else if(num1.get(2) == num.get(0)&& num1.get(2) == num.get(1)) {
				ball ++; 
				}
			else {
				out++;		
			}
	         System.out.println(strike+"S "+ ball+ "B "+ out+"O" );
	         count++;
	         if(strike==3) {
	            System.out.println(count + "번 만에 정답을 맞췄습니다");
	            break;
	         }
			
	         strike = 0;
	         ball = 0;
	         out = 0;
		}while(true);

	}

}
