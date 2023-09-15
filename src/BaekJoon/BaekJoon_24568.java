package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
	Question : A regular box of cupcakes holds 8 cupcakes, while a small box holds 3 cupcakes. 
	There are 28 students in a class and a total of at least 28 cupcakes. 
	Your job is to determine how many cupcakes will be left over if each student gets one cupcake.

	input			 
	2
	5
	
	output
	3
	
	Solution : 1. 초과분 계산
	
*/

public class BaekJoon_24568 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());
		BigInteger M = new BigInteger(br.readLine());
		
		BigInteger sum = N.multiply(new BigInteger("8")).add(M.multiply(new BigInteger("3")));
		System.out.println(sum.subtract(new BigInteger("28")));
	}

}
