package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

	아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다. 
	
	input			 
	9
	
	output
	55
	
	Solution : 1. 점화식 dp[n] = dp[n-1] + dp[n-2];
			   2. dp[1] = 1, dp[2] = 2, dp[3] = 3, ...

*/

public class BaekJoon_11726 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		
		System.out.println(dp[N]);
	}

}
