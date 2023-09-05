package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : 정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.

	input			 
	2 2
	3 5
	2 9
	
	output
	2 3 5 9
	
	Solution : 1. 해당 열끼리 비교하여 정렬하는 것이 아닌 전체의 오름차순 정렬.
			   2. 배열에 담고 Arrays.sort를 이용...
			   3. 한번에 쭉 담아주는게 편하다.

*/

public class BaekJoon_11728 {
	
	public static long[] arr;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new long[N+M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=N; i<M+N; i++) {
			arr[i] = Long.parseLong(st.nextToken()); 
		}
		
		Arrays.sort(arr);
		
		for(long t : arr) {
			sb.append(t).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}