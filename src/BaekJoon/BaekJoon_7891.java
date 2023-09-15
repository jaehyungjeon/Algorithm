package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
	Question : Given two integers, calculate and output their sum.
	
	input			 
	4
	-100 100
	2 3
	0 110101
	-1000000000 1
	
	output
	0
	5
	110101
	-999999999
	
	Solution : 1. BigInteger 사용
	
*/

public class BaekJoon_7891 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigInteger A = new BigInteger(st.nextToken());
			BigInteger B = new BigInteger(st.nextToken());
			
			System.out.println(A.add(B));
		}
	}

}
