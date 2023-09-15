package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
	Question : 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

	input			 
	1 2
	
	output
	3
	
	Solution : 1. BigInteger로 계산 
	
*/

public class BaekJoon_15740 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger N = new BigInteger(st.nextToken());
		BigInteger M = new BigInteger(st.nextToken());
		
		System.out.println(N.add(M));
	}

}
