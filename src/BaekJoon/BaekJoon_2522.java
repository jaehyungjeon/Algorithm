package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

	input			 
	3
	
	output
	  *
	 **
	***
	 **
	  *
	
	Solution : 1. 나눠서 찍으면 편리하다.

*/

public class BaekJoon_2522 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<N-i; j++) {
				System.out.print(" ");
			}
			for(int j=N-i; j<N; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
 
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<N-i; j++) {
				System.out.print(" ");
			}
			for(int j=N-i; j<N; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
