package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제

	하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.

	input			 
	5
	
	output
	*****
	 ****
	  ***
	   **
	    *
	
	Solution : 1. 머리를 비우기 위해 쉬운거 풀어봤다..^^
			   2. 2개로 나누면 쉽다~
	
*/

public class BaekJoon_2441 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=i; j<N; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
