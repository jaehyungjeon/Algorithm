package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

	이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
	
	n=17일때 까지 피보나치 수를 써보면 다음과 같다.
	
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
	
	n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

	input			 
	10
	
	output
	55
	
	Solution : 1. dp가 빨라서 dp로 구현.

*/

public class BaekJoon_2747 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N]);
	}

}
