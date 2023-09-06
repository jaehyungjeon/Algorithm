package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

	input			 
	24 18
	
	output
	6
	72
	
	Solution : 1. 최대공약수 로직은 간단하다.
			   2. 최소공배수는 두 곱에서 최대공약수를 나눠주면 된다.
	
*/

public class BaekJoon_2609 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int gcd = gcd(N, M);
		System.out.println(gcd);
		System.out.println(N * M / gcd);
	}
	
	private static int gcd(int N, int M) {
		while(M > 0) {
		    int temp = M;
	        M = N % M;
	        N = temp;
		}
		
		return N;
	}

}
