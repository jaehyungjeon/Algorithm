package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 正の整数 X が与えられる．X を 21 で割った余りを出力せよ．

	input			 
	50
	
	output
	8
	
	Solution : 1. 
	
*/

public class BaekJoon_24078 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(N % 21);
	}

}
