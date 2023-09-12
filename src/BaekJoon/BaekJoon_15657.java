package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

	N개의 자연수 중에서 M개를 고른 수열
	같은 수를 여러 번 골라도 된다.
	고른 수열은 비내림차순이어야 한다.
	길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
	
	input			 
	3 1
	4 5 2
	
	output
	2
	4
	5
	
	Solution : 1. BackTracking 문제.
			   2. for문을 넘겨주는 정수에서부터 시작되도록 한다.
			   3. 정수는 계속 증가하면서 같은 위치의 수는 탐색하지 않도록 한다.

*/

public class BaekJoon_15657 {

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
		
		dfs(0, 0);
		
		System.out.println(sb.toString());
	}
	
	private static void dfs(int at, int depth) {
		if(M == depth) {
			for(int i=0; i<M; i++) {
				sb.append(arr2[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		for(int i=at; i<N; i++) {
			arr2[depth] = arr[i];
			dfs(i, depth+1);
		}
	}

}
