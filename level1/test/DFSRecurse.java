package test;

import java.util.Scanner;

public class DFSRecurse {

	public static int[] arr;
	public static int N, M;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt(); // 받을 인자
		M = in.nextInt();
		
		arr = new int[M];
		
		//DFS
		DFS(1, 0);
	}
	
	public static void DFS(int at, int depth) {
		if(M == depth) {
			for(int val : arr) {
				System.out.print(val + " ");
			}
			
			System.out.println();
			return;
		}
		
		for(int i=at; i<=N; i++) {
			arr[depth] = i;
			
			DFS(i+1, depth+1);
		}
	}
}
