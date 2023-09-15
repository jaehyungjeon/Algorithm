package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : A mathematician has stolen your calculator! Luckily, you know how to code and can write a program that adds together numbers. 
	Write a program that adds together a list of integers.

	input			 
	3
	1
	2
	3

	output
	6
	
	Solution : 1. 단순 계산
			   2. 누적합으로 계산해보자.
	
*/

public class BaekJoon_26545 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		arr[0] = Integer.parseInt(br.readLine());
		for(int i=1; i<N; i++) {
			int val = Integer.parseInt(br.readLine());
			arr[i] += (arr[i-1] + val);
		}
		
		System.out.println(arr[N-1]);
	}

}
