package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
	Question : 一辺の長さが x cm の立方体の体積は (x × x × x) cm3 である．

	整数 X が与えられる．一辺の長さが X cm の立方体の体積は何 cm3 か求めよ．
	
	input			 
	4
	
	output
	64
	
	Solution : 1. 3번 곱하면 됨.
	
*/

public class BaekJoon_24082 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger N = new BigInteger(br.readLine());
		
		System.out.println(N.multiply(N).multiply(N));
	}

}
