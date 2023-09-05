package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 춘향이는 편의점 카운터에서 일한다.

	손님이 2원짜리와 5원짜리로만 거스름돈을 달라고 한다. 2원짜리 동전과 5원짜리 동전은 무한정 많이 가지고 있다. 
	동전의 개수가 최소가 되도록 거슬러 주어야 한다. 거스름돈이 n인 경우, 최소 동전의 개수가 몇 개인지 알려주는 프로그램을 작성하시오.
	
	예를 들어, 거스름돈이 15원이면 5원짜리 3개를, 거스름돈이 14원이면 5원짜리 2개와 2원짜리 2개로 총 4개를, 거스름돈이 13원이면 5원짜리 1개와 2원짜리 4개로 총 5개를 주어야 동전의 개수가 최소가 된다.

	input			 
	13
	
	output
	5
	
	Solution : 1. 작은것 부터 누산하면 될 듯. 

*/

public class BaekJoon_14916 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(true) {
			if(N == 1 || N == 0) {
				break;
			}
			
			if(N%5 == 0) {
				count += N/5;
				N %= 5;
			} else {
				count += 1;
				N -= 2;
			}
		}
		
		if(N == 1) {
			System.out.println(-1);
		} else if(N == 0) {
			System.out.println(count);
		}
		
	}

}
