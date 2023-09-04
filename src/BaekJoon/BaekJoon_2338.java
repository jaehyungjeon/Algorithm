package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
	Question : 두 수 A, B를 입력받아, A+B, A-B, A×B를 구하는 프로그램을 작성하시오.

	input			 
	1
	-1

	output
	0
	2
	-1
	 
	Solution : 1. 이것도 BigInteger 사용해야 런타임에러가 나지 않음.
	
*/

public class BaekJoon_2338 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger A = new BigInteger(br.readLine());
		BigInteger B = new BigInteger(br.readLine());
		
		System.out.println(A.add(B));
		System.out.println(A.subtract(B));
		System.out.println(A.multiply(B));
	}

}
