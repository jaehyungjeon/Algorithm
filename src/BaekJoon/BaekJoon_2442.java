package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2×N-1개를 찍는 문제

	별은 가운데를 기준으로 대칭이어야 한다.
	
	input			 
	5
	
	output
	    *
	   ***
	  *****
	 *******
	*********
	
	Solution : 1. 수 계산만 해주면 됨.
	
*/

public class BaekJoon_2442 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) { // 행
			for(int j=N-i-1; j>0; j--) {
				System.out.print(" ");
			}
			for(int j=N-i; j<=N+i; j++) {
				System.out.print("*");
			}
			for(int j=N+i+1; j<2*N; j++) {
				System.out.print("");
			}
			
			System.out.println();
		}
	}

}
