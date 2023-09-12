package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

	N개의 자연수 중에서 M개를 고른 수열
	고른 수열은 오름차순이어야 한다.
	
	input			 
	4 2
	9 8 7 1
	
	output
	1 7
	1 8
	1 9
	7 8
	7 9
	8 9
	
	Solution : 1. BackTracking 문제.
			   2. 시작되는 값의 위치보다 이전값을 넣을 필요가 없으므로 for문의 시작점을 변경해준다.
			   3. 넘겨오는 정수의 시작값의 +1을 해줌으로서 다음 위치를 탐색하도록 지시한다.

*/

public class BaekJoon_15655 {

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
			dfs(i+1, depth+1);
		}
	}

}
