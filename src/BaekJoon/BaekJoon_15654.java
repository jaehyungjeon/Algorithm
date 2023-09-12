package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

	N개의 자연수 중에서 M개를 고른 수열
	
	input			 
	3 1
	4 5 2
	
	output
	2
	4
	5
	
	Solution : 1. BackTracking 문제.
			   2. 이미 탐색한 길은 true처리 후 재귀가 풀리는 순간 false 처리

*/

public class BaekJoon_15654 {

	public static int N, M;
	public static int[] arr, arr2;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		arr2 = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 정렬
		Arrays.sort(arr);
		
		dfs(0);
		
		System.out.println(sb.toString());
	}
	
	private static void dfs(int depth) {
		if(M == depth) {
			for(int i=0; i<M; i++) {
				sb.append(arr2[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr2[depth] = arr[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}

}
