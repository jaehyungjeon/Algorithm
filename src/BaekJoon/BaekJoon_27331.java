package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 2 つの数字 A, B が与えられる．

	十の位が A であり，一の位が B である 2 桁の正の整数を出力せよ．

	input			 
	2
	2
	
	output
	22
	
	Solution : 1. 단어 이어붙이기.
	
*/

public class BaekJoon_27331 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br.readLine().concat(br.readLine()));
	}

}
