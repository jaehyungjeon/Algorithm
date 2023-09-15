package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 2 つの整数 A, B が与えられる．

	A と B の大小を比較し，A ＜ B ならば -1 を，A ＝ B ならば 0 を，A ＞ B ならば 1 を出力せよ．

	input			 
	3
	7
	
	output
	-1    
	
	Solution : 1. 단순 비교문
	
*/

public class BaekJoon_27328 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		if(N > M) {
			System.out.println(1);
		} else if(N == M) {
			System.out.println(0);
		} else {
			System.out.println(-1); 
		}

	}

}
