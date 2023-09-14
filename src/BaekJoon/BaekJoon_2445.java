package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 첫째 줄에는 별 2×N-1개, 둘째 줄에는 별 2×N-3개, ..., N번째 줄에는 별 1개를 찍는 문제
	
	별은 가운데를 기준으로 대칭이어야 한다.

	input			 
	5
	
	output
	*        *
	**      **
	***    ***
	****  ****
	**********
	****  ****
	***    ***
	**      **
	*        *
	
	Solution : 1. 별찍기 왤케 많은거야...

*/

public class BaekJoon_2445 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<2*N-1; i++) {
			if(i < N) {
				for(int j=0; j<i+1; j++) {
					System.out.print("*");
				}
				for(int j=i+1; j<2*N-i-1; j++) {
					System.out.print(" ");
				}
				for(int j=2*N-i-2; j<2*N-1; j++) {
					System.out.print("*");
				}
				System.out.println();
			} else {
				for(int j=0; j<2*N-i-1; j++) {
					System.out.print("*");
				}
				for(int j=2*N-i-1; j<i+1; j++) {
					System.out.print(" ");
				}
				for(int j=2*N-1; j>i; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
