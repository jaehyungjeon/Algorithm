package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
	
	input			 
	3
	
	output
	1 2 3
	1 3 2
	2 1 3
	2 3 1
	3 1 2
	3 2 1
	
	Solution : 1. BackTracking 문제.
			   2. for문을 돌면서 depth 위치에 넣어줘야하는데 실수로 i에 넣고 있어서 동일 값이 출력되었었다..ㅎ
			   3. t/f를 통해 한번 방문했던 위치는 재탐색하지 않는다.

*/

public class BaekJoon_10974 {
	
	public static int N;
	public static int[] arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		
		dfs(0);
		
		System.out.println(sb.toString());
	}
	
	private static void dfs(int depth) {
		if(N == depth) {
			for(int i=0; i<N; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i+1;
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
}
