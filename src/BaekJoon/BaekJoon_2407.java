package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
	Question : nCm을 출력한다.
	
	input			 
	100 6
	
	output
	1192052400
	
	Solution : 1. dp를 생각했으나 큰 자연수를 다뤄야 하므로 BigInteger로 접근.

*/

public class BaekJoon_2407 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		BigInteger sum = BigInteger.ONE;
		BigInteger div = BigInteger.ONE;
		
		for(int i=0; i<M; i++) {
			sum = sum.multiply(new BigInteger(String.valueOf(N-i)));
			div = div.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(sum.divide(div));
	}

}
