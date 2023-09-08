package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

	1+1+1+1
	1+1+2
	1+2+1
	2+1+1
	2+2
	1+3
	3+1
	정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
	
	input			 
	3
	4
	7
	10
	
	output
	7
	44
	274
	
	Solution : 1. 1 = 1, 2 = 2, 3 = 4, 4 = 7, 5 = 13 ...
			   2. 점화식이 dp[i] = dp[i-3] + dp[i-2] + dp[i-1] 이다.
			   3. dp를 활용한 점화식 문제.

*/

public class BaekJoon_9095 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[11];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4; i<=10; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			sb.append(dp[num]).append("\n");
		}

		System.out.println(sb.toString());
	}

}
