package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 1 日は 24 時間である．

	整数 X が与えられる． X 日は何時間か求めよ．

	input			 
	3
	
	output
	72
	
	Solution : 1. N * 24
	
*/

public class BaekJoon_27327 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		System.out.println(N * 24);
	}

}
