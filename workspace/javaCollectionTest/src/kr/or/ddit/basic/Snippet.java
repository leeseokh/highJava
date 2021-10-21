package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Snippet {
	public static void main(String[] args) {
	      Set hs1 = new HashSet();
	      int count = 0;
	      while(hs1.size()!=3) {
	         hs1.add((int) (Math.random() * 9 + 1));   
	      }
	      
	      List<Integer> num = new ArrayList<Integer>(hs1);
	      System.out.println("랜덤 수 : " + hs1);
	      
	      
	      Scanner a = new Scanner(System.in);
	     
	      System.out.println("〓〓〓〓〓〓 숫자게임 〓〓〓〓〓〓");
	
	      int stcount = 0;
	      int ballcount = 0;
	      int outcount = 0;
	      do {
	         List<Integer> inputNum = new ArrayList<Integer>();
	         System.out.println("첫번째 숫자를 입력해주세요 : ");
	         inputNum.add(Integer.parseInt(a.nextLine()));
	         System.out.println("두번째 숫자를 입력해주세요 : ");
	         inputNum.add(Integer.parseInt(a.nextLine()));
	         System.out.println("세번째 숫자를 입력해주세요 : ");
	         inputNum.add(Integer.parseInt(a.nextLine()));
	         

	         if(inputNum.get(0) == num.get(0)){
	            stcount++;
	         }else if(inputNum.get(0)==num.get(1)||inputNum.get(0)==num.get(2)){
	            ballcount++;
	         }else {
	            outcount++;
	         }
	         if(inputNum.get(1) == num.get(1)){
	            stcount++;
	         }else if(inputNum.get(1)==num.get(0)||inputNum.get(1)==num.get(2)){
	            ballcount++;
	         }else {
	            outcount++;
	         }
	         if(inputNum.get(2) == num.get(2)){
	            stcount++;
	         }else if(inputNum.get(2)==num.get(1)||inputNum.get(2)==num.get(0)){
	            ballcount++;
	         }else {
	            outcount++;
	         }
	      
	         System.out.println("〓〓〓   "+ stcount+"S "+ ballcount + "B "+ outcount+"O 입니다 〓〓〓" );
	         count++;
	         if(stcount==3) {
	            System.out.println(count + "번 만에 정답을 맞췄습니다");
	            break;
	         }
	         stcount = 0;
	         ballcount = 0;
	         outcount = 0;
	         
	      }while(true);
	      
	      
	   }
}

