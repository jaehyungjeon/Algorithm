package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
	Question : Write a program that computes a product of two non-negative integers A and B. 
	The integers are represented in decimal notation and have N and M digits, respectively.
	
	input			 
	3 4
	123
	4567
	
	output
	561741
	
	Solution : 1. BigInteger 사용.
	
*/

public class BaekJoon_22193 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		BigInteger A = new BigInteger(br.readLine());
		BigInteger B = new BigInteger(br.readLine());
		
		System.out.println(A.multiply(B));
	}

}
