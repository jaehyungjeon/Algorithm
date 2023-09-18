package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.

	사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.

	input			 
	3 10
	1
	2
	5
	
	output
	10
	
	Solution : 1. dp를 이용하여 푸는 문제.
			   2. 중복을 제거하면서 가야 하므로 dp를 이용해 점프를 시킨다.
	
*/

public class BaekJoon_2293 {

	public static int N, K;
	public static int[] arr, dp;
	public static int count = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		dp = new int[K+1];
		dp[0] = 1;
		
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for(int j=arr[i]; j<=K; j++) {
				dp[j] += dp[j - arr[i]];
			}
		}
		
		System.out.println(dp[K]);
	}
}
