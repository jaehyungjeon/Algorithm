package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.

	input			 
	3
	4 10 20 30 40
	3 7 5 12
	3 125 15 25
	
	output
	70
	3
	35
	
	Solution : 1. 각 쌍의 최대공약수의 합
			   2. 리스트 안에 배열을 꽂아 for문을 돌리는 방안이 쉬울 것 같아서 채택하였다.
			   3. gcd합을 담는 sum이 정수(int)로 하니 메모리 초과가 되었다.
			   4. long타입으로 변경하고 각 자릿수의 gcd합을 구하였다.

*/

public class BaekJoon_9613 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<int[]>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tokenLen = Integer.parseInt(st.nextToken());
			int arr[] = new int[tokenLen];
			for(int j=0; j<tokenLen; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			list.add(arr);
		}

		for(int[] t: list) {
			long sum = 0;
			for(int i=0; i<t.length; i++) {
				for(int j=i+1; j<t.length; j++) {
					sum += getGcd(t[i], t[j]);
				}
			}
			sb.append(sum + "\n");
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
