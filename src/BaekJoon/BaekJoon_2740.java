package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램을 작성하시오.

	input			 
	3 2
	1 2
	3 4
	5 6
	2 3
	-1 -2 0
	0 0 3
	
	output
	-1 -2 6
	-3 -6 12
	-5 -10 18
	
	Solution : 1. 행렬의 곱을 구하면 된다.
			   2. 일단 전체적으로 첫번째 행렬의 행만큼 돌리므로 N만큼 반복한다.
			   3. 안에서 다음 행렬의 열만큼 반복한다.
			   4. 그 안에서 이전 행렬의 열만큼 반복하여 계산한다.
			   5. 계산 과정에서 sum을 초기화 한다.

*/

public class BaekJoon_2740 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] arr2 = new int[K][T];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<T; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<T; j++) {
				int sum = 0;
				for(int k=0; k<M; k++) {
					sum += arr[i][k] * arr2[k][j];
				}
				sb.append(sum).append(' ');
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
