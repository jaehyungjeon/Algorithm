package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

	input			 
	5
	
	output
	*********
	 *******
	  *****
	   ***
	    *
	   ***
	  *****
	 *******
	*********
	
	Solution : 1. 직접 시작점 찾기가 귀찮긴 해도 무난한 문제.

*/

public class BaekJoon_2446 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<2*N-1; i++) {
			if(i < N) { // 내려가는 삼각형
				for(int j=0; j<i; j++) {
					System.out.print(" ");
				}
				for(int j=i; j<2*N-i-1; j++) {
					System.out.print("*");
				}
				System.out.println();
			} else { // 올라가는 삼각형
				for(int j=0; j<2*N-i-2; j++) {
					System.out.print(" ");
				}
				for(int j=2*N-i-2; j<i+1 ; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
