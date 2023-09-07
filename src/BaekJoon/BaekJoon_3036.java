package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 상근이는 창고에서 링 N개를 발견했다. 상근이는 각각의 링이 앞에 있는 링과 뒤에 있는 링과 접하도록 바닥에 내려놓았다. 

	상근이는 첫 번째 링을 돌리기 시작했고, 나머지 링도 같이 돌아간다는 사실을 발견했다. 
	나머지 링은 첫 번째 링 보다 빠르게 돌아가기도 했고, 느리게 돌아가기도 했다. 
	이렇게 링을 돌리다 보니 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 도는지 궁금해졌다.
	
	링의 반지름이 주어진다. 이때, 첫 번째 링을 한 바퀴 돌리면, 나머지 링은 몇 바퀴 돌아가는지 구하는 프로그램을 작성하시오.

	input			 
	3
	8 4 2
	
	output
	2/1
	4/1
	
	Solution : 1. 수의 규칙을 보니 최대공약수로 나눈 몫을 나타내주는 형태이다.
			   2. (N/최대공약수) / (M/최대공약수)로 생각하면 된다.
			   3. i=1 부터 돌려주면 N-1번 순회한다.
	
*/

public class BaekJoon_3036 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			int gcd = getGcd(arr[0], arr[i]);
			int lValue = (arr[0] / gcd);
			int rValue = (arr[i] / gcd);
			
			sb.append(lValue).append("/").append(rValue).append("\n");
		} 
		
		System.out.println(sb.toString());
	}

	private static int getGcd(int N, int M) {
		while(M > 0) {
			int temp = M;
			M = N % M;
			N = temp;
		}
		
		return N;
	}
}
