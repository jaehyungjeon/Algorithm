package test;

import java.util.Scanner;

public class DFSBuilder {

	public static int[] arr;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder(); // 연속된 String Insert
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt(); // 받을 인자
		M = in.nextInt();
		
		arr = new int[M];
		
		//DFS
		DFS(1, 0);
		System.out.print(sb);
	}
	
	public static void DFS(int at, int depth) {
		if(M == depth) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			
			sb.append("\n");
			return;
		}
		
		for(int i=at; i<=N; i++) {
			arr[depth] = i;
			
			DFS(i+1, depth+1);
		}
	}
}
