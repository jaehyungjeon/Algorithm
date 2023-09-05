package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오. 배열의 (i, j) 위치는 i행 j열을 나타낸다.

	input			 
	2 3
	1 2 4
	8 16 32
	3
	1 1 2 3
	1 2 1 2
	1 3 2 3
	
	output
	63
	2
	36
	
	Solution : 1. 부분합으로 구하는 것으로 하였다.
			   2. 배열의 누적 범위를 잘 파악하여 도출하여야 한다. 예를 들면, 3개의 배열이 들어왔을 경우 (1,1) (3,2) 까지는 1~3 행의 모든 누적값이 계산되어야 한다.
			   3. 따라서 for문을 통해 계산값을 계속 누산한다.

*/

public class BaekJoon_2167 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		int x1, y1;
		int x2, y2;
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine());
			long sum = 0;
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			for(int i=x1-1; i<=x2-1; i++) {
				sum += (arr[i][y2] - arr[i][y1-1]); 
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
			
	}

}
