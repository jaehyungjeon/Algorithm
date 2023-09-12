package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

	N개의 자연수 중에서 M개를 고른 수열
	같은 수를 여러 번 골라도 된다.
	
	input			 
	4 2
	9 8 7 1
	
	output
	1 1
	1 7
	1 8
	1 9
	7 1
	7 7
	7 8
	7 9
	8 1
	8 7
	8 8
	8 9
	9 1
	9 7
	9 8
	9 9
	
	Solution : 1. BackTracking 문제.
			   2. 모든 백트래킹 케이스를 담아주면 된다. 시작점의 위치나 방문노드 재탐색을 조건으로 걸 필요가 없이 바로 depth위치에 값을 꽂아준다.

*/

public class BaekJoon_15656 {

	public static int N, M;
	public static int[] arr, arr2;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		arr2 = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 오름차순으로 정렬
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
			arr2[depth] = arr[i];
			dfs(depth+1);
		}
	}

}
